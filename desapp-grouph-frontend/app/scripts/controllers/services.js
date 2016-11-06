'use strict';

var url = 'https://unq-des-app.herokuapp.com/rest/';
//var url = 'http://localhost:8080/rest/';

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
    $http.get(url + 'event/size').
        then(function(response) {
            $scope.events = response.data;
        });
});

angular.module('desappGrouphFrontendApp')
    .service('eventServices', function ($http) {
        return {
            getAll: function () {
                return $http({
                    method: 'get',
                    url: url + 'event/getAll'
                });
            },
            get: function (idEvent) {
                return $http({
                    method: 'get',
                    url: url + 'event/' + idEvent
                });
            },
            getSize: function () {
                return $http({
                    method: 'get',
                    url: url + 'event/size'
                });
            },
            getPage: function (page, sizePage) {
                return $http({
                    method: 'get',
                    url: url + 'event/get/' + page + '/' + sizePage
                });
            }
        };
});
