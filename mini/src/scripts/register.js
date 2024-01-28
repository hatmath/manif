// Login page scripts
// mini\src\scripts\login.js

// Dependencies

// Register page scripts
// mini\src\scripts/register.js

// Event listener for the register page
document.getElementById('app').addEventListener('click', registerClickListener);

// Cleanup logic specific to the register page
function cleanupRegisterPage() {
    // Remove the event listener for the register page
    document.getElementById('app').removeEventListener('click', registerClickListener);
}

// Example: Event listener function for the register page
function registerClickListener(event) {
    event.preventDefault();
    const target = event.target;

    if (target.id === 'clearButton') {
        clearForm();
    } else if (target.id === 'submitButton') {      
        submitForm(getFormData());
    } else if (target.id === 'returnButton') {
        navigateTo('welcome');
    }
}

// Functions specific to the register page
function submitForm(formData) {
    // Make a POST request to your register endpoint
    fetch(`${apiConfig.serverAddress}:${apiConfig.serverPort}${apiConfig.routes.createMember}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json())
    .then(responseData => {
        console.log('Registration response:', responseData);
        navigateTo('login');
    })
    .catch(error => {
        console.error('Registration error:', error);
    });
}

function clearForm() {
    document.getElementById('registerForm').reset();
}

function getFormData() {
    return {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        description: document.getElementById('description').value,
        avatar: '1',
        mail: document.getElementById('mail').value,
        phone: document.getElementById('phone').value,
    };
}
