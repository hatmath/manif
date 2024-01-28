// Member migration table
// database\migration\table\001-member-mig.js

// Migration
exports.up = function (knex) {
    return knex.schema.createTable('member', function (table) {
      table.uuid('id').primary();
      table.string('username', 32).notNullable();
      table.string('password', 255).notNullable();
      table.string('salt', 32).notNullable(); // 16 bytes = 32 hex chars
      table.string('description', 255);
      table.integer('avatar').defaultTo(1);
      table.string('mail', 255).notNullable();
      table.string('phone', 10);
      table.timestamp('last_login').notNullable();
      table.timestamp('date_created').notNullable();
      table.timestamp('last_update').notNullable();
    });
  };
  
  exports.down = function (knex) {
    return knex.schema.dropTableIfExists('member');
  };
  