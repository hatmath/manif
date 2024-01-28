const manifService = require('../../module/data/service/manifService');

async function testFindLatestManif(timestamp) {
  try {
    const latestManifs = await manifService.findLatestManif(timestamp);
    console.log('Latest Manifestations:', latestManifs);
  } catch (error) {
    console.error('Error finding latest manifestations:', error.message);
  }
}
const timestamp = '2024-01-12T10:00:00.000Z';

testFindLatestManif(timestamp);
