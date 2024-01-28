// Password compare service
// backend\module\auth\service\comparePasswords.js

// Dependencies
const bcrypt = require('bcrypt');

async function comparePasswords(plainPassword, hashedPassword) {
  return bcrypt.compare(plainPassword, hashedPassword);
}

module.exports = {
  comparePasswords,
};