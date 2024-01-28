// Crypto configuration
// Standalone script to generate a security key for the app lifecycle.
// backend\config\crypto-util.js

// Dependencies
const crypto = require('crypto');

// Key generation
const generateSecretKey = () => {
  return crypto.randomBytes(32).toString('hex');
};

const secretKey = generateSecretKey();

console.log('Generated Secret Key:', secretKey);
