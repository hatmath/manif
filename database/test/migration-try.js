// Trigger migration script
const { runMigrations } = require('../script/migration');

async function triggerMigrations() {
  try {
    const result = await runMigrations();
    console.log(result.message);
    if (!result.success) {
      process.exit(1);
    }
  } catch (error) {
    console.error('Unhandled error:', error);
    process.exit(1);
  }
}

triggerMigrations();

