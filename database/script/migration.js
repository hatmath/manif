// Migration script
// database\script\migration.js

const path = require('path');

const knexConfig = require('../config/knex-config');
const knex = require('knex')(knexConfig);

async function runMigrations() {
  try {
    const migrationDir = path.join(__dirname, '../migration');
    await knex.migrate.latest({ directory: migrationDir });

    return { success: true, message: 'Migrations completed successfully' };
  } catch (error) {
    return { success: false, message: `Error running migrations: ${error.message}` };
  } finally {
    await knex.destroy();
  }
}

module.exports = {
  runMigrations,
};

