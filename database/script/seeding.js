// Seed parsing script
// database\script\seeding.js

const path = require('path');

const knexConfig = require('../config/knex-config');
const knex = require('knex')(knexConfig);

async function runSeeds() {
    try {
        const seedDir = path.join(__dirname, '../seeds');

        await knex.seed.run({ directory: seedDir });

        return { success: true, message: 'Seeding completed successfully' };
    } catch (error) {
        return { success: false, message: `Error running seeds: ${error.message}` };
    } finally {
        await knex.destroy();
    }
}

module.exports = {
  runSeeds,
};