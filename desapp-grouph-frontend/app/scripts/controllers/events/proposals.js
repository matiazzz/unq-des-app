'use strict';

angular.module('desappGrouphFrontendApp').controller('ProposalsCtrl', function ($scope, $http) {

	$http.get('https://unq-des-app.herokuapp.com/rest/event/getAll').then(function(response) {
        $scope.events = response.data;
    });

	function filterGetFreeEvents(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getFreeEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	function filterGetWithFriendsEvents(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getWithFriendsEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	function filterGetTodayEvents(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getTodayEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	function filterGetWithCoupleEvents(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getWithCoupleEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

	function filterGetSuprisedMeEvents(){
		$http.get('https://unq-des-app.herokuapp.com/rest/event/getSuprisedMeEvents').then(function(response) {
        $scope.events = response.data;
    	});
	}

});