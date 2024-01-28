// test-logger.js
const sequelize = require('../../config/sequelize-config');

const { logErrorTest } = require('../../module/logger/service/loggerError');
const { logSecurityTest } = require('../../module/logger/service/loggerSecurity');
const { logTransactionTest } = require('../../module/logger/service/loggerTransaction');

async function testLogger() {
  try {
    // Test logging an error
    await logErrorTest({ Test: 'Test error message' });
    await logSecurityTest({ Test: 'Test security message' });
    await logTransactionTest({ Test: 'Test transaction message' });

    console.log('Entries logged successfully.');
  } catch (error) {
    console.error('Error logging:', error);
  } finally {
    // Close the Sequelize connection
    await sequelize.close();
  }
}

// Call the function to test the logger
testLogger();
