'use strict';

var url = 'https://unq-des-app.herokuapp.com/rest/';

angular.module('desappGrouphFrontendApp')
.controller('UserService', function($scope, $http) {
    $http.get(url + 'user/getAll').
        then(function(response) {
            $scope.allUsers = response.data;
        });
});

angular.module('desappGrouphFrontendApp')
.controller('EventService', function($scope, $http) {
    $http.get(url + 'event/mostPopular').
        then(function(response) {
            $scope.mostPopularEvents = response.data;
        });
    $http.get(url + 'event/getAll').
        then(function(response) {
            $scope.events = response.data;
        });
});
