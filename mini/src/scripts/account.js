// mini\src\scripts\account.js

// Event listener for the account page
document.getElementById('app').addEventListener('click', accountClickListener);

// Cleanup
function cleanupAccountPage() {
    document.getElementById('app').removeEventListener('click', accountClickListener);
}


function accountClickListener(event) {
    const target = event.target;

    if (target.id === 'saveButton') {
        saveChanges();
    } else if (target.id === 'backButton') {
        navigateTo('mainMenu');
    }
}

// Function
function saveChanges() {
    // Implement your logic to save changes
    alert('Changes saved!');
}

async function populateAccountInfo() {

    console.log('populate account data');

    try {
        // Retrieve clientId from local storage
        const clientId = localStorage.getItem('clientId');

        if (!clientId) {
            console.error('Client ID not found in local storage.');
            return;
        }

        const response = await fetch(`${apiConfig.serverAddress}:${apiConfig.serverPort}${apiConfig.routes.getMember}?clientId=${clientId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        

        if (response.ok) {
            const responseData = await response.json();
            console.log(responseData.data)
            // Update input fields with retrieved data
            document.getElementById('username').value = responseData.data[0].username || '';
            document.getElementById('description').value = responseData.data[0].description || '';
            document.getElementById('mail').value = responseData.data[0].mail || '';
            document.getElementById('phone').value = responseData.data[0].phone || '';
            document.getElementById('dateCreated').value = responseData.data[0].date_created || '';
            document.getElementById('lastUpdate').value = responseData.data[0].last_update || '';
        } else {
            console.error('Failed to fetch account information:', response.statusText);
        }
    } catch (error) {
        console.error('Error fetching account information:', error);
    }
}

populateAccountInfo();
