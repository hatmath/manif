// manifCreate.js

// Event listener
document.getElementById('app').addEventListener('click', manifCreateClickListener);

// Fetch slogans and interests from IndexedDB
const slogansPromise = IndexedDBService.readAll('slogan');
const interestsPromise = IndexedDBService.readAll('interest');

// Click event listener for the manifCreate page buttons
function manifCreateClickListener(event) {
    const target = event.target;

    if (target.id === 'saveButton') {
        saveManifestation();
    } else if (target.id === 'clearButton') {
        clearForm();
    } else if (target.id === 'returnToManifButton') {
        navigateTo('manif');
    }
}

// Fetch slogans from IndexedDB and populate the datalist
async function populateSloganList() {
    const sloganList = document.getElementById('manifSlogan'); // Corrected ID
    sloganList.innerHTML = ''; // Clear existing options

    try {
        const slogans = await IndexedDBService.readAll('slogan');
        console.log('Slogans from IndexedDB:', slogans);

        slogans.forEach(slogan => {
            const option = document.createElement('option');
            option.value = slogan.title;

            sloganList.appendChild(option);
        });
    } catch (error) {
        console.error('Error fetching slogans from IndexedDB:', error);
    }
}

// Fetch interests from IndexedDB and populate the datalist
async function populateInterestList() {
    const interestList = document.getElementById('manifInterest'); // Corrected ID
    interestList.innerHTML = ''; // Clear existing options

    try {
        const interests = await IndexedDBService.readAll('interest');
        console.log('Interests from IndexedDB:', interests);

        interests.forEach(interest => {
            const option = document.createElement('option');
            option.value = interest.name;
            interestList.appendChild(option);
        });
    } catch (error) {
        console.error('Error fetching interests from IndexedDB:', error);
    }
}

// Cleanup function for the manifCreate page
function cleanupManifCreatePage() {
    console.log('Cleaning up ManifCreate Page.');
    document.getElementById('app').removeEventListener('click', manifCreateClickListener);
}

// Function to save the manifestation
function saveManifestation() {
    // Implement logic to save the manifestation
    console.log('Saving Manifestation...');
    // Add your code to handle the form data and save it to IndexedDB or send it to the server
}

// Function to clear the form
function clearForm() {
    // Implement logic to clear the form
    console.log('Clearing Form...');
    // Add your code to reset the form fields
}

// Add this section at the end of your script
populateSloganList();
populateInterestList();

// Add event listeners to log selected values when dropdowns change
document.getElementById('manifSlogan').addEventListener('change', function () {
    const selectedSlogan = this.value;
    console.log('Selected Slogan:', selectedSlogan);
});

document.getElementById('manifInterest').addEventListener('change', function () {
    const selectedInterest = this.value;
    console.log('Selected Interest:', selectedInterest);
});
