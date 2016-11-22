'use strict';

angular.module('desappGrouphFrontendApp')
.controller('CreateEventCtrl', function ($scope, $location) {

  $scope.selectEventType = function(eventType) {
    console.log(eventType);
    $location.path('/create-event');
  };

});
