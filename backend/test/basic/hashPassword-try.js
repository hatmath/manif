// Dependencies
const { hashPassword } = require('../../module/auth/service/hashPassword');

// Sample password to hash
const samplePassword = 'securePassword123';

// Trigger hashing
hashPassword(samplePassword)
  .then((hashedPassword) => {
    console.log('Original Password:', samplePassword);
    console.log('Hashed Password:', hashedPassword);
  })
  .catch((error) => {
    console.error('Error:', error.message);
  });
