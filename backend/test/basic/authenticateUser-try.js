const { authenticateUser } = require('../../module/auth/service/authenticateUser');

const testUserData = {
  username: 'Alfonzo45',
};

async function testAuthentication() {
  try {
    const authResult = await authenticateUser(testUserData.username);
    console.log('Result:', authResult);
  } catch (error) {
    console.error('Error during authentication:', error.message);
  }
}

testAuthentication();
