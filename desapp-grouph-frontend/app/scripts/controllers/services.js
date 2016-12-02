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
            },
            searchSize: function (word) {
                return $http({
                    method: 'get',
                    url: url + 'event/searchSize/' + word
                });
            },
            search: function (word, page, sizePage) {
                return $http({
                    method: 'get',
                    url: url + 'event/search/' + word + '/' + page + '/' + sizePage
                });
            },
            newEvent: function (username, title, description, imgUrl, date, time, price, place) {
                return $http({
                    method: 'post',
                    url: url + 'event/newEvent/',
                    data: $.param({
                      username: username,
                      title: title,
                      description: description,
                      imgUrl: imgUrl,
                      day: date.getUTCDate(),
                      month: date.getMonth()+1,
                      year: date.getFullYear(),
                      hour: time.getHours(),
                      minutes: time.getMinutes(),
                      price: price,
                      placeName: place.name,
                      placeAddress: place.address
                    }),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                });
            }
            ,
            attend: function (username, idEvent) {
                return $http({
                    method: 'post',
                    url: url + 'event/attend',
                    data: $.param({
                      username: username,
                      idEvent: idEvent
                    }),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                });
            }
        };
});


angular.module('desappGrouphFrontendApp')
    .service('userServices', function ($http) {
        return {
            getAll: function () {
                return $http({
                    method: 'get',
                    url: url + 'user/getAll'
                });
            },
            getById: function (idUser) {
                return $http({
                    method: 'get',
                    url: url + 'user/' + idUser
                });
            },
            getByUsername: function (username) {
                return $http({
                    method: 'get',
                    url: url + 'user/getByUsername/' + username
                });
            },
            exists: function (username) {
                return $http({
                    method: 'get',
                    url: url + 'user/exists/' + username
                });
            }
        };
});
