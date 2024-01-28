const cacheVersion = '2';
const cacheName = `manif-pwa-cache-${cacheVersion}`;

const assetsToCache = [
    '/mini/manifest.json',

    '/mini/src/css/global.css',
    '/mini/src/bootstrap/dist/css/bootstrap.min.css',

    '/mini/src/bootstrap/dist/js/bootstrap.bundle.min.js',

    '/mini/src/common/constant/api-config.js',
    '/mini/src/common/service/apiService.js',

    '/mini/src/data/_init.js',
    '/mini/src/data/indexedDBService.js',
    
    '/mini/src/views/login.html',
    '/mini/src/views/mainMenu.html',
    '/mini/src/views/register.html',
    '/mini/src/views/welcome.html',

    '/mini/src/scripts/main.js',
    '/mini/src/scripts/login.js',
    '/mini/src/scripts/mainMenu.js',
    '/mini/src/scripts/register.js',
    '/mini/src/scripts/welcome.js',

    '/mini/src/asset/icons/icon96.png',
    '/mini/src/asset/icons/icon192.png',
    '/mini/src/asset/icons/icon512.png',
];

self.addEventListener('install', (event) => {
    event.waitUntil(
        caches.open(cacheName).then((cache) => {
            return cache.addAll(assetsToCache).catch((error) => {
                console.error('Failed to cache assets:', error);
            });
        })
    );
});

self.addEventListener('activate', (event) => {
    event.waitUntil(
        caches.keys().then((cacheNames) => {
            return Promise.all(
                cacheNames.map((existingCacheName) => {
                    if (existingCacheName.startsWith('manif-pwa-cache-') && existingCacheName !== cacheName) {
                        return caches.delete(existingCacheName);
                    }
                })
            );
        })
    );

    console.log('Manif PWA is now active!');
});

self.addEventListener('fetch', (event) => {
    const nonCacheableMethods = ['POST', 'PATCH']; // Add other non-cacheable methods as needed
  
    if (nonCacheableMethods.includes(event.request.method)) {
      // Bypass caching for non-cacheable methods, directly fetch from the network
      event.respondWith(fetch(event.request));
    } else {
      // Handle caching strategy for other types of requests
      event.respondWith(
        caches.match(event.request).then((response) => {
          return response || fetch(event.request)
            .then((fetchResponse) => {
              if (fetchResponse.ok) {
                return caches.open(cacheName).then((cache) => {
                  cache.put(event.request, fetchResponse.clone());
                  return fetchResponse;
                });
              }
              return fetchResponse;
            })
            .catch((error) => {
              console.error('Fetch error:', error);
              // Provide a fallback response if necessary
              // e.g., return a custom offline page
            });
        })
      );
    }
  });
  
