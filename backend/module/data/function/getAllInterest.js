// Return all interests function
// backend\module\data\function\getAllInterest.js

// Dependencies
const { findInterest } = require('../service/interestService');
const { logFindInterestError } = require('../../logger/service/loggerError');

// Return function
async function getAllInterest() {
    try {
        const criteria = {};
        const interests = await findInterest(criteria);

        return {
            success: true,
            operation: 'Get All Interests',
            data: interests,
        };
    } catch (error) {
        logFindInterestError(error);
        return { success: false, error: 'Cannot find interests.' };
    }
}

module.exports = {
    getAllInterest,
};
