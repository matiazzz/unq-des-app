'use strict';

angular.module('desappGrouphFrontendApp')
  .controller('SearchEventCtrl', function ($scope, eventServices) {

    eventServices.getSize().then(
      function (response) {
        $scope.eventsSize = response.data.size;

        if (($scope.eventsSize / 9) > 0) {
          $scope.pages = parseInt($scope.eventsSize / 9 + 1);
        }
        else {
          $scope.pages = parseInt($scope.eventsSize / 9);
        }
      },
      function (error) {
        console.log(error);
      }
    );

    $scope.loadPage = function(page){
      console.log(page, $scope.eventsSize);
      eventServices.getPage(page, 9).then(
        function (response) {
          $scope.events = response.data;
        },
        function (error) {
          console.log(error);
        }
      );
    };

    $scope.getPages = function(num) {
        return new Array(num);
    };

    $scope.loadPage(1);
});
