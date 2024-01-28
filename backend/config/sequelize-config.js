// Sequelize configuration script
// backend/config/sequelize.js

// Dependencies
const path = require('path');

const dotenvConfig = require('./dotenv-config');
dotenvConfig.load();

const { Sequelize } = require('sequelize');

// Sequelize configuration
const sequelize = new Sequelize({
    dialect: 'mysql',
    dialectOptions: {
        charset: 'utf8mb4',
    },
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    username: process.env.DB_USERNAME,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    define: {
        timestamps: false,
    },
    pool: {
        max: 100, // maximum number of connections in the pool
        min: 0, // minimum number of connections in the pool
        acquire: 30000, // in ms
        idle: 10000, // in ms
    },

    // Logging ALL MySQL Queries :
    // logging: console.log,

    // Logging only errors:
    // logging: (msg) => {
    //   if (msg.startsWith('Executing (default): ERROR')) {
    //     console.error(msg);
    //   }
    // },

    // No logging :
    logging: false,
});

module.exports = sequelize;
