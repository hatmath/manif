// Trigger Salt Generator
// backend/module/auth/test/triggerSaltGenerator.js

const { generateSalt } = require('../../module/auth/service/generateSalt');

function triggerSaltGenerator() {
  try {
    const salt = generateSalt();
    console.log('Generated Salt:', salt);
  } catch (error) {
    console.error('Error generating salt:', error.message);
  }
}

triggerSaltGenerator();
