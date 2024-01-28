// Generate authentication token service
// backend/module/auth/service/generateAuthToken.js

// Dependencies
const jwt = require('jsonwebtoken');

// Replace 'your-secret-key' with your actual secret key
const secretKey = process.env.JWT_SECRET_KEY || '366f80a591eb969f8c3bf36a970afb5a38202904c394b5f2f6502ea842212fa6';

function generateToken(memberID) {
  const payload = { sub: memberID };
  const options = { expiresIn: '1h' };

  return jwt.sign(payload, secretKey, options);
}

module.exports = { generateToken };
