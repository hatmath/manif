// triggerUserCreation.js

const { userCreation } = require('../../module/auth/function/userCreation');

async function triggerUserCreation() {
    const requestBody = {
        username: 'john_doe',
        password: 'hashed_password',
        mail: 'john.doe@example.com',
        description: 'A member of the community',
        avatar: 1,
        phone: '1234567890',
    };

    const result = await userCreation(requestBody);

    if (result.success) {
        console.log('User Creation Result:', result);
    } else {
        console.error('Error creating user:', result.message);
    }
}

triggerUserCreation();
