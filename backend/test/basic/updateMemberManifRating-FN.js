const { updateMemberManifRating } = require('../../module/data/function/updateMemberManifRating');

// Mock data
const clientId = '30233107-7181-4d93-a646-6b47a023d44a';
const manifId = 'e3b6c04c-bf04-4f5c-bac5-3a9ddce11239';
const newRating = 4;

async function triggerUpdateMemberManifRating() {
    try {
        const result = await updateMemberManifRating({clientId, manifId, newRating});

        if (result.success) {
            console.log('updateMemberManifRating Result:', result.data);
        } else {
            console.error('Error calling updateMemberManifRating:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling updateMemberManifRating:', error);
    }
}

triggerUpdateMemberManifRating();
