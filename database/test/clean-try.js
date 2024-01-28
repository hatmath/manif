// Trigger database cleanup test
const { databaseCleanup } = require('../script/cleanup');

async function runDatabaseCleanupTest() {
  try {
    const result = await databaseCleanup();
    console.log(result);

    if (!result.success) {
      console.error('Database cleanup test failed.');
      process.exit(1);
    }

  } catch (error) {
    console.error('Unhandled error:', error);
    process.exit(1);
  }
}

runDatabaseCleanupTest();

