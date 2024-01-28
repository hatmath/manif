// Error log table model
// backend\module\logger\model\LogError.js

// Dependencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

// Model
const LogError = sequelize.define('LogError', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  level: {
    type: DataTypes.STRING,
    allowNull: false,
  },
  time: {
    type: DataTypes.DATE,
    allowNull: false,
  },
  msg: {
    type: DataTypes.TEXT,
    allowNull: false,
  },
  pid: {
    type: DataTypes.INTEGER,
    allowNull: false,
  },
  hostname: {
    type: DataTypes.STRING,
    allowNull: false,
  },
  data: {
    type: DataTypes.JSON,
    allowNull: true,
  },
}, {
  tableName: 'log_error',
  timestamps: false,
});

module.exports = LogError;