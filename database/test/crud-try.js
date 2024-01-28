// Trigger database CRUD test
const { databaseCrudTest } = require('../script/crud-test');

async function runDatabaseCrudTest() {
  try {
    const result = await databaseCrudTest();
    console.log(result.message);
    if (!result.success) {
      process.exit(1);
    }
  } catch (error) {
    console.error('Unhandled error:', error);
    process.exit(1);
  }
}

runDatabaseCrudTest();
