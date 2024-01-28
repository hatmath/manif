// Error related log entry functions
// backend\module\logger\service\loggerError.js

// Dependencies
const LogSecurity = require('../model/LogSecurity');
const { logEntry } = require('./_logger');

// Error log functions
module.exports = {

    // Logger test function
    logSecurityTest: (data) => logEntry(LogSecurity, data, 'debug', 'Test for security log entry.'),

    // Authentication failed attempt
    logAuthFailure: (data) => logEntry(LogSecurity, data, 'error', 'Authentification failed!'),


}