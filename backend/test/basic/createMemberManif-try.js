const { createMemberManif } = require('../../module/data/service/memberManifService');

async function testCreateMemberManif() {
  try {
    const newMemberManifData = {
      manif: '8658e41d-106d-4d78-9ce5-2a2b97f7f0a8', // Replace with an actual manifestation ID
      member: '602843e1-ceb5-4cb3-a960-95d0af960d81',       // Replace with an actual member ID
      is_present: 0,
      rating: -1,
    };

    const createdMemberManif = await createMemberManif(newMemberManifData);
    console.log('Created Member-Manif:', createdMemberManif);
  } catch (error) {
    console.error('Error creating member-manif:', error.message);
  }
}

testCreateMemberManif();
