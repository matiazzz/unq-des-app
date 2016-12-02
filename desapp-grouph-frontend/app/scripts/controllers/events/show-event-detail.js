'use strict';

angular.module('desappGrouphFrontendApp')
.controller('ShowEventDetailCtrl', function ($scope, $uibModal) {

  $scope.showEventDetail = function(idEvent) {
    $uibModal.open({
      templateUrl: 'views/event-detail.html',
      controller: 'EventDetailCtrl',
      size: 'lg',
      resolve: {
        idEvent: function () {
            return idEvent;
          }
      }
    });
  };

  $scope.close = function() {
    $uibModalInstance.dismiss('cancel');
  };

});
