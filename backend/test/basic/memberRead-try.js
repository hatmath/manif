const memberService = require('../../module/data/service/memberService');

async function testReadMemberById(memberId) {
  try {
    const member = await memberService.readMemberById(memberId);
    console.log('Read Member by ID:', member);
  } catch (error) {
    console.error('Error reading member by ID:', error.message);
  }
}

testReadMemberById('4a5b1083-0ce3-474d-b65f-5e664f9e2cd9');
