'use strict';

/*angular.module('desappGrouphFrontendApp')
  .controller('EventsCtrl', function () {

  });*/

  angular.module('desappGrouphFrontendApp');
  function CarouselDemoCtrl($scope){
    $scope.myInterval = 3000;
    $scope.slides = [
      {
        image: 'http://lorempixel.com/400/200/'
      },
      {
        image: 'http://lorempixel.com/400/200/food'
      },
      {
        image: 'http://lorempixel.com/400/200/sports'
      },
      {
        image: 'http://lorempixel.com/400/200/people'
      }
    ];
  }
