// Trigger Update Manif
const { updateManifData } = require('../../module/data/function/updateManifData');

// Mock data for updating a manifestation
const clientId = '0c8c67fb-6206-4654-b10f-7ed26189ffe5'; // Replace with the actual client ID
const manifId = '4c1e51a3-178e-442a-9d20-9ee13d9e62d1'; // Replace with the ID of the manifestation to be updated

const updatedData = {
    name: 'Updated Manifestation Name',
    description: 'Updated description of the manifestation.',
    slogan: 'd496ea44-04c1-4a8f-8b72-876ab778bf56',
    city: 'New City',
    meeting: 'New Meeting',
    interest: '2',
    start_date: new Date('2023-02-01T12:00:00Z'),
    end_date: new Date('2023-02-01T16:00:00Z'),
};

async function triggerUpdateManif() {
    try {
        const result = await updateManifData({clientId, manifId, updatedData});

        if (result.success) {
            console.log('updateManifData Result:', result.data);
        } else {
            console.error('Error calling updateManifData:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling updateManifData:', error);
    }
}

triggerUpdateManif();
