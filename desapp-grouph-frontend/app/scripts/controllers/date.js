'use strict';

angular.module('desappGrouphFrontendApp').controller('DateTimeCtrl', function ($scope) {

  /* Date controller*/

  $scope.today = function() {
    $scope.dt = new Date();
  };
  $scope.today();

  $scope.clear = function() {
    $scope.dt = null;
  };

  $scope.options = {
    minDate: new Date(),
    showWeeks: true
  };

  $scope.toggleMin = function() {
    $scope.options.minDate = $scope.options.minDate ? null : new Date();
  };

  $scope.toggleMin();

  $scope.setDate = function(year, month, day) {
    $scope.dt = new Date(year, month, day);
  };

  /* Time controller*/

  $scope.mytime = new Date();
  $scope.ismeridian = false;

  $scope.hstep = 1;
  $scope.mstep = 1;

  $scope.update = function() {
    var d = new Date();
    d.setHours( 14 );
    d.setMinutes( 0 );
    $scope.mytime = d;
  };

  $scope.changed = function () {
    $log.log('Time changed to: ' + $scope.mytime);
  };

});
