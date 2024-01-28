// IndexedDB initialization script
// mini\src\data\_init.js

// Functions
function initializeIndexedDB() {
    return new Promise((resolve, reject) => {
        let db;

        const request = indexedDB.open('manif_local', 1);

        request.onerror = (event) => {
            console.error('Error opening database:', event.target.error);
            reject(event.target.error);
        };

        request.onupgradeneeded = (event) => {
            const db = event.target.result;

            // Create tables
            createMemberTable(db);
            createInterestTable(db);
            createSloganTable(db);
            createManifTable(db);
        };

        // CRUD test
        performCRUDTest(db)
            .then(() => resolve(db))
            .then(() =>  setupGlobalVariables())
            .then(() => {
                console.log('Database initialization completed.');
            })
            .catch((error) => reject(error));

            // setupGlobalVariables()

        request.onsuccess = (event) => {
            const db = event.target.result;
            console.log('IndexedDB opened successfully.');
            resolve(db);
        };
    });
}

function createMemberTable(db) {
    if (!db.objectStoreNames.contains('member')) {
        const memberStore = db.createObjectStore('member', { keyPath: 'id' });
        memberStore.createIndex('usernameIndex', 'username', { unique: true });
        memberStore.createIndex('descriptionIndex', 'description', {
            unique: false,
        });
        memberStore.createIndex('avatarIndex', 'avatar', { unique: false });
    }
}

function createInterestTable(db) {
    if (!db.objectStoreNames.contains('interest')) {
        const interestStore = db.createObjectStore('interest', {
            keyPath: 'id',
        });
        interestStore.createIndex('nameIndex', 'name', { unique: true });
        interestStore.createIndex('descriptionIndex', 'description', {
            unique: false,
        });
        interestStore.createIndex('date_createdIndex', 'date_created', {
            unique: false,
        });
    }
}

function createSloganTable(db) {
    if (!db.objectStoreNames.contains('slogan')) {
        const sloganStore = db.createObjectStore('slogan', { keyPath: 'id' });
        sloganStore.createIndex('interestIndex', 'interest', { unique: false });
        sloganStore.createIndex('titleIndex', 'title', { unique: false });
        sloganStore.createIndex('sloganIndex', 'slogan', { unique: false });
        sloganStore.createIndex('date_createdIndex', 'date_created', {
            unique: false,
        });
        sloganStore.createIndex('last_updateIndex', 'last_update', {
            unique: false,
        });
    }
}

function createManifTable(db) {
    if (!db.objectStoreNames.contains('manif')) {
        const manifStore = db.createObjectStore('manif', { keyPath: 'id' });
        manifStore.createIndex('ownerIndex', 'owner', { unique: false });
        manifStore.createIndex('nameIndex', 'name', { unique: false });
        manifStore.createIndex('descriptionIndex', 'description', {
            unique: false,
        });
        manifStore.createIndex('sloganIndex', 'slogan', { unique: false });
        manifStore.createIndex('cityIndex', 'city', { unique: false });
        manifStore.createIndex('meetingIndex', 'meeting', { unique: false });
        manifStore.createIndex('interestIndex', 'interest', { unique: false });
        manifStore.createIndex('start_dateIndex', 'start_date', {
            unique: false,
        });
        manifStore.createIndex('end_dateIndex', 'end_date', { unique: false });
        manifStore.createIndex('date_createdIndex', 'date_created', {
            unique: false,
        });
        manifStore.createIndex('last_updateIndex', 'last_update', {
            unique: false,
        });
    }
}

// Perform CRUD test function
const performCRUDTest = async (db) => {
    try {
        console.log('Start CRUD test.');

        // Init
        await IndexedDBService.init('manif_local', 1, [
            'member',
            'interest',
            'slogan',
            'manif',
        ]);

        // Create
        console.log('Create mock entry in member.');
        await IndexedDBService.create('member', {
            id: 1,
            username: 'user1',
            description: 'Description 1',
            avatar: 'avatar1.jpg',
        });

        // Read
        const retrievedData = await IndexedDBService.read('member', 1);
        console.log('Retrieved Data:', retrievedData);

        // Update
        console.log('Update existing entry in member.');
        await IndexedDBService.update('member', { id: 1, username: 'user1' }, {
            description: 'Updarsdrdgdfgription 1',
            avatar: 'updateret34etsrdatar1.jpg',
        });

        // Read again after update
        const updatedData = await IndexedDBService.read('member', 1);
        console.log('Updated Data:', updatedData);

        // Delete
        console.log('Delete entry in member.');
        await IndexedDBService.delete('member', 1);

        // Read after delete (should be undefined)
        const deletedData = await IndexedDBService.read('member', 1);
        console.log('Deleted Data:', deletedData);

        console.log('CRUD test successful.');
    } catch (error) {
        console.error('Error during CRUD test:', error);
        throw error;
    }
};


function setupGlobalVariables() {
    // Check if global variables are already set
    const clientId = localStorage.getItem('clientId');
    const token = localStorage.getItem('token');
    const lastSloganUpdate = localStorage.getItem('lastSloganUpdate');
    const lastInterestUpdate = localStorage.getItem('lastInterestUpdate');
    const lastManifUpdate = localStorage.getItem('lastManifUpdate');

    if (!clientId || !token || !lastSloganUpdate || !lastInterestUpdate || !lastManifUpdate) {
        // Set default values or fetch from server if needed
        // For example, you can fetch these values during the login process
        // and store them in local storage

        // Set default values for now
        localStorage.setItem('clientId', 'defaultClientId');
        localStorage.setItem('token', 'defaultToken');
        localStorage.setItem('lastSloganUpdate', 'defaultLastSloganUpdate');
        localStorage.setItem('lastInterestUpdate', 'defaultLastInterestUpdate');
        localStorage.setItem('lastManifUpdate', 'defaultLastManifUpdate');
    }
}


// Init IndexedDB
initializeIndexedDB()
    .then((db) => {
        console.log('IndexedDB initialized:', db);
    })
    .catch((error) => {
        console.error('Error initializing IndexedDB:', error);
    });
