// Service worker registration 
// mini\src\scripts\registerSW.js

if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/mini/sw.js')
        .then((registration) => {
            console.log('Service Worker registered with scope:', registration.scope);

            // Log the content of window.apiConfig
            console.log('API Configuration:', window.apiConfig);

            if (registration.active) {
                // If the service worker is already active, post API configuration
                registration.active.postMessage({ type: 'apiConfig', data: window.apiConfig });
            }

            loadWelcome();
        })
        .catch((error) => {
            console.error('Service Worker registration failed:', error);
        });
}
