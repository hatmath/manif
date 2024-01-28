// Data GET module controllers
// backend\module\data\controller\dataGETController.js

// Dependencies
// Generic Controllers
const { genericGET } = require('../../../common/service/genericGET');

const { logDataHandlerError } = require('../../logger/service/loggerError');

// Functions
const { getAllManif } = require('../function/getAllManif');
const { getNewestManif } = require('../function/getNewestManif');
const { getAllSlogan } = require('../function/getAllSlogan');
const { getNewestSlogan } = require('../function/getNewestSlogan');
const { getAllInterest } = require('../function/getAllInterest');
const { getNewestInterest } = require('../function/getNewestInterest');
const { getMember } = require('../function/getMember');

// GET Controllers
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

// Exports
module.exports = {
    getAllManifController,
    getNewestManifController,
    getAllSloganController,
    getNewestSloganController,
    getAllInterestController,
    getNewestInterestController,
};
