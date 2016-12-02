'use strict';

angular.module('desappGrouphFrontendApp')
.controller('EventDetailCtrl', function ($scope, $uibModalInstance, eventServices, idEvent, loggedUser) {

  function getEvent(idEvent) {
    eventServices.get(idEvent).then(
      function (response) {
        $scope.event = response.data;
        $scope.eventDate = new Date($scope.event.date[0], $scope.event.date[1] - 1, $scope.event.date[2], $scope.event.time.hourOfDay, $scope.event.time.minuteOfHour);
        $scope.attendees = $scope.event.attendees.length;
      },
      function (error) {
        console.log(error);
      }
    );
  }

  $scope.attend = function() {
    eventServices.attend(loggedUser.getUsername(), $scope.event.id).then(
      function (response) {
        $scope.attendees = $scope.attendees + 1;
        getEvent(idEvent);
      },
      function (error) {
        console.log(error);
      }
    );
  };

  getEvent(idEvent);

  $scope.close = function() {
    $uibModalInstance.dismiss('cancel');
  };

});
