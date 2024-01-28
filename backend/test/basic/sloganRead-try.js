const {readSloganById} = require('../../module/data/service/sloganService');

async function testReadSloganById(memberId) {
  try {
    const member = await readSloganById(memberId);
    console.log('Read slogan by ID:', member);
  } catch (error) {
    console.error('Error reading slogan by ID:', error.message);
  }
}

testReadSloganById('9c94ac81-1f84-4dc4-82a2-8d2df1f0c685');
