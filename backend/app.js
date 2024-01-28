// Application entry point
// backend/app.js

const environment = require('./config/dotenv-config');
const { logSystemError } = require('./module/logger/service/loggerError');

// Load environment variables
try {
  console.log('Loading environment variables...');
  environment.load();
  console.log('Environment variables loaded successfully!');
} catch (error) {
  console.error('Error loading environment variables:', error);
  logSystemError(error);
  process.exit(1);
}

// Dependencies
const express = require('express');
const http = require('http');
const https = require('https');
const fs = require('fs');
const path = require('path');
const bodyParser = require('body-parser');
const apiRouter = require('./router');
const passport = require('passport');
const passportSetup = require('./config/passport-config');

// Server variables and components init
// Initialize Express app
const app = express();

// Load certification
let credentials;

const isProduction = process.env.NODE_ENV.trim() === 'production';

if (isProduction) {
  // Load certificates for production
  try {
    const certPath = path.resolve(__dirname, 'certificate');
    const privateKey = fs.readFileSync(path.join(certPath, 'ca-key.pem'), 'utf8');
    const certificate = fs.readFileSync(path.join(certPath, 'ca-cert.pem'), 'utf8');
    credentials = { key: privateKey, cert: certificate };
  } catch (error) {
    console.error('Error loading certificates:', error);
    logSystemError(error);
    process.exit(1);
  }
}

// Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(passport.initialize());

// Route
// API
app.use('/api', apiRouter);

// App endpoint
const APP_ENDPOINT = path.join(__dirname, '..', 'mini');
app.use('/mini', express.static(APP_ENDPOINT));

// Test route
app.get('/api/test', passport.authenticate('jwt', { session: false }), (req, res) => {
  res.status(200).json({
    message: 'API Test Successful',
    user: req.user,
  });
});

// Start server
const port = process.env.BACKEND_DATA_PORT;
const server = isProduction ? https.createServer(credentials, app) : http.createServer(app);
const protocol = isProduction ? 'https' : 'http';

server.listen(port, () => {
  
  console.log(`Server is running on ${protocol}://localhost:${port}.`);
  console.log(`Running in ${process.env.NODE_ENV}environment.`);
});

// Handle unhandled promise rejections
process.on('unhandledRejection', (reason, promise) => {
  console.error('Unhandled Rejection at:', promise, 'reason:', reason);
  logSystemError(reason);
});

// Handle uncaught exceptions
process.on('uncaughtException', (error) => {
  console.error('Uncaught Exception:', error);
  logSystemError(error);
  process.exit(1);
});
