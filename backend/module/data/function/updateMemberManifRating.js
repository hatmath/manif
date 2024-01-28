// Update manif rating from member function
// backend\module\data\function\updateMemberManifRating.js

// Dependencies
const {
    updateMemberManif,
    findMemberManifs,
} = require('../service/memberManifService');
const { readMemberById } = require('../service/memberService');
const { readManifById } = require('../service/manifService');

const {
    logUpdateMemberManifRatingError,
} = require('../../logger/service/loggerError');

const {
    MANIF_MIN_RATING,
    MANIF_MAX_RATING
} = require('../../../common/constant/application_list')

// Update function
async function updateMemberManifRating({ clientId, manifId, newRating }) {
    try {
        // Validations
        // Is client valid?
        const clientUser = await readMemberById(clientId);
        if (!clientUser) {
            return {
                success: false,
                error: 'Invalid user.',
            };
        }
        // Is manif valid?
        const manifEntry = await readManifById(manifId);
        if (!manifEntry) {
            return {
                success: false,
                error: 'Manif entry not found.',
            };
        }
        // Is client memberManif entry owner?
        const criteria = {
            member: clientId,
            manif: manifId,
        };

        const existingRelationships = await findMemberManifs(criteria);

        if (existingRelationships.length === 0) {
            return {
                success: false,
                error: 'Unauthorized.',
            };
        }
        // Is manif started?
        const currentDate = new Date();
        const manifStartDate = new Date(manifEntry.start_date);

        if (currentDate <= manifStartDate) {
            return {
                success: false,
                error: 'Cannot update rating before the manifestation has started.',
            };
        }
        // Is rating between 0 and 5?
        if (newRating < MANIF_MIN_RATING || newRating > MANIF_MAX_RATING) {
            return {
                success: false,
                error: 'Invalid rating. Rating must be between 0 and 5.',
            };
        }

        // Update rating
        const updatedMemberManif = await updateMemberManif(
            existingRelationships[0].id,
            { rating: newRating }
        );

        return {
            success: true,
            operation: 'Update Member-Manif Rating',
            data: updatedMemberManif,
        };
    } catch (error) {
        logUpdateMemberManifRatingError(error);
        return {
            success: false,
            error: 'Failed to update member-manif rating.',
        };
    }
}

module.exports = {
    updateMemberManifRating,
};
