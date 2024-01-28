// Environment test

const dotenvConfig = require('../../config/dotenv-config');

// Load environment variables
dotenvConfig.load();

// Print environment variables
console.log('DB_HOST:', process.env.DB_HOST);
console.log('DB_USERNAME:', process.env.DB_USERNAME);
console.log('DB_PASSWORD:', process.env.DB_PASSWORD);
console.log('DB_NAME:', process.env.DB_NAME);


