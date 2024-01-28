// User login function
// backend/module/auth/function/userLogin.js

// Dependencies
const { authenticateUser } = require('../service/authenticateUser');
const { generateToken } = require('../service/generateAuthToken');
const { comparePasswords } = require('../service/comparePasswords'); // Make sure to import comparePasswords

const { logSuccessfulLogin } = require('../../logger/service/loggerTransaction');
const { logMemberAuthError } = require('../../logger/service/loggerError');

async function userLogin(requestBody) {
  try {
    const { username, password } = requestBody;

    const authResult = await authenticateUser(username);

    if (authResult) {
      const isPasswordValid = await comparePasswords(password, authResult.password);

      if (isPasswordValid) {
        const token = generateToken(authResult.memberID);

        logSuccessfulLogin({ clientId: authResult.memberID });
        return {
          success: true,
          message: 'Login successful',
          operation: 'Login user',
          data: {
            clientId: authResult.id,
            token: token,
          },
        };
      } else {
        logMemberAuthError({ username, requestBody, message: 'Invalid credentials' });
        return {
          success: false,
          message: 'Invalid credentials',
        };
      }
    } else {
      logMemberAuthError({ username, requestBody, message: 'Username not found' });
      return {
        success: false,
        message: 'Username not found',
      };
    }
  } catch (error) {
    logMemberAuthError({ error: error.message });
    return {
      success: false,
      message: 'Internal server error',
    };
  }
}

module.exports = { userLogin };
