const { createNewInterest } = require('../../module/data/function/createNewInterest');

// Mock data for interest creation
const interestData = {
    name: 'Test Interest',
    description: 'This is a test interest.',
};

async function triggerCreateNewInterest() {
    try {
        const result = await createNewInterest(interestData);

        if (result.success) {
            console.log('createNewInterest Result:', result.data);
        } else {
            console.error('Error calling createNewInterest:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling createNewInterest:', error);
    }
}

triggerCreateNewInterest();
