// User creation function
// backend/module/auth/function/userCreation.js

// Dependencies
const {
    createMember,
    findMember,
} = require('../../data/service/memberService');

const { generateSalt } = require('../service/generateSalt');
const { hashPassword } = require('../service/hashPassword');

const { logCreateMember } = require('../../logger/service/loggerTransaction');
const { logCreateMemberError } = require('../../logger/service/loggerError');

// Create user
async function userCreation(requestBody) {
    try {
        const {
            username,
            password,
            mail,
            description = null,
            avatar = 1,
            phone = null,
        } = requestBody;

        // Validation
        if (!username || !password || !mail) {
            return {
                success: false,
                message: 'Incomplete user data.',
            };
        }

        const existingUsername = await findMember({ username });
        if (existingUsername) {
            return {
                success: false,
                message: 'Username is already taken.',
            };
        }

        const existingmail = await findMember({ mail: mail });
        if (existingmail) {
            return {
                success: false,
                message: 'mail is already taken.',
            };
        }

        // Create new member
        const hashedPassword = await hashPassword(password);
        console.log("HASHED: ", hashedPassword);
        const lastLogin = new Date();
        const salt = generateSalt();

        const createdUser = await createMember({
            username,
            password: hashedPassword,
            mail,
            salt,
            description,
            avatar,
            phone,
            last_login: lastLogin,
        });

        logCreateMember({ clientId: createdUser.id });
        return {
            success: true,
            message: 'User creation successful',
            operation: 'User creation',
            data: {
                clientId: createdUser.id,
            },
        };
    } catch (error) {
        logCreateMemberError({ error: error.message, requestBody });
        return {
            success: false,
            message: 'Internal server error',
        };
    }
}

module.exports = { 
    userCreation,
};
