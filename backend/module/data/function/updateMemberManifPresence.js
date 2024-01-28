// Update manif presence from member function
// backend\module\data\function\updateMemberManifPresence.js

// Dependencies
const { updateMemberManif, findMemberManifs } = require('../service/memberManifService');
const { readMemberById } = require('../service/memberService');
const { readManifById } = require('../service/manifService');
const { logUpdateMemberManifPresenceError } = require('../../logger/service/loggerError');
const { MANIF_PRESENCE_TRUE } = require('../../../common/constant/application_list');

// Update function
async function updateMemberManifPresence({ clientId, manifId }) {
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

        // Check current presence value
        if (existingRelationships[0].is_present === MANIF_PRESENCE_TRUE) {
            return {
                success: true,
                operation: 'Update Member-Manif Presence',
                data: existingRelationships[0],
            };
        }

        // Is manif ongoing?
        const currentDate = new Date();
        const manifStartDate = new Date(manifEntry.start_date);
        const manifEndtDate = new Date(manifEntry.end_date);
        
        if (currentDate <= manifStartDate || currentDate >= manifEndtDate) {
            return {
                success: false,
                error: 'Cannot update presence before the manifestation has started or after it ended.',
            };
        }

        // Update presence to 1
        const updatedMemberManif = await updateMemberManif(
            existingRelationships[0].id,
            { is_present: MANIF_PRESENCE_TRUE }
        );

        return {
            success: true,
            operation: 'Update Member-Manif Presence',
            data: updatedMemberManif,
        };
    } catch (error) {
        logUpdateMemberManifPresenceError(error);
        return {
            success: false,
            error: 'Failed to update member-manif presence.',
        };
    }
}

module.exports = {
    updateMemberManifPresence,
};
