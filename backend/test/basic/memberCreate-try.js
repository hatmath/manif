const { createMember } = require('../../module/data/service/memberService');

async function testCreateMember() {
  try {
    const newMemberData = {
      username: 'hard sauce',
      password: 'testpassword',
      salt: 'testsalt',
      description: 'Test user description',
      avatar: 1,
      mail: 'test@example.com',
      phone: '1234567890',
      last_login: new Date(),
      date_created: new Date(),
      last_update: new Date(),
    };

    const createdMember = await createMember(newMemberData);
    console.log('Created Member:', createdMember);
  } catch (error) {
    console.error('Error creating member:', error.message);
  }
}

testCreateMember();
