// Generic CRUD services
// backend/module/_shared/service/genericCRUD.js

// Dependencies
const sequelize = require('../../config/sequelize-config');
const { Op } = require('sequelize');

const { logCreateError, 
        logReadError, 
        logUpdateError, 
        logDeleteError } = require('../../module/logger/service/loggerError');

/**
 * Generic create service.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {Object} data - The data to be created.
 * @param {Function} logCreateFunc - The log function for create events.
 * @returns {Promise<Object>} A Promise that resolves to the created entity.
 * @throws {Error} Throws an error if there is an issue during the creation process.
 */
async function createEntity(model, data, logCreateFunc) {
  const t = await sequelize.transaction();
  try {
    const newEntity = await model.create(data, { transaction: t });

    logCreateFunc(newEntity);

    await t.commit();
    return newEntity.toJSON();
  } catch (error) {
    await t.rollback();

    logCreateError(error);
    throw error;
  }
}

/**
 * Generic read service.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {Object} options - Options for the Sequelize query.
 * @returns {Promise<Object|null>} A Promise that resolves to the read entity or null if not found.
 * @throws {Error} Throws an error if there is an issue during the read process.
 */
async function readEntity(model, options) {
  try {
    const entity = await model.findOne(options);

    if (!entity) {
      throw new Error('Entity not found');
    }

    return entity.toJSON();
  } catch (error) {
    logReadError(error);
    throw error;
  }
}

/**
 * Generic find service.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {Object} criteria - Criteria for the Sequelize query.
 * @returns {Promise<Array|boolean>} A Promise that resolves to an array of found entities or false if none are found.
 * @throws {Error} Throws an error if there is an issue during the find process.
 */
async function findEntities(model, criteria) {
  try {
    const entities = await model.findAll({ where: criteria });
    
    return entities.length > 0 ? entities.map(entity => entity.toJSON()) : false;
  } catch (error) {
    logReadError(error);
    throw error;
  }
}

/**
 * Generic find service for retrieving the latest entities based on a timestamp.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {string} timestamp - The timestamp to filter the latest entities.
 * @returns {Promise<Array|boolean>} A Promise that resolves to an array of found entities or false if none are found.
 * @throws {Error} Throws an error if there is an issue during the find process.
 */
async function findLatestEntities(model, timestamp) {
  try {
    const entities = await model.findAll({
      where: {
        date_created: {
          [Op.gte]: timestamp,
        },
      },
      order: [['date_created', 'DESC']],
    });
    return entities.map(entity => entity.toJSON());
  } catch (error) {
    logReadError(error);
    throw error;
  }
}

/**
 * Generic update service.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {number} id - The ID of the entity to be updated.
 * @param {Object} updatedData - The updated data.
 * @param {Function} logUpdateFunc - The log function for update events.
 * @returns {Promise<Object|null>} A Promise that resolves to the updated entity or null if not found.
 * @throws {Error} Throws an error if there is an issue during the update process.
 */
async function updateEntity(model, id, updatedData, logUpdateFunc) {
  const t = await sequelize.transaction();
  try {
    const entity = await model.findByPk(id, { transaction: t });

    if (!entity) {
      await t.rollback();
      throw new Error('Entity not found');
    }

    await entity.update(updatedData, { transaction: t });

    logUpdateFunc(entity);

    await t.commit();
    return entity.toJSON();
  } catch (error) {
    logUpdateError(error);
    throw error;
  }
}

/**
 * Generic delete service.
 * @param {Object} model - The Sequelize model for the entity.
 * @param {number} id - The ID of the entity to be deleted.
 * @param {Function} logDeleteFunc - The log function for delete events.
 * @returns {Promise<Object|null>} A Promise that resolves to the deleted entity or null if not found.
 * @throws {Error} Throws an error if there is an issue during the delete process.
 */
async function deleteEntity(model, id, logDeleteFunc) {
  const t = await sequelize.transaction();
  try {
    const entity = await model.findByPk(id, { transaction: t });

    if (!entity) {
      await t.rollback();
      throw new Error('Entity not found');
    }

    await entity.destroy({ transaction: t });

    logDeleteFunc(entity);

    await t.commit();
    return entity.toJSON();
  } catch (error) {
    logDeleteError(error);
    throw error;
  }
}

/**
 * Generic count service.
 * @param {Object} model - The Sequelize model for the entity.
 * @returns {Promise<number>} A Promise that resolves to the count of entities.
 * @throws {Error} Throws an error if there is an issue during the count process.
 */
async function countEntities(model) {
  try {
    const count = await model.count();
    return count;
  } catch (error) {
    throw error;
  }
}

module.exports = {
  createEntity,
  readEntity,
  findEntities,
  findLatestEntities,
  updateEntity,
  deleteEntity,
  countEntities,
};