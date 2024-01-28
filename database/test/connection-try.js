// Trigger database connection test

const { databaseConnection } = require('../script/connection');

async function runDatabaseConnectionTest() {
  try {
    const result = await databaseConnection();
    console.log(result.message);
    if (!result.success) {
      process.exit(1);
    }
  } catch (error) {
    console.error('Unhandled error:', error);
    process.exit(1);
  }
}

runDatabaseConnectionTest();

