const { createNewSlogan } = require('../../module/data/function/createNewSlogan');

// Mock data for slogan creation
const sloganData = {
    title: 'Test Slogan',
    slogan: 'This is a test slogan.',
    interest: '1',
};

async function triggerCreateNewSlogan() {
    try {
        const result = await createNewSlogan(sloganData);

        if (result.success) {
            console.log('createNewSlogan Result:', result.data);
        } else {
            console.error('Error calling createNewSlogan:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling createNewSlogan:', error);
    }
}

triggerCreateNewSlogan();
