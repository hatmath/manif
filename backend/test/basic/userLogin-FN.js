const { userLogin } = require('../../module/auth/function/userLogin');

const requestBody = {
  username: 'john_doe',
  password: 'hashed_password'
};

async function triggerUserLogin() {
  try {

    const result = await userLogin(requestBody);

    if (result.success) {
      console.log('User Login Result:', result);
    } else {
      console.error('Error calling User Login:', result.message);
    }
  } catch (error) {
    console.error('Unexpected error calling User Login:', error);
  }
}

triggerUserLogin();
