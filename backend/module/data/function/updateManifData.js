// Update manif function
// backend/module/data/function/updateManif.js

// Dependencies
const { updateManif, 
        readManifById } = require('../service/manifService');
const { readSloganById } = require('../service/sloganService');
const { readInterestById } = require('../service/interestService');
const { readMemberById } = require('../service/memberService');

const { logUpdateManifError } = require('../../logger/service/loggerError');

// Update function
async function updateManifData({ clientId, manifId, updatedData }) {
    try {
        // Validation
        const existingManif = await readManifById(manifId);

        if (!existingManif) {
            return { success: false, error: 'Manifestation not found.' };
        }

        if (existingManif.owner !== clientId) {
            return { success: false, error: 'Unauthorized.' };
        }

        const validOwner = await readMemberById(clientId);
        const validSlogan = !updatedData.slogan ? true : await readSloganById(updatedData.slogan);
        const validInterest = !updatedData.interest ? true : await readInterestById(updatedData.interest);

        if (!validOwner) {
            return { success: false, error: 'Invalid owner.' };
        }

        if (updatedData.slogan && !validSlogan) {
            return { success: false, error: 'Invalid slogan.' };
        }

        if (updatedData.interest && !validInterest) {
            return { success: false, error: 'Invalid interest.' };
        }

        if (updatedData.name !== undefined && typeof updatedData.name !== 'string') {
            return { success: false, error: 'Invalid name type.' };
        }

        if (updatedData.description !== undefined && typeof updatedData.description !== 'string') {
            return { success: false, error: 'Invalid description type.' };
        }

        if (updatedData.city !== undefined && typeof updatedData.city !== 'string') {
            return { success: false, error: 'Invalid city type.' };
        }

        if (updatedData.meeting !== undefined && typeof updatedData.meeting !== 'string') {
            return { success: false, error: 'Invalid meeting type.' };
        }

        if (updatedData.start_date !== undefined && !(updatedData.start_date instanceof Date)) {
            return { success: false, error: 'Invalid start_date type.' };
        }

        if (updatedData.end_date !== undefined && !(updatedData.end_date instanceof Date)) {
            return { success: false, error: 'Invalid end_date type.' };
        }

        // Update
        const updatedManif = await updateManif(manifId, updatedData);

        return {
            success: true,
            operation: 'Update Manifestation',
            data: updatedManif,
        };
    } catch (error) {
        logUpdateManifError(error);
        throw error;
    }
}

module.exports = {
    updateManifData,
};
