// Member services
// backend\module\data\service\memberService.js

// Dependencies
const Member = require('../model/Member');

const genericCrudService = require('../../../common/service/genericCRUD');

const { logCreateMember, 
        logUpdateMember, 
        logDeleteMember } = require('../../logger/service/loggerTransaction');

// Services
async function createMember(data) {
  return genericCrudService.createEntity(Member, data, logCreateMember);
}

async function readMemberById(memberId) {
  return genericCrudService.readEntity(Member, { where: { id: memberId } });
}

async function findMember(criteria) {
  return genericCrudService.findEntities(Member, criteria);
}

async function updateMember(memberId, updatedData) {
  return genericCrudService.updateEntity(Member, memberId, updatedData, logUpdateMember);
}

async function deleteMember(memberId) {
  return genericCrudService.deleteEntity(Member, memberId, logDeleteMember);
}

async function countMembers() {
  return genericCrudService.countEntities(Member);
}

module.exports = {
  createMember,
  readMemberById,
  findMember,
  updateMember,
  deleteMember,
  countMembers,
};
