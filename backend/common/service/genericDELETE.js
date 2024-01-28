// Generic DELETE controller function
// backend/module/_shared/service/genericDELETE.js

// Dependencies
const { HTTP_STATUS_OK,
        HTTP_STATUS_INTERNAL_SERVER_ERROR,
        HTTP_STATUS_BAD_REQUEST } = require('../../common/constant/http_code_list');

const { logDELETEControllerError } = require('../../module/logger/service/loggerError'); 

/**
 * Generic controller for handling DELETE operations.
 * @param {Function} operationFunction - The function responsible for the specific DELETE operation logic.
 * @param {Object} propertyMapping - Mapping of expected properties to their corresponding keys in the request body.
 * @param {Function} logFunction - The function responsible for logging errors.
 * @returns {Function} Express route handler.
 */
function genericDELETE(operationFunction, propertyMapping, logFunction) {
    return async function deleteOperationHandler(req, res) {
        try {
            const requestBody = {};

            // Expected properties
            for (const [property, key] of Object.entries(propertyMapping)) {
                if (req.body[key] === undefined) { // missing property in request body
                    
                    return res.status(HTTP_STATUS_BAD_REQUEST).json({
                        error: 'Bad Request',
                        details: `Missing property in request body: ${key}`,
                    });
                }
                requestBody[property] = req.body[key];
            }

            const operationResult = await operationFunction(requestBody);

            if (operationResult.success) {
                return res.status(HTTP_STATUS_OK).json({
                    message: `${operationResult.operation} operation successful`,
                    data: operationResult.data,
                });
            } else {
                logFunction({
                    message: `Error performing ${operationResult.operation} operation`,
                    error: operationResult.error,
                    requestBody: req.body,
                });
            
                return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({
                    error: operationResult.error,
                });
            }
            
        } catch (error) {
            
            logDELETEControllerError({
                message: `Unhandled error in ${operationFunction.name} controller`,
                error: error,
                requestBody: req.body,
            });

            return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({ 
                error: 'Internal Server Error' 
        });
        }
    };
}

module.exports = {
    genericDELETE,
};