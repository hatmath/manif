// Generic POST service
// mini\src\common\service\genericPATCH.js

// PATCH
const genericPATCH = async (url, data) => {
    const config = {
      method: 'PATCH',
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
  
  export default genericPATCH;
  