// Knex configuration file
// database\config\knex-config.js

// Configuration
const dotenvConfig = require('./dotenv-config');
dotenvConfig.load();

module.exports = {
  client: 'mysql2',
  connection: {
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    port: process.env.DB_PORT,
  },
};
