'use strict';

angular.module('desappGrouphFrontendApp')
  .controller('CreateUserCtrl', function ($scope, appDataService, loggedUser, userServices) {

    userServices.getProfile(loggedUser.getUsername()).then(
      function(response) {
        $scope.profile = response.data;
      },
      function(error) {
        console.log(error);
      }
    );

    appDataService.getMusicGenres().then(
      function(response) {
        $scope.musicGenres = response.data;
      },
      function(error) {
        console.log(error);
      }
    );

    appDataService.getMovieGenres().then(
      function(response) {
        $scope.movieGenres = response.data;
      },
      function(error) {
        console.log(error);
      }
    );

    appDataService.getFoodTypes().then(
      function(response) {
        $scope.foodTypes = response.data;
      },
      function(error) {
        console.log(error);
      }
    );

    $scope.updateProfile = function() {
      userServices.updateProfile(loggedUser.getUsername(), ["POP"], ["DRAMA"], ["PASTA"]);
    };

    $scope.checkMusicTag = function(tag) {
      return $scope.profile.musicalGenres.indexOf(tag) > -1;
    };

    $scope.checkMovieTag = function(tag) {
      return $scope.profile.movieGenres.indexOf(tag) > -1;
    };

    $scope.checkFoodTag = function(tag) {
      return $scope.profile.foodTypes.indexOf(tag) > -1;
    };
});
