'use strict';

angular.module('desappGrouphFrontendApp')
.controller('eventDetailCtrl', function ($scope, $uibModalInstance, eventServices, idEvent) {

  eventServices.get(idEvent).then(
    function (response) {
      $scope.event = response.data;
      $scope.eventDate = new Date($scope.event.date[0], $scope.event.date[1] - 1, $scope.event.date[2], $scope.event.time.hourOfDay, $scope.event.time.minuteOfHour);
    },
    function (error) {
      console.log(error);
    }
  );

  $scope.close = function() {
    $uibModalInstance.dismiss('cancel');
  };

});
