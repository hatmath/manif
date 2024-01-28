// Database connection
// database\script\connection.js

// Dependencies
const knexConfig = require('../config/knex-config');
const knex = require('knex')(knexConfig);

// Function to test the database connection
async function databaseConnection() {
  
    try {
        await knex.raw('SELECT 1+1 as result');
        return {
            success: true,
            message:'Connection successful.'
        }
    } catch (error) {
        return {
            success: false,
            message: error.message
        }
    } finally {
        await knex.destroy();
    }
}

module.exports = {
    databaseConnection,
}
