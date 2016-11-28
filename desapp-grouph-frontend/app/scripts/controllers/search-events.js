'use strict';

angular.module('desappGrouphFrontendApp')
  .controller('SearchEventCtrl', function ($scope, $uibModal, eventServices) {

    $scope.eventsPerPage = 9;
    $scope.showMsg = false;
    $scope.searching = false;

    eventServices.getSize().then(
      function (response) {
        $scope.pages = calculatePages(response.data.size, $scope.eventsPerPage);
      },
      function (error) {
        console.log(error);
      }
    );

    function calculatePages(items, itemsPerPage) {
      if ((items / itemsPerPage) > 0) {
        return parseInt(items / itemsPerPage + 1);
      }
      else {
        return parseInt(items / itemsPerPage);
      }
    }

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

    $scope.searchEvents = function(word, page) {
      eventServices.searchSize(word).then(
        function (response) {
          $scope.pagesForSearch = calculatePages(response.data.size, $scope.eventsPerPage);
        },
        function (error) {
          console.log(error);
        }
      );
      eventServices.search(word, page, $scope.eventsPerPage).then(
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

    $scope.showEventDetail = function(idEvent) {
      $uibModal.open({
        templateUrl: 'views/event-detail.html',
        controller: 'eventDetailCtrl',
        size: 'lg',
        resolve: {
          idEvent: function () {
              return idEvent;
            }
        }
      });
    };

    $scope.getPages = function(pages) {
        return new Array(pages);
    };

    $scope.loadPage(1);
});
