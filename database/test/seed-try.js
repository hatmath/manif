// Trigger the seed process
const { runSeeds } = require('../script/seeding');

async function runSeeder() {
  try {
    const result = await runSeeds();
    console.log(result.message);
    if (!result.success) {
      process.exit(1);
    }
  } catch (error) {
    console.error('Unhandled error:', error);
    process.exit(1);
  }
}

runSeeder();
