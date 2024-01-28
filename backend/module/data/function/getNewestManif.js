// Return newest manif function
// backend\module\data\function\getNewestManif.js

// Dependencies
const { findLatestManif } = require('../service/manifService');
const { logFindManifError } = require('../../logger/service/loggerError');

// Return function
async function getNewestManif(requestQuery) {
    try {
        const { dateCreated } = requestQuery;

        console.log(requestQuery);
        
        if (!dateCreated) {
            return { success: false, error: 'Missing required parameter.' };
        }

        const manifs = await findLatestManif(new Date(dateCreated));

        return { success: true, operation: 'Get Newest Manifestations', data: manifs };
    } catch (error) {
        logFindManifError(error);
        return { success: false, error: 'Cannot find manif.' };
    }
}

module.exports = {
    getNewestManif,
};
