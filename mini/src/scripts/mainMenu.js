// Main menu page scripts
// mini\src\scripts\mainMenu.js

// Do something with the values
console.log('Token:', localStorage.getItem('token'));
console.log('Client ID:', localStorage.getItem('clientId'));

// Event listener for the main menu page
document.getElementById('app').addEventListener('click', mainMenuClickListener);

// Cleanup logic specific to the main menu page
function cleanupMainMenuPage() {
    document.getElementById('app').removeEventListener('click', mainMenuClickListener);
}

// Example: Event listener function for the main menu page
function mainMenuClickListener(event) {
    event.preventDefault();
    const target = event.target;
    
    // Check which button was clicked
    if (target.id === 'accountButton') {
        console.log('Account button clicked.');
        console.log('Navigate to Account');
        navigateTo('account');

    } else if (target.id === 'manifButton') {
        console.log('Manif button clicked.');
        console.log('Navigate to Manif');
        navigateTo('manif');

    } else if (target.id === 'sloganButton') {
        console.log('Slogan button clicked.');
        console.log('Navigate to Slogan');
        navigateTo('slogan');

    } else if (target.id === 'logoutButton') {
        console.log('Logout button clicked.');
        console.log('Logout');
        logout();
    }
}
