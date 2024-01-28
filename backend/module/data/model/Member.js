// Member model
// backend\module\member\model\Member.js

// Dependdencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

// Model
const Member = sequelize.define(
  'Member',
  {
    id: {
      type: DataTypes.UUID,
      defaultValue: DataTypes.UUIDV4,
      primaryKey: true,
    },
    username: {
      type: DataTypes.STRING(32),
      allowNull: false,
    },
    password: {
      type: DataTypes.STRING(255),
      allowNull: false,
    },
    salt: {
      type: DataTypes.STRING(32),
      allowNull: false,
    },
    description: {
      type: DataTypes.STRING(255),
    },
    avatar: {
      type: DataTypes.INTEGER,
      defaultValue: 1,
    },
    mail: {
      type: DataTypes.STRING(255),
      allowNull: false,
    },
    phone: {
      type: DataTypes.STRING(10),
    },
    last_login: {
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
    tableName: 'member',
    timestamps: true,
    updatedAt: 'last_update',
    createdAt: 'date_created',
  }
);

module.exports = Member;
