// mini\src\scripts\slogan.js

// Function to handle global click events
document.getElementById('app').addEventListener('click', sloganClickListener);

// Cleanup logic specific to the slogan page
function cleanupSloganPage() {
    document.getElementById('app').removeEventListener('click', sloganClickListener);
}

function sloganClickListener(event) {
    const target = event.target;

    if (target.id === 'createSloganButton') {
        //navigateTo('sloganCreate');
    }
    else if (target.id === 'returnToMainMenuButton') {
        navigateTo('mainMenu');
    }
}

// Function to load and display slogan cards
async function loadSloganCards() {
    const sloganCardsContainer = document.getElementById('sloganCardsContainer');

    const sloganData = await IndexedDBService.readAll('slogan');

    sloganCardsContainer.innerHTML = '';
    sloganData.forEach(slogan => {
        const card = document.createElement('div');
        card.className = 'card';

        card.innerHTML = `<h3>${slogan.title}</h3><p>${slogan.slogan}</p>`;        

        sloganCardsContainer.appendChild(card);
    });
}

loadSloganCards();
