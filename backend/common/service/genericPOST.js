// Generic POST controller function
// backend/module/_shared/service/genericPOST.js

// Dependencies
const { HTTP_STATUS_OK,
        HTTP_STATUS_INTERNAL_SERVER_ERROR,
        HTTP_STATUS_BAD_REQUEST } = require('../../common/constant/http_code_list');

const { logPOSTControllerError } = require('../../module/logger/service/loggerError');

/**
 * Generic controller for handling POST operations.
 * @param {Function} operationFunction - The function responsible for the specific POST operation logic.
 * @param {Object} propertyMapping - Mapping of expected properties to their corresponding keys in the request body.
 * @param {Function} logFunction - The function responsible for logging errors.
 * @returns {Function} Express route handler.
 */

function genericPOST(operationFunction, propertyMapping, logFunction) {
    return async function postOperationHandler(req, res) {
        try {
            const requestBody = {};

            console.log('Request Body:', req.body);

            // Expected properties
            for (const [property, key] of Object.entries(propertyMapping)) {
                if (req.body[key] === undefined) {
                    // Handle missing property in the request body
                    console.log(`Missing property in request body: ${key}`);
                    return res.status(HTTP_STATUS_BAD_REQUEST).json({
                        error: 'Bad Request',
                        details: `Missing property in request body: ${key}`,
                    });
                } else {
                    requestBody[property] = req.body[key];
                }
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
            logPOSTControllerError({
                message: `Unhandled error in ${operationFunction.name} controller`,
                error: error,
                stackTrace: error.stack, // Include stack trace for better debugging
                requestBody: req.body,
            });

            return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({ 
                error: 'Internal Server Error' 
            });
        }
    };
}

module.exports = {
    genericPOST,
};
