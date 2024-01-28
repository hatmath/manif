// Generic GET controller function
// backend/module/_shared/service/genericGET.js

// Dependencies
const {
    HTTP_STATUS_OK,
    HTTP_STATUS_INTERNAL_SERVER_ERROR,
    HTTP_STATUS_BAD_REQUEST,
} = require('../../common/constant/http_code_list');

const {
    logGETControllerError,
} = require('../../module/logger/service/loggerError');

/**
 * Generic controller for handling GET operations.
 * @param {Function} operationFunction - The function responsible for the specific GET operation logic.
 * @param {Object} propertyMapping - Mapping of expected properties to their corresponding keys in the request query.
 * @param {Function} logFunction - The function responsible for logging errors.
 * @returns {Function} Express route handler.
 */
function genericGET(operationFunction, propertyMapping, logFunction) {
    return async function getOperationHandler(req, res) {
        try {
            console.log('genericGET: Request received with query parameters:', req.query);

            const requestQuery = {};

            // Populate the requestQuery object with expected properties from query parameters
            for (const [property, key] of Object.entries(propertyMapping)) {
                if (req.query[key] === undefined) {
                    // Handle missing property in the request
                    console.log(`genericGET: Missing property in request: ${key}`);
                    return res.status(HTTP_STATUS_BAD_REQUEST).json({
                        error: 'Bad Request',
                        details: `Missing property in request: ${key}`,
                    });
                } else {
                    requestQuery[property] = req.query[key];
                }
            }

            console.log('genericGET: requestQuery after populating:', requestQuery);

            const operationResult = await operationFunction(requestQuery);

            console.log('genericGET: Operation result:', operationResult);

            if (operationResult.success) {
                return res.status(HTTP_STATUS_OK).json({
                    message: `${operationResult.operation} operation successful`,
                    data: operationResult.data,
                });
            } else {
                logFunction({
                    message: `Error performing ${operationResult.operation} operation`,
                    error: operationResult.error,
                    requestQuery: req.query,
                });

                return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({
                    error: 'Internal Server Error',
                    details: operationResult.details,
                });
            }
        } catch (error) {
            console.error('genericGET: Unexpected error:', error);

            logGETControllerError({
                message: `Unhandled error in ${operationFunction.name} controller`,
                error: error,
                requestQuery: req.query,
            });

            return res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({ 
                error: 'Internal Server Error' 
            });
        }
    };
}

module.exports = {
    genericGET,
};

