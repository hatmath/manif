// Authentication controller
// backend/module/auth/authController.js

// Dependencies
const { genericPOST } = require('../../../common/service/genericPOST');

const { userLogin } = require('../function/userLogin');
const { userCreation } = require('../function/userCreation');

const { logSystemError } = require('../../logger/service/loggerError');

// Authentication controllers
// User login
const propertyMappingForLogin = {
    username: 'username',
    password: 'password',
};

function logFunctionForLogin(errorInfo) {
    logSystemError(errorInfo);
}

const loginUser = genericPOST(
    userLogin,
    propertyMappingForLogin,
    logFunctionForLogin
);

// User creation
const propertyMappingForCreation = {
    username: 'username',
    password: 'password',
    mail: 'mail',
    description: 'description',
    avatar: 'avatar',
    phone: 'phone',
};

function logFunctionForCreation(errorInfo) {
    logSystemError(errorInfo);
}

const createUser = genericPOST(
    userCreation,
    propertyMappingForCreation,
    logFunctionForCreation
);

module.exports = {
    loginUser,
    createUser,
};
