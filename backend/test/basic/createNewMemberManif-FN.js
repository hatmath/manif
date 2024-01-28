const { createNewMemberManif } = require('../../module/data/function/createNewMemberManif');

async function triggerCreateNewMemberManif() {
  try {
    // Replace with actual data or fetch it dynamically
    const requestData = {
        manif: '8658e41d-106d-4d78-9ce5-2a2b97f7f0a8', // Replace with an actual manifestation ID
        member: '602843e1-ceb5-4cb3-a960-95d0af960d81',       // Replace with an actual member ID
    };

    const result = await createNewMemberManif(requestData);

    if (result.success) {
      console.log('Success:', result.operation);
      console.log('Created Member-Manif:', result.data);
    } else {
      console.error('Error:', result.error);
    }
  } catch (error) {
    console.error('Unexpected error:', error.message);
  }
}

// Call the trigger function
triggerCreateNewMemberManif();
