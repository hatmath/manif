
const { generateToken } = require('../../module/auth/service/generateAuthToken');

// Test the token generation
const memberID = '0c8c67fb-6206-4654-b10f-7ed26189ffe5'; // Replace with an actual member ID
const token = generateToken(memberID);

console.log('Generated Token:', token);
