// Generic PATCH controller function
// backend/module/_shared/service/genericPATCH.js

// Dependencies
const {
    HTTP_STATUS_OK,
    HTTP_STATUS_INTERNAL_SERVER_ERROR,
    HTTP_STATUS_BAD_REQUEST,
} = require('../../common/constant/http_code_list');

const {
    logPATCHControllerError,
} = require('../../module/logger/service/loggerError');

/**
 * Generic controller for handling PATCH operations.
 * @param {Function} operationFunction - The function responsible for the specific PATCH operation logic.
 * @param {Object} propertyMapping - Mapping of expected properties to their corresponding keys in the request body.
 * @param {Function} logFunction - The function responsible for logging errors.
 * @returns {Function} Express route handler.
 */
function genericPATCH(operationFunction, propertyMapping, logFunction) {
    return async function patchOperationHandler(req, res) {
        try {
            console.log('Incoming PATCH request body:', req.body);

            const requestBody = {};

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

            console.log('Mapped request body:', requestBody);

            const operationResult = await operationFunction(requestBody);

            if (operationResult.success) {
                console.log(`${operationResult.operation} operation successful`);
                return res.status(HTTP_STATUS_OK).json({
                    message: `${operationResult.operation} operation successful`,
                    data: operationResult.data,
                });
            } else {
                console.error(`Error performing ${operationResult.operation} operation`, operationResult.error);
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
            console.error(`Unhandled error in ${operationFunction.name} controller`, error);
            logPATCHControllerError({
                message: `Unhandled error in ${operationFunction.name} controller`,
                error: error,
                requestBody: req.body,
            });

            return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({
                error: 'Internal Server Error',
            });
        }
    };
}


module.exports = {
    genericPATCH,
};
