'use strict';

angular.module('desappGrouphFrontendApp')
.controller( 'LoginCtrl', function ($scope, authService) {

  $scope.authService = authService;

  authService.getProfileDeferred().then(function (profile) {
    $scope.profile = profile;
  });

});
