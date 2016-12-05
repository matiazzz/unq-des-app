'use strict';

angular.module('desappGrouphFrontendApp').controller('ProposalsCtrl', function ($scope, $http) {

	$http.get('https://unq-des-app.herokuapp.com/rest/event/getAll').then(function(response) {
        $scope.events = response.data;
    });

    $scope.filterGetFreeEvents = function(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getFreeEvents').then(function(response) {
        $scope.events = response.data;
    	});
	};

	$scope.filterGetWithFriendsEvents = function(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getWithFriendsEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	$scope.filterGetTodayEvents = function(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getTodayEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	$scope.filterGetWithCoupleEvents = function(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getWithCoupleEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	$scope.filterGetSuprisedMeEvents = function(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getSuprisedMeEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

});