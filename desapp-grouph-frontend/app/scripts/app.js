'use strict';

/**
 * @ngdoc overview
 * @name desappGrouphFrontendApp
 * @description
 * # desappGrouphFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('desappGrouphFrontendApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'pascalprecht.translate'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/events', {
        templateUrl: 'views/events.html',
        controller: 'EventService',
        controllerAs: 'event'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

.config(function ($translateProvider) {
    $translateProvider.translations('en', {
      'APPNAME': 'Where we go?',
      'HOME': 'Home',
      'EVENTS': 'Events',
      'SEARCH': "Search"
    });

    $translateProvider.translations('es', {
      'APPNAME': '¿A dónde vamos?',
      'HOME': 'Inicio',
      'EVENTS': 'Eventos',
      'SEARCH': "Buscar"
      });

    $translateProvider.preferredLanguage('es');
  });
