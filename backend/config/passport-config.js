// Passport strategy setup
// backend\config\passport-config.js

// Dependencies
const passport = require('passport');
const JwtStrategy = require('passport-jwt').Strategy;
const ExtractJwt = require('passport-jwt').ExtractJwt;
const jwtConfig = require('./jwt-config');

const memberService = require('../module/data/service/memberService'); 

const { logSuccessfulLogin } = require('../module/logger/service/loggerTransaction'); 
const { logAuthError } = require('../module/logger/service/loggerError');
const { logAuthFailure } = require('../module/logger/service/loggerSecurity');

// Options
const opts = {
  jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
  secretOrKey: jwtConfig.secretKey,
};

// Setup
passport.use(
  new JwtStrategy(opts, async (jwt_payload, done) => {
    try {
      const memberId = jwt_payload.sub;
      const user = await memberService.readMemberById(memberId);

      if (user) {

        logSuccessfulLogin({ userId: memberId });
        return done(null, user); 
      } else {

        logAuthFailure({ userId: memberId });
        return done(null, false); 
      }
    } catch (error) {

      logAuthError({ error: error.message });
      return done(error, false);
    }
  })
);
