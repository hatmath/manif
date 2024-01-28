// Slogan services
// backend\module\data\service\sloganService.js

// Dependencies
const Slogan = require('../model/Slogan');

const genericCrudService = require('../../../common/service/genericCRUD');

const { logCreateSlogan, 
        logUpdateSlogan, 
        logDeleteSlogan } = require('../../logger/service/loggerTransaction');

// Services

async function createSlogan(data) {
  return genericCrudService.createEntity(Slogan, data, logCreateSlogan);
}

async function readSloganById(sloganId) {
  return genericCrudService.readEntity(Slogan, { where: { id: sloganId } });
}

async function findSlogan(criteria) {
  return genericCrudService.findEntities(Slogan, criteria);
}

async function findLatestSlogan(timestamp) {
  return genericCrudService.findLatestEntities(Slogan, timestamp);
}

async function updateSlogan(sloganId, updatedData) {
  return genericCrudService.updateEntity(Slogan, sloganId, updatedData, logUpdateSlogan);
}

async function deleteSlogan(sloganId) {
  return genericCrudService.deleteEntity(Slogan, sloganId, logDeleteSlogan);
}

async function countSlogans() {
  return genericCrudService.countEntities(Slogan);
}

module.exports = {
  createSlogan,
  readSloganById,
  findSlogan,
  findLatestSlogan,
  updateSlogan,
  deleteSlogan,
  countSlogans,
};
