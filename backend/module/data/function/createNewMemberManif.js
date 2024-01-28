// Create new member by manif function
// backend\module\data\function\createNewInterest.js

// Dependencies
const { createMemberManif, findMemberManifs } = require('../service/memberManifService');

const { readMemberById } = require('../service/memberService');
const { readManifById } = require('../service/manifService');

const { logCreateMemberManifError } = require('../../logger/service/loggerError');

// Variables
const DEFAULT_RATING = -1;

// Create member by manif function
async function createNewMemberManif(requestData) {
  try {
    // Validation
    const member = await readMemberById(requestData.member);
    const manif = await readManifById(requestData.manif);

    if (!member || !manif) {
        return {
            success: false,
            error: 'Member or Manifestation not found.',
        };
    }

    // Check duplicate
    const criteria = {
        member: requestData.member,
        manif: requestData.manif,
    }
    
    const existingRelationships = await findMemberManifs(criteria);

    if (existingRelationships.length > 0) {
        return {
            success: false,
            error: 'Member-Manif relationship already exists.',
        };
    }

    const newMemberManifData = {
      manif: requestData.manif,
      member: requestData.member,
      rating: DEFAULT_RATING,
    };

    const createdMemberManif = await createMemberManif(newMemberManifData);

    return { 
        success: true, 
        operation: 'Create New Member-Manif', 
        data: createdMemberManif 
      };
    } catch (error) {

      logCreateMemberManifError(error);
      return { 
        success: false, 
        error: 'Failed to create member-manif.' 
      };
    }
  }

module.exports = {
  createNewMemberManif,
};
