// Slogan model
// backend\module\data\model\Slogan.js

// Dependdencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

const Interest = require('./Interest'); // Import the Interest model

// Model
const Slogan = sequelize.define(
  'Slogan',
  {
    id: {
      type: DataTypes.UUID,
      defaultValue: DataTypes.UUIDV4,
      primaryKey: true,
    },
    title: {
      type: DataTypes.STRING(32),
      allowNull: false,
    },
    slogan: {
      type: DataTypes.STRING(255),
      allowNull: false,
    },
    interest: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: Interest,
        key: 'id',
      },
    },
    date_created: {
      type: DataTypes.DATE,
      allowNull: false,
    },
    last_update: {
      type: DataTypes.DATE,
      allowNull: false,
    },
  },
  {
    tableName: 'slogan', // Set the table name
    timestamps: true,
    updatedAt: 'last_update',
    createdAt: 'date_created',
  }
);

module.exports = Slogan;
