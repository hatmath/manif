const { getNewestManif } = require('../../module/data/function/returnManif'); 

async function triggerGetNewestManif() {
    try {
        const staticTimestamp = '2024-01-12T10:00:00.000Z';

        const result = await getNewestManif({
            dateCreated: staticTimestamp,
        });
        console.log('Result:', result);
    } catch (error) {
        console.error('Error triggering getNewestManif:', error);
    }
}

triggerGetNewestManif();
