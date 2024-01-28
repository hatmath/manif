// Interest migration table
// database\migration\table\002-interests-mig.js

// Migration
exports.up = function (knex) {
    return knex.schema.createTable('interest', function (table) {
      table.integer('id').primary();
      table.string('name', 64).notNullable();
      table.string('description', 255).notNullable();
      table.timestamp('date_created').notNullable();
    });
};
  
exports.down = function (knex) {
    return knex.schema.dropTableIfExists('interest');
};
  