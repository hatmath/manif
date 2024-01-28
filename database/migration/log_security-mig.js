// Security log table creation
// database\migration\log\log_security-create.js

exports.up = function(knex) {
    return knex.schema.createTable('log_security', function(table) {
      table.increments('id').primary();
      table.string('level');
      table.timestamp('time');
      table.text('msg');
      table.integer('pid');
      table.string('hostname');
      table.json('data');
    });
  };
  
exports.down = function(knex) {
    return knex.schema.dropTableIfExists('log_security');
};