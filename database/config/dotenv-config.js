// Dotenv configuration file
// database\config\dotenv-config.js

// Dependencies
const path = require('path');

// Configuration export
module.exports = {
  load: function () {
    
    const envFile = process.env.NODE_ENV === 'production' ? '.env.production' : '.env.development';
    const fullPath = path.resolve(__dirname, '..', 'env', envFile);

    require('dotenv').config({ path: fullPath });
  },
};

