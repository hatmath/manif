// Create new slogan function
// backend\module\data\function\createNewSlogan.js

// Dependencies
const { createSlogan, 
        findSlogan } = require('../service/sloganService');
const { readInterestById } = require('../service/interestService');

const { logCreateSloganError } = require('../../logger/service/loggerError');

// Create function
async function createNewSlogan(requestData) {
    try {
        const { title, slogan, interest } = requestData;

        // Validate interest
        const validInterest = await readInterestById(interest);

        if (!validInterest) {
            return { success: false, error: 'Invalid interest.' };
        }

        // Check if a slogan with the same title already exists
        const existingSlogan = await findSlogan({ title });

        if (existingSlogan.length > 0) {
            return { success: false, error: 'A slogan with the same title already exists.' };
        }

        // Create new slogan
        const newSlogan = await createSlogan({
            title,
            slogan,
            interest,
        });

        return {
            success: true,
            operation: 'Create New Slogan',
            data: newSlogan,
        };
    } catch (error) {
        logCreateSloganError(error);
        return {
            success: false,
            error: 'Failed to create slogan.',
        };
    }
}

module.exports = {
    createNewSlogan,
};
