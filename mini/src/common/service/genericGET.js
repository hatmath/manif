// Generic GET service
// mini\src\common\service\genericGET.js

// GET
const genericGET = async (url) => {
    try {
      const response = await fetch(url);
  
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
  
      return response.json();
    } catch (error) {
      console.error('There was a problem with the fetch operation:', error);
      throw error;
    }
  };
  
  export default genericGET;