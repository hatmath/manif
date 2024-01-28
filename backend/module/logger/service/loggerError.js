// Error related log entry functions
// backend\module\logger\service\loggerError.js

// Dependencies
const LogError = require('../model/LogError');
const { logEntry } = require('./_logger');

// Error log functions
module.exports = {
    // Logger test function
    logErrorTest: (data) => logEntry(LogError, data, 'debug', 'Test for error log entry.'),
    
    // System errors
    logSystemError: (data) => logEntry(LogError, data, 'error', 'System Error!'),

    // Authentication errors
    logAuthError : (data) => logEntry(LogError, data, 'error', 'Authentication system Error!'),

    // Generic CRUD errors
    logCreateError: (data) => logEntry(LogError, data, 'error', 'Generic CREATE service error'),
    logReadError: (data) => logEntry(LogError, data, 'error', 'Generic READ service error'),
    logUpdateError: (data) => logEntry(LogError, data, 'error', 'Generic UPDATE service error'),
    logDeleteError: (data) => logEntry(LogError, data, 'error', 'Generic DELETE service error'),

    // Generic controller errors
    logDELETEControllerError: (data) => logEntry(LogError, data, 'error', 'Generic DELETE controller error'),
    logGETControllerError: (data) => logEntry(LogError, data, 'error', 'Generic GET controller error'),
    logPATCHControllerError: (data) => logEntry(LogError, data, 'error', 'Generic PATCH controller error'),
    logPOSTControllerError: (data) => logEntry(LogError, data, 'error', 'Generic POST controller error'),
    logPUTControllerError: (data) => logEntry(LogError, data, 'error', 'Generic PUT controller error'),

    // Function errors
        // Slogan
    logCreateSloganError: (data) => logEntry(LogError, data, 'error', 'Create Slogan function error'),
    logFindSloganError: (data) => logEntry(LogError, data, 'error', 'Find Slogan function error'),

        // Manif
    logCreateManifError: (data) => logEntry(LogError, data, 'error', 'Create Manif function error'),
    logUpdateManifError: (data) => logEntry(LogError, data, 'error', 'Update Manif function error'),
    logFindManifError: (data) => logEntry(LogError, data, 'error', 'Find Manif function error'),

        // Interest
    logCreateInterestError: (data) => logEntry(LogError, data, 'error', 'Create Interest function error'),
    logFindInterestError: (data) => logEntry(LogError, data, 'error', 'Find Interest function error'),

        // Member by manif
    logCreateMemberManifError: (data) => logEntry(LogError, data, 'error', 'Create member by manif function error'),
    logUpdateMemberManifRatingError: (data) => logEntry(LogError, data, 'error', 'Update member by manif rating function error'),
    logUpdateMemberManifPresenceError: (data) => logEntry(LogError, data, 'error', 'Update member by manif presence function error'),
    
        // Member
    logCreateMemberError: (data) => logEntry(LogError, data, 'error', 'Create member by manif function error'),
    logUpdateMemberError: (data) => logEntry(LogError, data, 'error', 'Update member by manif rating function error'),
    logFindMemberError: (data) => logEntry(LogError, data, 'error', 'Find member function error'),

        // Authentication
    logMemberAuthError: (data) => logEntry(LogError, data, 'error', 'Member authentication function error'),

    // Handlers errors
        // Data
    logDataHandlerError: (data) => logEntry(LogError, data, 'error', 'Data Handler error.'),
        // Data
    logAuthHandlerError: (data) => logEntry(LogError, data, 'error', 'Auth Handler error.'),
}