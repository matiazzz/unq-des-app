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
    'angular-jwt',
    'ngMaterial',
    'ngMessages',
    'ngMap',
    'tmh.dynamicLocale'
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
      .when('/select-event-type', {
        templateUrl: 'views/select-event-type.html',
        controller: 'CreateEventCtrl',
        controllerAs: 'createEvent'
      })
      .when('/create-event', {
        templateUrl: 'views/create-event.html',
        controller: 'CreateEventCtrl',
        controllerAs: 'createEvent'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'loginCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

.config(function ($translateProvider, tmhDynamicLocaleProvider) {
    $translateProvider.translations('en', {
      'APPNAME': 'Where we go?',
      'HOME': 'Home',
      'EVENTS': 'Events',
      'SEARCH': 'Search',
      'login': 'Login',
      'logout': 'Logout',
      'description': 'Description',
      'price': 'Price',
      'plannings': 'Plannings',
      'preferences': 'Preferences',
      'profile': 'Profile',
      'settings': 'Setting'
    });

    $translateProvider.translations('es', {
      'APPNAME': '¿A dónde vamos?',
      'HOME': 'Inicio',
      'EVENTS': 'Eventos',
      'SEARCH': 'Buscar',
      'login': 'Iniciar sesión',
      'logout': 'Salir',
      'description': 'Descripción',
      'price': 'Precio',
      'plannings': 'Salidas',
      'preferences': 'Preferencias',
      'profile': 'Perfil',
      'settings': 'Configuración'
      });

    $translateProvider.preferredLanguage('es');

    tmhDynamicLocaleProvider.localeLocationPattern('/scripts/angular-i18n/angular-locale_{{locale}}.js');
  })

  .config(function (lockProvider, jwtOptionsProvider) {
    lockProvider.init({
      clientID: 'HpQcbV9OE6ImZNpqW8LDhBlppJnOaWRM',
      domain: 'matiazzz.auth0.com'
    });
    // Configuration for angular-jwt
    jwtOptionsProvider.config({
      tokenGetter: function () {
        return localStorage.getItem('id_token');
      }
    });
});
