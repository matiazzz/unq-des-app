'use strict';

angular.module('desappGrouphFrontendApp')
.controller('CreateEventCtrl', function ($scope, $location, eventServices, loggedUser) {

  $scope.alerts = {success:[], errors: []};
  $scope.event = {title:'', description:'', imgUrl:'', price: 0, place: { name: '', address: ''} };

  $scope.selectEventType = function(eventType) {
    $location.path('/create-event');
  };

  $scope.createEvent = function() {
    //console.log($scope.dt.getUTCDate(), $scope.dt.getMonth()+1, $scope.dt.getFullYear(), $scope.mytime.getHours(), $scope.mytime.getMinutes());

    eventServices.newEvent(loggedUser.getUsername(), $scope.event.title, $scope.event.description, $scope.event.imgUrl, $scope.dt, $scope.mytime, $scope.event.price, $scope.event.place)
    .then(
      function (response) {
        $scope.alerts.success = [1];
      },
      function (error) {
        console.log(error);
      }
    );
  };

  function resetFields() {
    $scope.event = {title:'', description:'', imgUrl:'', price: 0, place: { name: '', address: ''} };
    $scope.alerts = {success:[], errors: []};
  }

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

  $scope.setDate = function(date) {
    $scope.dt = date;
  };

  /* Time controller*/

  $scope.mytime = new Date();
  $scope.ismeridian = false;

  $scope.hstep = 1;
  $scope.mstep = 1;

  $scope.setTime = function(time) {
    $scope.mytime = time;
  };

  $scope.update = function() {
    var d = new Date();
    d.setHours( 14 );
    d.setMinutes( 0 );
    $scope.mytime = d;
  };

});
