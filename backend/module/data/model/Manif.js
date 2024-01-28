// Manif model
// backend\module\data\model\Manif.js

// Dependdencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

const Member = require('./Member');
const Slogan = require('./Slogan');
const Interest = require('./Interest'); 

// Model
const Manif = sequelize.define(
  'Manif',
  {
    id: {
      type: DataTypes.UUID,
      defaultValue: DataTypes.UUIDV4,
      primaryKey: true,
    },
    owner: {
      type: DataTypes.UUID,
      allowNull: false,
      references: {
        model: Member,
        key: 'id',
      },
    },
    name: {
      type: DataTypes.STRING(64),
      allowNull: false,
    },
    description: {
      type: DataTypes.STRING(255),
      allowNull: false,
    },
    slogan: {
      type: DataTypes.UUID,
      allowNull: false,
      references: {
        model: Slogan,
        key: 'id',
      },
    },
    city: {
      type: DataTypes.STRING(64),
      allowNull: false,
    },
    meeting: {
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
    start_date: {
      type: DataTypes.DATE,
      allowNull: false,
    },
    end_date: {
      type: DataTypes.DATE,
      allowNull: false,
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
    tableName: 'manif', // Set the table name
    timestamps: true,
    updatedAt: 'last_update',
    createdAt: 'date_created',
  }
);

module.exports = Manif;
