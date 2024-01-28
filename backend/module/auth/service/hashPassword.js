// Password hashing service
// backend\module\auth\service\hashPassword.js

// Dependencies
const bcrypt = require('bcrypt');

// Hash function
async function hashPassword(password) {
  const saltRounds = 10;
  return bcrypt.hash(password, saltRounds);
}

module.exports = {
    hashPassword,
  };