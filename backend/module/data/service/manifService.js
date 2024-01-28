// Manif services
// backend\module\data\service\manifService.js

// Dependencies
const Manif = require('../model/Manif');
const genericCrudService = require('../../../common/service/genericCRUD');
const { logCreateManif, logUpdateManif, logDeleteManif } = require('../../logger/service/loggerTransaction');

// Services
async function createManif(data) {
  return genericCrudService.createEntity(Manif, data, logCreateManif);
}

async function readManifById(manifId) {
  return genericCrudService.readEntity(Manif, { where: { id: manifId } });
}

async function findManif(criteria) {
  console.log('findManif function called with criteria:', criteria);
  return genericCrudService.findEntities(Manif, criteria);
}

async function findLatestManif(timestamp) {
  return genericCrudService.findLatestEntities(Manif, timestamp);
}

async function updateManif(manifId, updatedData) {
  return genericCrudService.updateEntity(Manif, manifId, updatedData, logUpdateManif);
}

async function deleteManif(manifId) {
  return genericCrudService.deleteEntity(Manif, manifId, logDeleteManif);
}

async function countManif() {
  return genericCrudService.countEntities(Manif);
}

module.exports = {
  createManif,
  readManifById,
  findManif,
  findLatestManif,
  updateManif,
  deleteManif,
  countManif,
};
