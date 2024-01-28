// Create new interest function
// backend\module\data\function\createNewInterest.js

// Dependencies
const { createInterest, 
        findInterest, 
        countInterest } = require('../service/interestService');

const { logCreateInterestError } = require('../../logger/service/loggerError');

// Create interest function
async function createNewInterest(requestData) {
    try {
        const { name, description } = requestData;

        // Validation
        const existingInterest = await findInterest({ name });

        if (existingInterest.length > 0) {
            return { success: false, error: 'An interest with the same name already exists.' };
        }

        // Get the count of existing interests for new id
        const interestCount = await countInterest();

        // Create new interest
        const newInterest = await createInterest({
            id: interestCount,
            name,
            description,
        });

        return {
            success: true,
            operation: 'Create New Interest',
            data: newInterest,
        };
    } catch (error) {
        logCreateInterestError(error);
        return {
            success: false,
            error: 'Failed to create interest.',
        };
    }
}

module.exports = {
    createNewInterest,
};
