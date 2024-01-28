const memberService = require('../../module/data/service/memberService');

async function testUpdateMember(memberId, updatedData) {
  try {
    const updatedMember = await memberService.updateMember(memberId, updatedData);
    console.log('Updated Member:', updatedMember);
  } catch (error) {
    console.error('Error updating member:', error.message);
  }
}

const validMemberId = '30233107-7181-4d93-a646-6b47a023d44a';

const testUpdatedData = {
  username: 'updated_username',
  password: 'updated_password',
  description: 'Updated user description',
  avatar: 2,
  mail: 'updated@example.com',
  phone: '9876543210',
  last_login: new Date(),
};

testUpdateMember(validMemberId, testUpdatedData);
