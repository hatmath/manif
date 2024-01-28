// Member by manif migration script
// database\migration\table\005-member_manif-mig.js

// Migration
// Filename: yyyyMMddHHmmss_create_member_manif_table.js (use the current timestamp as the filename)

exports.up = function (knex) {
    return knex.schema.createTable('member_manif', function (table) {
      table.increments('id').primary();
      table.uuid('manif').notNullable().references('id').inTable('manif').index();
      table.uuid('member').notNullable().references('id').inTable('member').index();
      table.boolean('is_present').defaultTo(false).notNullable();
      table.integer('rating').defaultTo(-1).notNullable().index();
      table.timestamp('date_created').notNullable();
      table.timestamp('last_update').notNullable();
    });
};
  
exports.down = function (knex) {
    return knex.schema.dropTableIfExists('member_manif');
};
  