// Database cleanup
// database\script\cleanup.js

// Dependencies
const knexConfig = require('../config/knex-config');
const knex = require('knex')(knexConfig);

// Clean up ddatabase
async function databaseCleanup() {
  try {
    await knex.raw('SET foreign_key_checks = 0');

    const result = await knex.raw(`SHOW TABLES FROM ${process.env.DB_NAME}`);
    const tables = result[0].map(row => row[`Tables_in_${process.env.DB_NAME}`]);

    for (const table of tables) {
      await knex.raw(`DROP TABLE IF EXISTS ${process.env.DB_NAME}.${table}`);
    }

    await knex.raw('SET foreign_key_checks = 1');
    await knex.destroy();

    return { success: true, message: 'Database cleared successfully' };
  } catch (error) {

    await knex.destroy();
    return { success: false, message: `Error clearing the database: ${error.message}` };
  }
}

module.exports = {
  databaseCleanup,
};
