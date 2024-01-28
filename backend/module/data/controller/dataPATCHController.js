// Data module controllers
// backend\module\data\controller\dataController.js

// Dependencies
// Generic Controllers
const { genericPATCH } = require('../../../common/service/genericPATCH');

const { logDataHandlerError } = require('../../logger/service/loggerError');

// Functions
const { updateManifData } = require('../function/updateManifData');
const { updateMemberManifRating } = require('../function/updateMemberManifRating');
const { updateMemberManifPresence } = require('../function/updateMemberManifPresence');

// PATCH controllers
// Update Manif Data
const propertyMappingForUpdateManif = {
    clientId: 'clientId',
    manifId: 'manifId',
    updatedData: 'updatedData',
};

const logFunctionForUpdateManif = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const updateManifDataController = genericPATCH(
    updateManifData,
    propertyMappingForUpdateManif,
    logFunctionForUpdateManif
);

// Update Member Manif Rating
const propertyMappingForUpdateMemberManifRating = {
    clientId: 'clientId',
    manifId: 'manifId',
    newRating: 'newRating',
};

const logFunctionForUpdateMemberManifRating = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const updateMemberManifRatingController = genericPATCH(
    updateMemberManifRating,
    propertyMappingForUpdateMemberManifRating,
    logFunctionForUpdateMemberManifRating
);

// Update Member Manif Presence
const propertyMappingForUpdateMemberManifPresence = {
    clientId: 'clientId',
    manifId: 'manifId',
};

const logFunctionForUpdateMemberManifPresence = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const updateMemberManifPresenceController = genericPATCH(
    updateMemberManifPresence,
    propertyMappingForUpdateMemberManifPresence,
    logFunctionForUpdateMemberManifPresence
);

// Exports
module.exports = {
    updateManifDataController,
    updateMemberManifRatingController,
    updateMemberManifPresenceController,
};
