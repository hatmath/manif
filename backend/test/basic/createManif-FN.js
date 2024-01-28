
const { createNewManif } = require('../../module/data/function/createNewManif');

// Mock data
const requestData = {
    owner: '0c8c67fb-6206-4654-b10f-7ed26189ffe5', 
    name: 'Test Manifestation',
    description: 'This is a test manifestation.',
    slogan: 'faff4db3-21a1-4ee4-8464-89f389265d7b', 
    city: 'Test City',
    meeting: 'Test Meeting',
    interest: '11',
    start_date: new Date('2023-01-31T12:00:00Z'), 
    end_date: new Date('2023-01-31T16:00:00Z'),
};

async function triggerCreateNewManif() {
    try {
        const result = await createNewManif(requestData);

        if (result.success) {
            console.log('createNewManif Result:', result.data);
        } else {
            console.error('Error calling createNewManif:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling createNewManif:', error);
    }
}

triggerCreateNewManif();
