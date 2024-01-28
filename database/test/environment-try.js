// Environment test

// test-env.js

const dotenvConfig = require('../config/dotenv-config');

// Load environment variables
dotenvConfig.load();

// Print environment variables
console.log('DB_HOST:', process.env.DB_HOST);
console.log('DB_USER:', process.env.DB_USER);
console.log('DB_PASSWORD:', process.env.DB_PASSWORD);
console.log('DB_NAME:', process.env.DB_NAME);
