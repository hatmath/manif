// Pino logger configuration
// backend\config\pino-config.js

// Dependencies
const pino = require('pino');

const defaultLogLevel = process.env.PINO_LOG_LEVEL || 'info';

// Logger function
const createLogger = (level = defaultLogLevel) => {
  return pino({
    level,
    customLevels: {
      emerg: 80,
      alert: 70,
      crit: 60,
      error: 50,
      warn: 40,
      notice: 30,
      info: 20,
      debug: 10,
    },
    useOnlyCustomLevels: true,
    redact: ['req.headers.authorization'],
    serializers: {
      req: pino.stdSerializers.req,
      res: pino.stdSerializers.res,
    },
  });
};

module.exports = createLogger;