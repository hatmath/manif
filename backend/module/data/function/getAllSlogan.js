// Return all slogan function
// backend\module\data\function\getAllSlogan.js

// Dependencies
const { findSlogan } = require('../service/sloganService');
const { logFindSloganError } = require('../../logger/service/loggerError');

// Return function
async function getAllSlogan() {
    try {
        const criteria = {};
        const slogans = await findSlogan(criteria);

        return {
            success: true,
            operation: 'Get All Slogans',
            data: slogans,
        };
    } catch (error) {
        logFindSloganError(error);
        return { success: false, error: 'Cannot find Slogan.' };
    }
}

module.exports = {
    getAllSlogan,
};
