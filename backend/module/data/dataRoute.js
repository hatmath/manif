// Data module routes
// backend\module\data\dataRoute.js

// Dependencies
const express = require('express');
const dataRouter = express.Router();

// Controllers
const { 
    getAllManifController,
    getNewestManifController,
    getAllSloganController,
    getNewestSloganController,
    getAllInterestController,
    getNewestInterestController,
    createNewManifController,
    createNewInterestController,
    createNewSloganController,
    createNewMemberManifController,
    updateManifDataController,
    updateMemberManifRatingController,
    updateMemberManifPresenceController,
    getMemberController,
    } = require('./controller/dataController');

// Test Route - Echo Success Message
dataRouter.get('/dataRouteTest', (req, res) => {
    res.status(200).json({
        message: 'Test route success!',
    });
});

// Routes
// GET
dataRouter.get('/getAllManif', getAllManifController);
dataRouter.get('/getNewestManif', getNewestManifController);
dataRouter.get('/getAllSlogan', getAllSloganController);
dataRouter.get('/getNewestSlogan', getNewestSloganController);
dataRouter.get('/getAllInterest', getAllInterestController);
dataRouter.get('/getNewestInterest', getNewestInterestController);
dataRouter.get('/getMember', getMemberController);

// POST
dataRouter.post('/createManif', createNewManifController);
dataRouter.post('/createInterest', createNewInterestController);
dataRouter.post('/createSlogan', createNewSloganController);
dataRouter.post('/createMemberManif', createNewMemberManifController);

// PATCH
dataRouter.patch('/updateManif', updateManifDataController);
dataRouter.patch('/updateRating', updateMemberManifRatingController);
dataRouter.patch('/updatePresence', updateMemberManifPresenceController);

// Export the router
module.exports = dataRouter;
