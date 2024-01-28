// User authentication service
// backend/module/auth/service/authenticateUser.js

// Dependencies
const { findMember } = require('../../data/service/memberService');

async function authenticateUser(username) {

  const criteria = { username };
  const user = await findMember(criteria);

  if (user) {
    
    return {
      id: user[0].id,
      username: user[0].username,
      password: user[0].password,
    };
  } else {
    return null;
  }
}

module.exports = { 
    authenticateUser, 
};
