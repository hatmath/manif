// Logger generic service
// backend\module\logger\service\_logger.js

// Logger entry function
async function logEntry(logModel, dataInput, levelInput, message) {
    try {
      const logData = {
        level: levelInput,
        time: new Date(),
        msg: `${message} : `,
        pid: process.pid,
        hostname: require('os').hostname(),
        data: dataInput,
      };

      const createdLog = await logModel.create(logData);
      return createdLog;
    } catch (error) {
      console.error(`Error in logger service for ${logModel.name}:`, error);
      throw error;
    }
  }
  
module.exports = {
    logEntry,
};