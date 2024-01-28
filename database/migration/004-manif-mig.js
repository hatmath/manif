// Manif migration table
// database\migration\table\004-manif-mig.js

// Migration
exports.up = function (knex) {
    return knex.schema.createTable('manif', function (table) {
      table.uuid('id').primary();
      table.uuid('owner').notNullable().references('id').inTable('member').index();
      table.string('name', 64).notNullable();
      table.string('description', 255).notNullable();
      table.uuid('slogan').notNullable().references('id').inTable('slogan');
      table.string('city', 64).notNullable();
      table.string('meeting', 255).notNullable();
      table.integer('interest').notNullable().references('id').inTable('interest').index();
      table.timestamp('start_date').notNullable();
      table.timestamp('end_date').notNullable();
      table.timestamp('date_created').notNullable();
      table.timestamp('last_update').notNullable();
    });
  };
  
  exports.down = function (knex) {
    return knex.schema.dropTableIfExists('manif');
  };
  