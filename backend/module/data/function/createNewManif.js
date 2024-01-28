// Create new manif function
// backend\module\data\function\createManif.js

// Dependencies
const { createManif } = require('../service/manifService');

const { readSloganById } = require('../service/sloganService');
const { readInterestById } = require('../service/interestService');
const { readMemberById } = require('../service/memberService');

const { logCreateManifError } = require('../../logger/service/loggerError');

// Create function
async function createNewManif(requestData) {
    try {
        const {
            owner,
            name,
            description,
            slogan,
            city,
            meeting,
            interest,
            start_date,
            end_date,
        } = requestData;

        // Data validation
        const validOwner = await readMemberById(owner);
        const validSlogan = await readSloganById(slogan);
        const validInterest = await readInterestById(interest);

        if (!validOwner || !validSlogan || !validInterest) {
            return { success: false, error: 'Invalid owner, slogan, or interest.' };
        }

        // Create new manifestation
        const newManif = await createManif({
            owner,
            name,
            description,
            slogan,
            city,
            meeting,
            interest,
            start_date,
            end_date,
        });

        return { 
            success: true, 
            operation: 'Create New Manifestation', 
            data: newManif 
        };
    } catch (error) {

        logCreateManifError(error);
        return { 
            success: false, 
            error: 'Failed to create manifestation.' 
        };
    }
}

module.exports = {
    createNewManif,
};
