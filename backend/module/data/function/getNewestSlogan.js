// Return newest slogans
// backend\module\data\function\getNewestSlogan.js

// Dependencies
const { findLatestSlogan } = require('../service/sloganService');
const { logFindManifError } = require('../../logger/service/loggerError');

// Return function
async function getNewestSlogan(requestQuery) {
    try {
        const { dateCreated } = requestQuery;

        console.log(requestQuery);
        
        if (!dateCreated) {
            return { success: false, error: 'Missing required parameter: dateCreated.' };
        }

        const slogans = await findLatestSlogan(new Date(dateCreated));

        return { success: true, operation: 'Get Newest Slogans', data: slogans };
    } catch (error) {
        logFindManifError(error);
        return { success: false, error: 'Cannot find slogans.' };
    }
}

module.exports = {
    getNewestSlogan,
};
