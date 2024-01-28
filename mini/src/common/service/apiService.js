// API service implementation
// mini\src\common\service\apiService.js

// Generic API service
async function apiCall(endpoint, method, data) {
    try {
        const response = await fetch(`${apiConfig.serverAddress}:${apiConfig.serverPort}/${endpoint}`, {
            method,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`, // Include the authorization token if needed
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error(`Failed to fetch data from ${endpoint}.`);
        }

        return await response.json();

    } catch (error) {
        console.error(`Error fetching data from ${endpoint}:`, error);
        throw error;
    }
}

// Functions
async function getAllManif() {
    return apiCall('api/data/getAllManif', 'GET');
}

async function getAllSlogan() {
    return apiCall('api/data/getAllSlogan', 'GET');
}

async function getAllInterest() {
    return apiCall('api/data/getAllInterest', 'GET');
}

// Attach functions to the global scope
window.apiService = {
    getAllManif,
    getAllSlogan,
    getAllInterest,
};
