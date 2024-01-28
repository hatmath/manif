/*
User triggered handlers

UPDATE /data/updateInterest
UPDATE /data/updateInterestList
UPDATE /data/updateMember
UPDATE /data/updatePresence

POST /data/createManif
POST /data/createSlogan

GET /data/manifMember

Client triggered handlers

GET /data/initClient
GET /data/updateClient

GET /data/getNewSlogan 
GET /data/getNewManif
GET /data/getMember
GET /data/getNewMemberManif
GET /data/getNewInterest

*/

// Data module controllers
// backend\module\data\controller\dataController.js

// Dependencies
// Generic Controllers
const { genericGET } = require('../../../common/service/genericGET');
const { genericPOST } = require('../../../common/service/genericPOST');
const { genericPATCH } = require('../../../common/service/genericPATCH');

const { logDataHandlerError } = require('../../logger/service/loggerError');

// Functions
const { getAllManif } = require('../function/getAllManif');
const { getNewestManif } = require('../function/getNewestManif');
const { getAllSlogan } = require('../function/getAllSlogan');
const { getNewestSlogan } = require('../function/getNewestSlogan');
const { getAllInterest } = require('../function/getAllInterest');
const { getNewestInterest } = require('../function/getNewestInterest');
const { getMember } = require('../function/getMember');
const { createNewManif } = require('../function/createNewManif');
const { createNewInterest } = require('../function/createNewInterest');
const { createNewSlogan } = require('../function/createNewSlogan');
const { updateManifData } = require('../function/updateManifData');
const { updateMemberManifRating } = require('../function/updateMemberManifRating');
const { updateMemberManifPresence } = require('../function/updateMemberManifPresence');
const { createNewMemberManif } = require('../function/createNewMemberManif');

// Client triggered controllers
// Get all manif
const propertyMappingForGetAllManif = {};

const logFunctionForGetAllManif = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getAllManifController = genericGET(
    getAllManif,
    propertyMappingForGetAllManif,
    logFunctionForGetAllManif
);

// Get newest manif
const propertyMappingForGetNewestManif = {
    dateCreated: 'dateCreated',
};
const logFunctionForGetNewestManif = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getNewestManifController = genericGET(
    getNewestManif,
    propertyMappingForGetNewestManif,
    logFunctionForGetNewestManif
);

// Get all slogan
const propertyMappingForGetAllSlogan = {};
const logFunctionForGetAllSlogan = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getAllSloganController = genericGET(
    getAllSlogan,
    propertyMappingForGetAllSlogan,
    logFunctionForGetAllSlogan
);

// Get newest slogan
const propertyMappingForGetNewestSlogan = {
    dateCreated: 'dateCreated',
};
const logFunctionForGetNewestSlogan = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getNewestSloganController = genericGET(
    getNewestSlogan,
    propertyMappingForGetNewestSlogan,
    logFunctionForGetNewestSlogan
);

// Get all interest
const propertyMappingForGetAllInterest = {};
const logFunctionForGetAllInterest = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getAllInterestController = genericGET(
    getAllInterest,
    propertyMappingForGetAllInterest,
    logFunctionForGetAllInterest
);

// Get newest interest
const propertyMappingForGetNewestInterest = {
    dateCreated: 'dateCreated',
};
const logFunctionForGetNewestInterest = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getNewestInterestController = genericGET(
    getNewestInterest,
    propertyMappingForGetNewestInterest,
    logFunctionForGetNewestInterest
);

// Get one member
const propertyMappingForGetMember = {
    clientId: 'clientId',
};
const logFunctionForGetMember = (errorInfo) => {
    logDataHandlerError(errorInfo);
};
const getMemberController = genericGET(
    getMember,
    propertyMappingForGetMember,
    logFunctionForGetMember
);

// User triggered controllers
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
    // GET
    getAllManifController,
    getNewestManifController,
    getAllSloganController,
    getNewestSloganController,
    getAllInterestController,
    getNewestInterestController,
    getMemberController,
    // POST
    createNewManifController,
    createNewInterestController,
    createNewSloganController,
    createNewMemberManifController,
    
    // PATCH
    updateManifDataController,
    updateMemberManifRatingController,
    updateMemberManifPresenceController,
};
