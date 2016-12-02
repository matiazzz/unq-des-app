'use strict';

angular.module('desappGrouphFrontendApp')
.controller('EventsMainCtrl', function ($scope, eventServices) {

  eventServices.getMostPopulars().then(
    function (response) {
      $scope.mostPopularEvents = response.data;
    },
    function (error) {
      console.log(error);
    }
  );

});
