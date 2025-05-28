const CACHE_NAME = 'realestate-pro-v1';
const STATIC_CACHE = 'static-v1';
const DYNAMIC_CACHE = 'dynamic-v1';

// Assets to cache
const STATIC_ASSETS = [
  '/',
  '/index.html',
  '/assets/yellowLogo.png',
  '/assets/mainBgg.png',
  '/images/chain.png',
  '/assets/compLogo/comp1.png',
  '/assets/compLogo/comp2.png',
  '/assets/compLogo/comp3.png',
  '/assets/compLogo/comp4.png',
  '/assets/compLogo/comp5.png',
  '/assets/equips/2.png',
  '/assets/equips/3.png',
  '/assets/equips/4.png',
  '/assets/equips/5.png',
  '/assets/equips/6.png',
  '/assets/equips/equip.png',
  '/assets/images/man_constructionBg.png',
  '/assets/images/trucks.png',
  '/assets/machines1.png'
];

// Install event - cache static assets
self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open(STATIC_CACHE).then((cache) => {
      return cache.addAll(STATIC_ASSETS);
    })
  );
});

// Activate event - clean up old caches
self.addEventListener('activate', (event) => {
  event.waitUntil(
    caches.keys().then((cacheNames) => {
      return Promise.all(
        cacheNames
          .filter((name) => name !== STATIC_CACHE && name !== DYNAMIC_CACHE)
          .map((name) => caches.delete(name))
      );
    })
  );
});

// Fetch event - serve from cache or network
self.addEventListener('fetch', (event) => {
  // Skip non-GET requests
  if (event.request.method !== 'GET') return;

  // Handle API requests
  if (event.request.url.includes('/api/')) {
    event.respondWith(
      fetch(event.request)
        .then((response) => {
          const clonedResponse = response.clone();
          caches.open(DYNAMIC_CACHE).then((cache) => {
            cache.put(event.request, clonedResponse);
          });
          return response;
        })
        .catch(() => {
          return caches.match(event.request);
        })
    );
    return;
  }

  // Handle static assets
  event.respondWith(
    caches.match(event.request).then((response) => {
      if (response) {
        return response;
      }

      return fetch(event.request).then((response) => {
        // Cache new responses
        if (response.status === 200) {
          const clonedResponse = response.clone();
          caches.open(DYNAMIC_CACHE).then((cache) => {
            cache.put(event.request, clonedResponse);
          });
        }
        return response;
      });
    })
  );
});

// Background sync for offline actions
self.addEventListener('sync', (event) => {
  if (event.tag === 'sync-data') {
    event.waitUntil(syncData());
  }
});

// Push notification handling
self.addEventListener('push', (event) => {
  const options = {
    body: event.data.text(),
    icon: '/assets/yellowLogo.png',
    badge: '/assets/yellowLogo.png',
    vibrate: [100, 50, 100],
    data: {
      dateOfArrival: Date.now(),
      primaryKey: 1
    },
    actions: [
      {
        action: 'explore',
        title: 'View Details'
      }
    ]
  };

  event.waitUntil(
    self.registration.showNotification('RealEstatePro', options)
  );
});

// Handle notification clicks
self.addEventListener('notificationclick', (event) => {
  event.notification.close();
  event.waitUntil(
    clients.openWindow('/')
  );
}); 