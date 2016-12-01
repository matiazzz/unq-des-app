'use strict';

angular.module('desappGrouphFrontendApp')
.controller('ProfileCtrl', function ($scope, $location, userServices, $routeParams) {

  userServices.getByUsername($routeParams.username).then(
    function (response) {
      $scope.user = response.data;
      $scope.hasEvents = $scope.user.myEvents.events.length > 0
    },
    function (error) {
      $location.path('/404.html');
    }
  );

});


angular.module('desappGrouphFrontendApp')
.factory('User', function () {
  return {username : ''};
});
