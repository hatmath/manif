// API configuration file
// mini\src\common\constant\api-config.js

/** Example usage:

const getAllManifUrl = `${apiConfig.serverAddress}:${apiConfig.serverPort}${apiConfig.routes.getAllManif}`;
*/

// Configuration
const apiConfig = {
    serverAddress: 'http://localhost',
    serverPort: 5283,
    routes: {
      getMember: '/api/data/getMember',
      getAllManif: '/api/data/getAllManif',
      getNewestManif: '/api/data/getNewestManif',
      getAllSlogan: '/api/data/getAllSlogan',
      getNewestSlogan: '/api/data/getNewestSlogan',
      getAllInterest: '/api/data/getAllInterest',
      getNewestInterest: '/api/data/getNewestInterest',
      createManif: '/api/data/createManif',
      createInterest: '/api/data/createInterest',
      createSlogan: '/api/data/createSlogan',
      createMemberManif: '/api/data/createMemberManif',
      loginUser: '/api/auth/login',
      createMember: '/api/auth/register',
      updateManif: '/api/data/updateManif',
      updateRating: '/api/data/updateRating',
      updatePresence: '/api/data/updatePresence',
    },
  };
  
  window.apiConfig = apiConfig;
  