// test-sequelize.js

const sequelize = require('../../config/sequelize-config');

async function testConnection() {
  try {
    // Test the connection
    await sequelize.authenticate();
    console.log('Connection has been established successfully.');
  } catch (error) {
    console.error('Unable to connect to the database:', error);
  } finally {
    // Close the Sequelize connection
    await sequelize.close();
  }
}

// Call the function to test the connection
testConnection();
