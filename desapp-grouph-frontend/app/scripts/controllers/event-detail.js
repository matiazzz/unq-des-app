'use strict';

angular.module('desappGrouphFrontendApp')
.controller('eventDetailCtrl', function ($scope, $uibModalInstance, eventServices, idEvent) {

  eventServices.get(idEvent).then(
    function (response) {
      $scope.event = response.data;
    },
    function (error) {
      console.log(error);
    }
  );

  $scope.close = function() {
    $uibModalInstance.dismiss('cancel');
  };

});
