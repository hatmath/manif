// Authentication module routes
// backend\module\auth\authRoute.js

// Dependencies
// authRoutes.js

const express = require('express');
const authRouter = express.Router();

// Import authentication controller
const { loginUser, createUser } = require('./controller/authController');

// // Routes
authRouter.post('/register', createUser);
authRouter.post('/login', loginUser);

// Export the router
module.exports = authRouter;
