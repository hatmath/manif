// Return all manif function
// backend\module\data\function\getAllManif.js

// Dependencies
const { findManif } = require('../service/manifService');
const { logFindManifError } = require('../../logger/service/loggerError');

// Return function
async function getAllManif() {
    try {
        const criteria = {};
        const slogans = await findManif(criteria);

        return {
            success: true,
            operation: 'Get All Manifestations',
            data: slogans,
        };
    } catch (error) {
        logFindManifError(error);
        return { success: false, error: 'Cannot find manif.' };
    }
}

module.exports = {
    getAllManif,
};
