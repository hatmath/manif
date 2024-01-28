const { updateMemberManifPresence } = require('../../module/data/function/updateMemberManifPresence');

// Mock data
const clientId = '30233107-7181-4d93-a646-6b47a023d44a';
const manifId = 'e3b6c04c-bf04-4f5c-bac5-3a9ddce11239';

async function triggerUpdateMemberManifPresence() {
    try {
        const result = await updateMemberManifPresence({ clientId, manifId });

        if (result.success) {
            console.log('updateMemberManifPresence Result:', result.data);
        } else {
            console.error('Error calling updateMemberManifPresence:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling updateMemberManifPresence:', error);
    }
}

triggerUpdateMemberManifPresence();
