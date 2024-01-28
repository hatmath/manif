// Member by manif services
// backend\module\data\service\memberManifService.js

// Dependencies
const MemberManif = require('../model/MemberManif');

const genericCrudService = require('../../../common/service/genericCRUD');

const { logCreateMemberManif, 
        logUpdateMemberManif, 
        logDeleteMemberManif } = require('../../logger/service/loggerTransaction');

// Services

async function createMemberManif(data) {
  return genericCrudService.createEntity(MemberManif, data, logCreateMemberManif);
}

async function readMemberManifById(memberManifId) {
  return genericCrudService.readEntity(MemberManif, { where: { id: memberManifId } });
}

async function findMemberManifs(criteria) {
  return genericCrudService.findEntities(MemberManif, criteria);
}

async function updateMemberManif(memberManifId, updatedData) {
  return genericCrudService.updateEntity(MemberManif, memberManifId, updatedData, logUpdateMemberManif);
}

async function deleteMemberManif(memberManifId) {
  return genericCrudService.deleteEntity(MemberManif, memberManifId, logDeleteMemberManif);
}

async function countMemberManifs() {
  return genericCrudService.countEntities(MemberManif);
}

module.exports = {
  createMemberManif,
  readMemberManifById,
  findMemberManifs,
  updateMemberManif,
  deleteMemberManif,
  countMemberManifs,
};
