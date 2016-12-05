'use strict';

angular.module('desappGrouphFrontendApp')
  .controller('SearchEventCtrl', function ($scope, eventServices) {

    $scope.eventsPerPage = 9;
    $scope.showMsg = false;
    $scope.searching = false;
    $scope.word = '';
    
    function calculatePages(items, itemsPerPage) {
      if ((items / itemsPerPage) > 0) {
        return parseInt(items / itemsPerPage + 1);
      }
      else {
        return parseInt(items / itemsPerPage);
      }
    }

    eventServices.getSize().then(
      function (response) {
        $scope.pages = calculatePages(response.data.size, $scope.eventsPerPage);
      },
      function (error) {
        console.log(error);
      }
    );

    $scope.enableSearch = function() {
      return $scope.word != '';
    };

    $scope.loadPage = function(page){
      eventServices.getPage(page, $scope.eventsPerPage).then(
        function (response) {
          $scope.events = response.data;
          $scope.actualPage = page;
          $scope.searching = false;
        },
        function (error) {
          console.log(error);
        }
      );
    };

    $scope.searchEvents = function(page) {
      eventServices.searchSize($scope.word).then(
        function (response) {
          $scope.pagesForSearch = calculatePages(response.data.size, $scope.eventsPerPage);
        },
        function (error) {
          console.log(error);
        }
      );
      eventServices.search($scope.word, page, $scope.eventsPerPage).then(
        function (response) {
          $scope.events = response.data;
          $scope.actualPage = page;
          $scope.searching = true;
          $scope.showMsg = false;
        },
        function (error) {
          $scope.showMsg = true;
        }
      );
    };

    $scope.activePage = function(page) {
      return $scope.actualPage === page;
    };

    $scope.getPages = function(pages) {
        return new Array(pages);
    };

    $scope.loadPage(1);
});
