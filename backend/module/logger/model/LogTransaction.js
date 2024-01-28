// Log transaction table model
// backend\module\logger\model\LogTransaction.js

// Dependencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

// Model
const LogTransaction = sequelize.define('LogTransaction', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  level: {
    type: DataTypes.STRING,
    allowNull: true, 
  },
  time: {
    type: DataTypes.DATE,
    allowNull: true, 
  },
  msg: {
    type: DataTypes.TEXT,
    allowNull: true, 
  },
  pid: {
    type: DataTypes.INTEGER,
    allowNull: true, 
  },
  hostname: {
    type: DataTypes.STRING,
    allowNull: true, 
  },
  data: {
    type: DataTypes.JSON,
    allowNull: true, 
  },
}, {
  tableName: 'log_transaction',
  timestamps: false,
});

module.exports = LogTransaction