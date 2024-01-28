// Interest by member model
// backend\module\data\model\InterestMember.js

// Dependdencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

const Interest = require('./Interest');
const Member = require('./Member');

// Model
const InterestMember = sequelize.define(
  'InterestMember',
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    interest: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: Interest,
        key: 'id',
      },
    },
    member: {
      type: DataTypes.UUID,
      allowNull: false,
      references: {
        model: Member,
        key: 'id',
      },
    },
    date_created: {
      type: DataTypes.DATE,
      allowNull: false,
    },
  },
  {
    tableName: 'interest_member',
    timestamps: true,
    updatedAt: false,
    createdAt: 'date_created',
  }
);

module.exports = InterestMember;
