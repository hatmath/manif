// Member by manif model
// backend\module\data\model\MemberManif.js

// Dependdencies
const { DataTypes } = require('sequelize');
const sequelize = require('../../../config/sequelize-config');

const Manif = require('./Manif');
const Member = require('./Member');

// Model
const MemberManif = sequelize.define(
  'MemberManif',
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    manif: {
      type: DataTypes.UUID,
      allowNull: false,
      references: {
        model: Manif,
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
    is_present: {
      type: DataTypes.BOOLEAN,
      defaultValue: false,
      allowNull: false,
    },
    rating: {
      type: DataTypes.INTEGER,
      defaultValue: -1,
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
    tableName: 'member_manif', // Set the table name
    timestamps: true,
    updatedAt: 'last_update',
    createdAt: 'date_created',
  }
);

module.exports = MemberManif;
