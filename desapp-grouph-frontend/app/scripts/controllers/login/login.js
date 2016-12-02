'use strict';

angular.module('desappGrouphFrontendApp')
.controller( 'LoginCtrl', function ($scope, $rootScope, authService, loggedUser) {

  $scope.authService = authService;
  $scope.existsUser = false;

  authService.getProfileDeferred().then(function (profile) {
    $scope.profile = profile;
    loggedUser.setUsername(profile.nickname);
  });
});


angular.module('desappGrouphFrontendApp')
.factory( 'loggedUser', function () {

  var username = '';

  this.setUsername = function(username){
    this.username = username;
  };

  this.getUsername = function(){
    return this.username;
  };

  return {
    getUsername: this.getUsername,
    setUsername: this.setUsername
  }
});
