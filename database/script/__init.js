// Database initialization 
// database\script\_init.js

// Dependencies
const { databaseCleanup } = require('./cleanup');
const { databaseConnection } = require('./connection');
const { databaseCrudTest } = require('./crud-test');
const { runMigrations } = require('./migration');
const { runSeeds } = require('./seeding');

// Deployment steps
const steps = [
    { name: 'Establish database connection', func: databaseConnection },
    { name: 'Clean up the database', func: databaseCleanup },
    { name: 'Run CRUD test', func: databaseCrudTest },
    { name: 'Run migrations', func: runMigrations },
    { name: 'Run seeds', func: runSeeds },
  ];
  
// Deploy database
async function deployDatabase() {
    try {
        for (const step of steps) {
            console.log(`Step: ${step.name}...`);
            const result = await step.func();

        if (result.success) {
            console.log(result.message);
        } else {
            console.error(result.message);
            process.exit(1);
        }
    }
        console.log('Database deployment completed successfully!');
    } catch (error) {
        console.error('An unexpected error occurred during database deployment:', error.message);
        process.exit(1);
    }
}

deployDatabase();