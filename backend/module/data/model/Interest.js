// Interest model
// backend\module\data\model\Interest.js

// Dependencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

// Model
const Interest = sequelize.define(
  'Interest',
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    name: {
      type: DataTypes.STRING(64),
      allowNull: false,
    },
    description: {
      type: DataTypes.STRING(255),
      allowNull: false,
    },
    date_created: {
      type: DataTypes.DATE,
      defaultValue: DataTypes.NOW,
    },
  },
  {
    tableName: 'interest',
    timestamps: true,
    updatedAt: false,
    createdAt: 'date_created',
  }
);

module.exports = Interest;
