// App router configuration
// mini\src\scripts\router.js

// Router
function navigateTo(route) {

    cleanupCurrentRoute();

    switch (route) {
        case 'welcome':
            console.log('Navigating to welcome route.');
            loadWelcome();
            break;

        case 'login':
            console.log('Navigating to login route.');
            loadLogin();
            break;

        case 'register':
            console.log('Navigating to register route.');
            loadRegister();
            break;

        case 'mainMenu':
            console.log('Navigating to main menu route.');
            loadMainMenu();
            break;

        case 'account':
            console.log('Navigating to account route.');
            loadAccount();
            break;

        case 'manif':
            console.log('Navigating to manif route.');
            loadManif();
            break;

        case 'manifView':
            console.log('Navigating to manif view route.');
            loadManifView();
            break;

        case 'manifCreate':
            console.log('Navigating to manif creation route.');
            loadManifCreate();
            break;

        case 'slogan':
            console.log('Navigating to slogan route.');
            loadSlogan();
            break;

        default:
            console.error('Unknown route:', route);
            break;
    }

    // Save the current page to local storage
    console.log(route)
    setCurrentPage(route);
}

// Cleanup the current route
function cleanupCurrentRoute() {
    const currentPage = getCurrentPageFromStorage();
    switch (currentPage) {
        case 'welcome':
            cleanupWelcomePage();
            break;

        case 'login':
            cleanupLoginPage();
            break;

        case 'register':
            cleanupRegisterPage();
            break;

        case 'mainMenu':
            cleanupMainMenuPage() ;
            break;

        case 'account':
            cleanupAccountPage() ;
            break;

        case 'manif':
            cleanupManifPage();
            break;

        case 'manifView':
            cleanupManifViewPage();
            break;
        
        case 'manifCreate':
            // Implement cleanup function for manif page if needed
            break;

        case 'slogan':
            cleanupSloganPage();
            break;

        default:
            break;
    }
}

// Function to load views dynamically
function loadView(viewPath) {
    return new Promise((resolve, reject) => {
        fetch(viewPath)
            .then(response => response.text())
            .then(html => {
                document.getElementById('app').innerHTML = html;
                // document.dispatchEvent(dynamicContentLoadedEvent);  // Dispatch custom event
                resolve();  // Resolve the Promise when the view is loaded
            })
            .catch(error => {
                console.error('Error loading view:', error);
                reject(error);  // Reject the Promise if there is an error
            });
    });
}

// Function to load scripts dynamically
function loadScript(scriptPath) {
    return new Promise((resolve, reject) => {
        const script = document.createElement('script');
        script.src = scriptPath;
        script.onload = () => {
            console.log(`Script loaded: ${scriptPath}`);
            resolve();
        };
        script.onerror = reject;
        document.head.appendChild(script);
    });
}

// Function to get the current page identifier from local storage
function getCurrentPageFromStorage() {
    console.log('Return current Page from LoSto')
    return localStorage.getItem('currentPage') || '';
}

// Function to set the current page to local storage
function setCurrentPage(page) {
    console.log('Current Page', page)
    localStorage.setItem('currentPage', page);
}

// Welcome page
function loadWelcome() {
    loadView('/mini/src/views/welcome.html')
        .then(() => loadScript('/mini/src/scripts/welcome.js'))
        .catch(error => {
            console.error('Error loading welcome:', error);
        });
}

// Login page
function loadLogin() {
    loadView('/mini/src/views/login.html')
        .then(() => loadScript('/mini/src/scripts/login.js'))
        .catch(error => {
            console.error('Error loading login:', error);
        });
}

// Register page
function loadRegister() {
    loadView('/mini/src/views/register.html')
        .then(() => loadScript('/mini/src/scripts/register.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}

// Main menu page
function loadMainMenu() {
    loadView('/mini/src/views/mainMenu.html')
        .then(() => loadScript('/mini/src/scripts/mainMenu.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}

// Account page
function loadAccount() {
    loadView('/mini/src/views/account.html')
        .then(() => loadScript('/mini/src/scripts/account.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}

// Manif page
function loadManif() {
    console.log('Loading manif page...');
    loadView('/mini/src/views/manif.html')
        .then(() => loadScript('/mini/src/scripts/manif.js'))
        .catch(error => {console.error('Error loading manif:', error);});
}

// Manif create page
function loadManifCreate() {
    loadView('/mini/src/views/manifCreate.html')
        .then(() => loadScript('/mini/src/scripts/manifCreate.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}

// Manif view page
function loadManifView() {
    loadView('/mini/src/views/manifView.html')
        .then(() => loadScript('/mini/src/scripts/manifView.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}

// Slogan page
function loadSlogan() {
    loadView('/mini/src/views/slogan.html')
        .then(() => loadScript('/mini/src/scripts/slogan.js'))
        .catch(error => {
            console.error('Error loading register:', error);
        });
}