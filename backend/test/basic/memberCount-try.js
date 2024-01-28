const memberService = require('../../module/data/service/memberService');

async function testCountMembers() {
  try {
    const memberCount = await memberService.countMembers();
    console.log('Member Count:', memberCount);
  } catch (error) {
    console.error('Error counting members:', error.message);
  }
}

testCountMembers();
