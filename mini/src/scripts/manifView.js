// manifView script
// mini\src\scripts\manifView.js

// Event listener
document.getElementById('app').addEventListener('click', manifViewClickListener);

// Cleanup logic
function cleanupManifViewPage() {
    console.log('Cleaning up ManifView Page.');
    document.getElementById('app').removeEventListener('click', manifViewClickListener);
}

// Functions
async function loadmanifDetails() {
    const manifId = getManifId();

    try {
        const manifDetails = await IndexedDBService.read('manif', manifId);
        const sloganDetails = await IndexedDBService.read('slogan', manifDetails.slogan);

        document.getElementById('manifName').innerText = manifDetails.name;
        document.getElementById('manifDescription').innerText = manifDetails.description;
        document.getElementById('manifSlogan').innerText = sloganDetails.slogan;
        document.getElementById('manifCity').innerText = manifDetails.city;
        document.getElementById('manifMeeting').innerText = manifDetails.meeting;
        document.getElementById('manifInterest').innerText = manifDetails.interest;
        document.getElementById('manifStartDate').innerText = formatDate(manifDetails.start_date);
        document.getElementById('manifEndDate').innerText = formatDate(manifDetails.end_date);
        document.getElementById('manifDateCreated').innerText = formatDate(manifDetails.date_created);
        document.getElementById('manifLastUpdate').innerText = formatDate(manifDetails.last_update);

    } catch (error) {
        console.error('Error loading manifest details:', error);
    }
}

function manifViewClickListener(event) {
    const target = event.target;

    if (target.id === 'returnToManif') {
        navigateTo('manif');

    } else if (target.id === 'confirmPresence') {
        confirmPresence(getManifId());
    }
}

function getManifId() {
    const manifId = localStorage.getItem('lastClickedManifId');
    return manifId;
}

function formatDate(dateString) {
    const formattedDate = new Date(dateString).toLocaleDateString('en-US', {
        year: 'numeric',
        month: 'long',
        day: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
    });
    return formattedDate;
}

function confirmPresence(manifId) {

    const apiUrl = `${apiConfig.serverAddress}:${apiConfig.serverPort}${apiConfig.routes.createMemberManif}`;
    const clientId = localStorage.getItem('clientId');

    const requestBody = {
        member: clientId,
        manif: manifId,
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Presence confirmed successfully:', data);
    })
    .catch(error => {
        console.error('Error confirming presence:', error);
    });
}

// Trigger
loadmanifDetails();
