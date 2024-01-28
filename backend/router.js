// Main router 
// backend\router.js

// Dependencies
const express = require('express');
const apiRouter = express.Router();

// Import authentication and data routes
const authRoutes = require('./module/auth/authRoute');
const dataRoutes = require('./module/data/dataRoute');
// const launchHelp = require(''); // Create API helper
// const launchApp = require(''); // Create App 

apiRouter.use('/auth', authRoutes);
apiRouter.use('/data', dataRoutes);
// apiRouter.use('/help', launchHelp);
// apiRouter.use('/miniApp', launchApp);

module.exports = apiRouter;