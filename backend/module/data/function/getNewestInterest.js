// Return newest interests function
// backend\module\data\function\getNewestInterest.js

// Dependencies
const { findLatestInterest } = require('../service/interestService');
const { logFindInterestError } = require('../../logger/service/loggerError');

// Return function
async function getNewestInterest(requestQuery) {
    try {
        const { dateCreated } = requestQuery;

        console.log(requestQuery);
        
        if (!dateCreated) {
            return { success: false, error: 'Missing required parameter.' };
        }

        const interests = await findLatestInterest(new Date(dateCreated));

        return { 
            success: true, 
            operation: 'Get Newest Interests', 
            data: interests 
        };
    } catch (error) {
        logFindInterestError(error);
        return { success: false, error: 'Cannot find interests.' };
    }
}

module.exports = {
    getNewestInterest,
};
