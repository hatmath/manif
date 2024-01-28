// Generate salt service
// backend\module\auth\service\generateSalt.js\

// Dependencies
const crypto = require('crypto');

/**
 * Generate a random salt value.
 * @returns {string} The generated salt.
 */
function generateSalt() {
  return crypto.randomBytes(16).toString('hex');
}

module.exports = {
  generateSalt,
};
