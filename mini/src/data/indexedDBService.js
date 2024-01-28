// IndexedDB CRUD service
// mini\src\data\indexedDBService.js

// Example Usage:
// await IndexedDBService.init('YourDatabaseName', 1, ['Table1', 'Table2', 'Table3', 'Table4']);
// await IndexedDBService.create('Table1', { id: 1, name: 'Example' });
// const data = await IndexedDBService.read('Table1', 1);
// console.log(data);
// indexedDBService.js

// indexedDBService.js

const IndexedDBService = {
    db: null,

    init: function (databaseName, version, storeNames) {
        return new Promise(function (resolve, reject) {
            const request = indexedDB.open(databaseName, version);

            request.onerror = function (event) {
                console.error('Error opening database:', event.target.error);
                reject(event.target.error);
            };

            request.onupgradeneeded = function (event) {
                const db = event.target.result;

                storeNames.forEach(function (storeName) {
                    if (!db.objectStoreNames.contains(storeName)) {
                        db.createObjectStore(storeName, { keyPath: 'id', autoIncrement: true });
                    }
                });
            };

            request.onsuccess = function (event) {
                IndexedDBService.db = event.target.result;
                console.log('IndexedDB opened successfully.');
                resolve(IndexedDBService.db);
            };
        });
    },

    create: function (storeName, data) {
        return new Promise(function (resolve, reject) {
            const transaction = IndexedDBService.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);

            const addRequest = store.add(data);

            addRequest.onsuccess = function () {
                console.log(`Data stored in ${storeName} object store.`);
                resolve();
            };

            addRequest.onerror = function (event) {
                console.error(`Error storing data in ${storeName} object store:`, event.target.error);
                reject(event.target.error);
            };
        });
    },

    read: function (storeName, key) {
        return new Promise(function (resolve, reject) {
            const transaction = IndexedDBService.db.transaction(storeName, 'readonly');
            const store = transaction.objectStore(storeName);

            const getRequest = store.get(key);

            getRequest.onsuccess = function (event) {
                const data = event.target.result;
                console.log(`Retrieved data from ${storeName} object store:`, data);
                resolve(data);
            };

            getRequest.onerror = function (event) {
                console.error(`Error retrieving data from ${storeName} object store:`, event.target.error);
                reject(event.target.error);
            };
        });
    },

    readAll: function (storeName) {
        return new Promise(function (resolve, reject) {
            const transaction = IndexedDBService.db.transaction(storeName, 'readonly');
            const store = transaction.objectStore(storeName);
            const getAllRequest = store.getAll();

            getAllRequest.onsuccess = function (event) {
                const data = event.target.result;
                console.log(`Retrieved all data from ${storeName} object store:`, data);
                resolve(data);
            };

            getAllRequest.onerror = function (event) {
                console.error(`Error retrieving all data from ${storeName} object store:`, event.target.error);
                reject(event.target.error);
            };
        });
    },

    update: function (storeName, newData) {
        return new Promise(function (resolve, reject) {
            const transaction = IndexedDBService.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);
    
            const key = newData.id;  // Assuming your object has an 'id' property as the key
    
            const getRequest = store.get(key);
    
            getRequest.onsuccess = function (event) {
                const existingData = event.target.result;
    
                if (existingData) {
                    // If data with the provided key exists, update it
                    const updatedData = Object.assign({}, existingData, newData);
    
                    const putRequest = store.put(updatedData);
    
                    putRequest.onsuccess = function () {
                        console.log(`Data updated in ${storeName} object store.`);
                        resolve();
                    };
    
                    putRequest.onerror = function (event) {
                        console.error(`Error updating data in ${storeName} object store:`, event.target.error);
                        reject(event.target.error);
                    };
                } else {
                    // If no data found with the provided key, reject with an error
                    const error = new Error(`No data found in ${storeName} object store with key ${key}.`);
                    console.error(error.message);
                    reject(error);
                }
            };
    
            getRequest.onerror = function (event) {
                console.error(`Error retrieving data from ${storeName} object store:`, event.target.error);
                reject(event.target.error);
            };
        });
    },
    

    delete: function (storeName, key) {
        return new Promise(function (resolve, reject) {
            const transaction = IndexedDBService.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);

            const deleteRequest = store.delete(key);

            deleteRequest.onsuccess = function () {
                console.log(`Data deleted from ${storeName} object store.`);
                resolve();
            };

            deleteRequest.onerror = function (event) {
                console.error(`Error deleting data from ${storeName} object store:`, event.target.error);
                reject(event.target.error);
            };
        });
    },
};
