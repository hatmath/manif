// Interest by member services
// backend\module\data\service\interestMemberService.js

// Dependencies
const InterestMember = require('../model/InterestMember');

const genericCrudService = require('../../../common/service/genericCRUD');

const { logCreateInterestMember, 
        logDeleteInterestMember } = require('../../logger/service/loggerTransaction');

// Services

async function createInterestMember(data) {
  return genericCrudService.createEntity(InterestMember, data, logCreateInterestMember);
}

async function readInterestMemberById(interestMemberId) {
  return genericCrudService.readEntity(InterestMember, { where: { id: interestMemberId } });
}

async function findInterestMembers(criteria) {
  return genericCrudService.findEntities(InterestMember, criteria);
}

async function deleteInterestMember(interestMemberId) {
  return genericCrudService.deleteEntity(InterestMember, interestMemberId, logDeleteInterestMember);
}

async function countInterestMembers() {
  return genericCrudService.countEntities(InterestMember);
}

module.exports = {
  createInterestMember,
  readInterestMemberById,
  findInterestMembers,
  deleteInterestMember,
  countInterestMembers,
};
