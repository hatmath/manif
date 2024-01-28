const memberService = require('../../module/data/service/memberService');

async function testDeleteMember(memberId) {
  try {
    const deletedMember = await memberService.deleteMember(memberId);
    console.log('Deleted Member:', deletedMember);
  } catch (error) {
    console.error('Error deleting member:', error.message);
  }
}

const testId = '4a5b1083-0ce3-474d-b65f-5e664f9e2cd9';

testDeleteMember(testId);
