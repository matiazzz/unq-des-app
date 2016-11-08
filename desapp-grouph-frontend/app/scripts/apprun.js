'use strict';

angular.module('desappGrouphFrontendApp')
.run(function ($rootScope, authService, lock) {

  // Put the authService on $rootScope so its methods
  // can be accessed from the nav bar
  $rootScope.authService = authService;

  // Register the authentication listener that is
  // set up in auth.service.js
  authService.registerAuthenticationListener();

  // Register the synchronous hash parser
  lock.interceptHash();

});
