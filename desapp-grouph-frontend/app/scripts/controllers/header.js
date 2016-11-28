'use strict';

angular.module('desappGrouphFrontendApp')
  .controller('HeaderCtrl', function ($scope, $location, $translate, tmhDynamicLocale) {

    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };

    $scope.changeLanguage = function (language) {
      $translate.use(language);
      if(language === 'es') {
        tmhDynamicLocale.set(language+'-ar');
      }
      else {
        tmhDynamicLocale.set(language+'-us');
      }
    };

  });
