// Interest by member migration script
// database\migration\table\006-interest_member-mig.js

// Migration
exports.up = function (knex) {
    return knex.schema.createTable('interest_member', function (table) {
      table.increments('id').primary();
      table.integer('interest').notNullable().references('id').inTable('interest');
      table.uuid('member').notNullable().references('id').inTable('member').index();
      table.timestamp('date_created').notNullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('interest_member');
};
