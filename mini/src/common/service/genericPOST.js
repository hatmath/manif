// Generic POST service
// mini\src\common\service\genericPOST.js

// POST
const genericPOST = async (url, data) => {
    const config = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // Add any other headers as needed
        },
        body: JSON.stringify(data),
    };

    try {
        const response = await fetch(url, config);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        return response.json();
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        throw error;
    }
};

export default genericPOST;
