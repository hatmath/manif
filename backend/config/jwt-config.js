// Web token configuration
// backend\config\jwt-config.js

// Exports
// backend/config/jwt-config.js

module.exports = {
    secretKey: process.env.JWT_SECRET_KEY,
    options: {
    //   // Algorithm used to sign and verify the token
    //   algorithm: 'HS256', // Default is HS256
  
    //   // Token expiration time (e.g., '1h', '7d', '30m')
    //   expiresIn: '1h',
  
    //   // Token not-before time (e.g., '1h', '7d', '30m')
    //   notBefore: '0s',
  
    //   // Issuer of the token (usually your application or website)
    //   issuer: 'your-issuer',
  
    //   // Subject of the token (usually the user the token represents)
    //   subject: 'user-subject',
  
    //   // Audience that the token is intended for (can be a string or an array)
    //   audience: 'your-audience',
  
    //   // Token ID (unique identifier for the token)
    //   jwtid: 'your-jwt-id',
  
    //   // Enable timestamp in the payload (iat and exp)
    //   noTimestamp: false,
  
    //   // JSON web token header parameters
    //   header: { typ: 'JWT', alg: 'HS256' },
    },
  };
  