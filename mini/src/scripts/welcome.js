// welcome page script
// mini\src\scripts\welcome.js


// Add the event listener to the 'app' element
document.getElementById('app').addEventListener('click', welcomePageClickListener);

// Functions
function welcomePageClickListener(event) {
    // Handle click events on the welcome page
    const target = event.target;

    if (target.id === 'loginButton') {
        event.preventDefault();
        console.log('Login button clicked.');
        navigateTo('login');
    } else if (target.id === 'registerButton') {
        event.preventDefault();
        console.log('Register button clicked.');
        navigateTo('register');
    } else if (target.id === 'installButton') {
        event.preventDefault();
        console.log('Install button clicked.');
        // Check if the browser supports service workers and the web app manifest
        if ('serviceWorker' in navigator && 'showInstallPrompt' in window) {
            // Use the custom showInstallPrompt function
            window.showInstallPrompt();
        } else {
            console.error('Service workers or web app manifest not supported.');
        }
    }
}

function cleanupWelcomePage() {
    // Remove the event listener for the welcome page
    document.getElementById('app').removeEventListener('click', welcomePageClickListener);
}
