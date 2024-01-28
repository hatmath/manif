// login script
// mini\src\scripts\login.js

// Event listener for the login page
document.getElementById('app').addEventListener('click', loginClickListener);

// Cleanup logic specific to the login page
function cleanupLoginPage() {
    // Remove the event listener for the login page
    document.getElementById('app').removeEventListener('click', loginClickListener);
}

// Example: Event listener function for the login page
function loginClickListener(event) {
    const target = event.target;

    if (target.id === 'clearButton') {
        clearForm();
    } else if (target.id === 'submitButton') {
        event.preventDefault();
        performLogin(getFormData());
    } else if (target.id === 'returnButton') {
        navigateTo('welcome');
    }
}

// Functions
async function performLogin(data) {
    try {
        const response = await fetch(`${apiConfig.serverAddress}:${apiConfig.serverPort}${apiConfig.routes.loginUser}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error('Login failed.');
        }

        const responseData = await response.json();

        const token = responseData.data.token;
        const clientId = responseData.data.clientId;

        localStorage.setItem('token', token);
        localStorage.setItem('clientId', clientId);

        // Log the server response
        console.log('Server Response:', responseData);

        // Fetch additional data from the database
        try {
            const allManifResponse = await apiService.getAllManif();
            const allSloganResponse = await apiService.getAllSlogan();
            const allInterestResponse = await apiService.getAllInterest();
        
            // Extract the data property from the response
            const allManifData = allManifResponse.data;
            const allSloganData = allSloganResponse.data;
            const allInterestData = allInterestResponse.data;
        
            // Log the additional data
            console.log('All Manif Data:', allManifData);
            console.log('All Slogan Data:', allSloganData);
            console.log('All Interest Data:', allInterestData);

            // Update or insert the data in IndexedDB without reinitialization
            allManifData.forEach(async (manif) => { await IndexedDBService.create('manif', manif); });
            allSloganData.forEach(async (slogan) => { await IndexedDBService.create('slogan', slogan); });
            allInterestData.forEach(async (interest) => { await IndexedDBService.create('interest', interest); });

            // Redirection to Main Menu
            navigateTo('mainMenu');

        } catch (dbError) {
            console.error('Error fetching additional data from the database:', dbError);
        }

    } catch (error) {
        console.error('Error:', error);
        const errorContainer = document.getElementById('errorContainer');
        errorContainer.textContent = error.message;
    }
}

function getFormData() {
    const formData = new FormData(document.getElementById('loginForm'));
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });
    return data;
}

function handleSubmit(event) {
    event.preventDefault();
    console.log('Submit button clicked.');
    performLogin(getFormData());
    clearForm();
}

function clearForm() {
    console.log('Clear button clicked.');
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
}
