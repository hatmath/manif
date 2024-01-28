// Slogan migration script
// database\migration\table\003-slogan-mig.js

// Migration
exports.up = function (knex) {
    return knex.schema.createTable('slogan', function (table) {
      table.uuid('id').primary();
      table.string('title', 32).notNullable();
      table.string('slogan', 255).notNullable();
      table.integer('interest').notNullable().references('id').inTable('interest').index();
      table.timestamp('date_created').notNullable();
      table.timestamp('last_update').notNullable();
    });
};
  
exports.down = function (knex) {
    return knex.schema.dropTableIfExists('slogan');
};
  