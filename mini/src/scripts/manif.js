// mini\src\scripts\manif.js

// Function to handle global click events
document.getElementById('app').addEventListener('click', manifClickListener);

// Cleanup logic specific to the manif page
function cleanupManifPage() {
    // Remove the event listener for the manif page
    document.getElementById('app').removeEventListener('click', manifClickListener);
}

// Example: Event listener function for the manif page
function manifClickListener(event) {
    const target = event.target;

    // Check if the "Create Manif" button is clicked
    if (target.id === 'createManifButton') {
        navigateTo('manifCreate');
    }
    else if (target.id === 'returnToMain') {
        navigateTo('mainMenu');
    }
}

// Function to load and display manifest cards
async function loadManifestCards() {
    const manifCardsContainer = document.getElementById('manifCardsContainer');

    // Fetch manifest data from the server or local storage
    // For now, let's assume you have an array of manifest objects
    const manifestData = await IndexedDBService.readAll('manif'); // Updated to use 'manif' as the store name

    // Clear existing cards
    manifCardsContainer.innerHTML = '';

    // Create and append cards to the container
    manifestData.forEach(manif => {
        const card = document.createElement('div');
        card.className = 'card';

        // Format the date
        const formattedStartDate = new Date(manif.start_date).toLocaleDateString('en-US', {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: 'numeric',
            minute: 'numeric',
        });

        card.innerHTML = `<h3>${manif.name}</h3><p>Start Date: ${formattedStartDate}</p>`;
        
        // Add a click event listener to each card
        card.addEventListener('click', function() {
            localStorage.setItem('lastClickedManifId', manif.id);
            navigateTo('manifView');
        });

        manifCardsContainer.appendChild(card);
    });
}

// Function to navigate to manifest details
function navigateToManifestDetails(manifId) {
    // Implement the navigation logic or any other action based on the clicked manifest
    console.log(`Navigate to details for Manifest ID: ${manifId}`);
    // You can use the manifId to fetch additional details or navigate to a detailed view
}

// Load and display manifest cards when the 'manif' page is loaded
loadManifestCards();
