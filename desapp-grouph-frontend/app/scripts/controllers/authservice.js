'use strict';

angular.module('desappGrouphFrontendApp')
.service( 'authService', function (lock, authManager, $q) {

  var userProfile = JSON.parse(localStorage.getItem('profile')) || null;
  var deferredProfile = $q.defer();

  if (userProfile) {
    deferredProfile.resolve(userProfile);
  }

  function getProfileDeferred() {
    return deferredProfile.promise;
  }

  function login() {
    lock.show();
  }

  // Logging out just requires removing the user's
  // id_token and profile
  function logout() {
    localStorage.removeItem('id_token');
    authManager.unauthenticate();
  }

  // Set up the logic for when a user authenticates
  // This method is called from app.run.js
  /*function registerAuthenticationListener() {
    lock.on('authenticated', function (authResult) {
      localStorage.setItem('id_token', authResult.idToken);
      authManager.authenticate();
    });
  }*/

  function registerAuthenticationListener() {
      lock.on('authenticated', function (authResult) {
        lock.getProfile(authResult.idToken, function (error, profile) {
          if (error) {
            return console.log(error);
          }
          localStorage.setItem('profile', JSON.stringify(profile));
          deferredProfile.resolve(profile);
          localStorage.setItem('id_token', authResult.idToken);
          authManager.authenticate();
        });

      });
    }

  return {
    login: login,
    logout: logout,
    registerAuthenticationListener: registerAuthenticationListener,
    getProfileDeferred: getProfileDeferred
  };

});
