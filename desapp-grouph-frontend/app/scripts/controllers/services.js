'use strict';

var url = "https://unq-des-app.herokuapp.com/rest/"

angular.module('desappGrouphFrontendApp')
.controller('UserService', function($scope, $http, $resource) {
    $http.get(url + 'user/getAll').
        then(function(response) {
            $scope.allUsers = response.data;
        });
});

angular.module('desappGrouphFrontendApp')
.controller('EventService', function($scope, $http, $resource) {
    $http.get(url + 'event/mostPopular').
        then(function(response) {
            $scope.mostPopularEvents = response.data;
        });
});
