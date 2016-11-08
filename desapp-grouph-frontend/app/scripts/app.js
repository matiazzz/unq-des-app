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
    'pascalprecht.translate',
    'ui.bootstrap',
    'auth0.lock',
    'angular-jwt'
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
        controllerAs: 'events'
      })
      .when('/search-events', {
        templateUrl: 'views/search-events.html',
        controller: 'SearchEventCtrl',
        controllerAs: 'search-events'
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
      'SEARCH': 'Search',
      'login': 'Login'
    });

    $translateProvider.translations('es', {
      'APPNAME': '¿A dónde vamos?',
      'HOME': 'Inicio',
      'EVENTS': 'Eventos',
      'SEARCH': 'Buscar',
      'login': 'Entrar'
      });

    $translateProvider.preferredLanguage('es');
  })

  .config(function (lockProvider) {
    lockProvider.init({
      clientID: 'HpQcbV9OE6ImZNpqW8LDhBlppJnOaWRM',
      domain: 'matiazzz.auth0.com'
    });
});