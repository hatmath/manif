const { getAllManif } = require('../../module/data/function/returnManif');

async function triggerGetAllManif() {
    try {
        const result = await getAllManif();
        if (result.success) {
            console.log('getAllManif Result:', result.data);
        } else {
            console.error('Error calling getAllManif:', result.error);
        }
    } catch (error) {
        console.error('Unexpected error calling getAllManif:', error);
    }
}

triggerGetAllManif();
