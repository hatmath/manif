// Database transaction related log entry functions
// backend/module/logger/service/loggerTransaction.js

// Dependencies
const LoggerTransaction = require('../model/LogTransaction');
const { logEntry } = require('./_logger');

// Transaction log functions
module.exports = {

    // Logger test function
    logTransactionTest: (data) => logEntry(LoggerTransaction, data, 'debug', 'Test for transaction log entry.'),

    // Log successful login attemps
    logSuccessfulLogin: (data) => logEntry(LoggerTransaction, data, 'info', 'Successful login'),

    // Member transaction
    logCreateMember: (data) => logEntry(LoggerTransaction, data, 'info', 'New member created'),
    logUpdateMember: (data) => logEntry(LoggerTransaction, data, 'info', 'Member updated'),
    logDeleteMember: (data) => logEntry(LoggerTransaction, data, 'info', 'Member deleted'),

    // Interest by member transaction
    logCreateInterestMember: (data) => logEntry(LoggerTransaction, data, 'info', 'New interest by member created'),
    logDeleteInterestMember: (data) => logEntry(LoggerTransaction, data, 'info', 'Interest by member deleted'),
    
    // Manif transaction
    logCreateManif: (data) => logEntry(LoggerTransaction, data, 'info', 'New manif created'),
    logUpdateManif: (data) => logEntry(LoggerTransaction, data, 'info', 'Manif updated'),
    logDeleteManif: (data) => logEntry(LoggerTransaction, data, 'info', 'Manif deleted'),

    // Slogan transaction
    logCreateSlogan: (data) => logEntry(LoggerTransaction, data, 'info', 'New slogan created'),
    logUpdateSlogan: (data) => logEntry(LoggerTransaction, data, 'info', 'Slogan updated'),
    logDeleteSlogan: (data) => logEntry(LoggerTransaction, data, 'info', 'Slogan deleted'),

    // MemberManif transaction
    logCreateMemberManif: (data) => logEntry(LoggerTransaction, data, 'info', 'New member by manif created'),
    logUpdateMemberManif: (data) => logEntry(LoggerTransaction, data, 'info', 'Member by manif updated'),
    logDeleteMemberManif: (data) => logEntry(LoggerTransaction, data, 'info', 'Member by manif deleted'),

    // Interest transaction
    logCreateInterest: (data) => logEntry(LoggerTransaction, data, 'info', 'New interest created'),
    logUpdateInterest: (data) => logEntry(LoggerTransaction, data, 'info', 'Interest updated'),
    logDeleteInterest: (data) => logEntry(LoggerTransaction, data, 'info', 'Interest deleted'),
}