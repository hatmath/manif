// Data POST module controllers
// backend\module\data\controller\dataPOSTController.js

// Dependencies
// Generic Controllers
const { genericPOST } = require('../../../common/service/genericPOST');

const { logDataHandlerError } = require('../../logger/service/loggerError');

// Functions
const { createNewManif } = require('../function/createNewManif');
const { createNewInterest } = require('../function/createNewInterest');
const { createNewSlogan } = require('../function/createNewSlogan');
const { createNewMemberManif } = require('../function/createNewMemberManif');

// POST controllers
// Create new manif
const propertyMappingForCreateNewManif = {
    owner: 'owner',
    name: 'name',
    description: 'description',
    slogan: 'slogan',
    city: 'city',
    meeting: 'meeting',
    interest: 'interest',
    start_date: 'start_date',
    end_date: 'end_date',
};

const logFunctionForCreateNewManif = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const createNewManifController = genericPOST(
    createNewManif,
    propertyMappingForCreateNewManif,
    logFunctionForCreateNewManif
);

// Create new interest
const propertyMappingForCreateNewInterest = {
    name: 'name',
    description: 'description',
};

const logFunctionForCreateNewInterest = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const createNewInterestController = genericPOST(
    createNewInterest,
    propertyMappingForCreateNewInterest,
    logFunctionForCreateNewInterest
);

// Create new slogan
const propertyMappingForCreateNewSlogan = {
    title: 'title',
    slogan: 'slogan',
    interest: 'interest',
};

const logFunctionForCreateNewSlogan = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const createNewSloganController = genericPOST(
    createNewSlogan,
    propertyMappingForCreateNewSlogan,
    logFunctionForCreateNewSlogan
);

// Create new member by manif
const propertyMappingForCreateNewMemberManif = {
    manif: 'manif',
    member: 'member',
};

const logFunctionForCreateNewMemberManif = (errorInfo) => {
    logDataHandlerError(errorInfo);
};

const createNewMemberManifController = genericPOST(
    createNewMemberManif,
    propertyMappingForCreateNewMemberManif,
    logFunctionForCreateNewMemberManif
);

// Exports
module.exports = {
    createNewManifController,
    createNewInterestController,
    createNewSloganController,
    createNewMemberManifController,
};
