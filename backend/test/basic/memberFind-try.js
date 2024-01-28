const { findMember } = require('../../module/data/service/memberService');

async function testFindMembers(criteria) {
  try {
    const members = await findMember(criteria);
    console.log('Found Members:', members);
  } catch (error) {
    console.error('Error finding members:', error.message);
  }
}

const testCriteria = {
    id: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
    // username: 'Blaze.Hayes50',
    // password: 'hashedPassword',
    // salt: 'mockSalt',
    // description: 'Rem exercitationem qui sit sed inventore omnis aut maxime.',
    // avatar: 4,
    // mail: 'Rhett60@hotmail.com',
    // phone: '4568894611',
    // last_login: '2023-11-21 08:22:39',
};

testFindMembers(testCriteria);
