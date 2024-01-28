// Interest services
// backend\module\data\service\interestService.js

// Dependencies
const Interest = require('../model/Interest');
const genericCrudService = require('../../../common/service/genericCRUD');

const { logCreateInterest, 
        logUpdateInterest, 
        logDeleteInterest } = require('../../logger/service/loggerTransaction');

// Services

async function createInterest(data) {
  return genericCrudService.createEntity(Interest, data, logCreateInterest);
}

async function readInterestById(interestId) {
  return genericCrudService.readEntity(Interest, { where: { id: interestId } });
}

async function findInterest(criteria) {
  return genericCrudService.findEntities(Interest, criteria);
}

async function findLatestInterest(timestamp) {
  return genericCrudService.findLatestEntities(Interest, timestamp);
}

async function updateInterest(interestId, updatedData) {
  return genericCrudService.updateEntity(Interest, interestId, updatedData, logUpdateInterest);
}

async function deleteInterest(interestId) {
  return genericCrudService.deleteEntity(Interest, interestId, logDeleteInterest);
}

async function countInterest() {
  return genericCrudService.countEntities(Interest);
}

module.exports = {
  createInterest,
  readInterestById,
  findInterest,
  findLatestInterest,
  updateInterest,
  deleteInterest,
  countInterest,
};
