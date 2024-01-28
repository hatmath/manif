// Return member function
// backend\module\data\function\getMember.js

// Dependencies
const { findMember } = require('../service/memberService');
const { logFindMemberError } = require('../../logger/service/loggerError');

// Return function
async function getMember(requestQuery) {
    try {

        const { clientId } = requestQuery;

        console.log(requestQuery);

        if (!clientId) {
            return { success: false, error: 'Missing required parameter.' };
        }

        const criteria = { id: clientId };
        const member = await findMember(criteria);

        return {
            success: true,
            operation: 'Get member',
            data: member,
        };
    } catch (error) {
        logFindMemberError(error);
        return { success: false, error: 'Cannot find Slogan.' };
    }
}

module.exports = {
    getMember,
};
