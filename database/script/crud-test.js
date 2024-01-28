// Database CRUD test
// database\script\crud-test.js

const knexConfig = require('../config/knex-config');
const knex = require('knex')(knexConfig);

async function databaseCrudTest() {
  try {
    await knex.schema.createTable('CRUD_test_table', function (table) {
      table.increments();
      table.string('testCol1');
    });

    const createdId = await knex('CRUD_test_table').insert({ testCol1: 'testValue1' });
    const readResult = await knex('CRUD_test_table').select().where('id', createdId[0]);
    await knex('CRUD_test_table').where('id', createdId[0]).update({ testCol1: 'testModValue1' });
    const updatedResult = await knex('CRUD_test_table').select().where('id', createdId[0]);
    await knex('CRUD_test_table').where('id', createdId[0]).del();
    const emptyResult = await knex('CRUD_test_table').select().where('id', createdId[0]);

    return { success: true, message: 'CRUD operations completed successfully' };
  } catch (error) {
    return { success: false, message: error.message };
  } finally {
    try {
      await knex.schema.dropTableIfExists('CRUD_test_table');
    } catch (error) {
      // Ignore table drop errors
    } finally {
      await knex.destroy();
    }
  }
}

module.exports = {
  databaseCrudTest,
};
