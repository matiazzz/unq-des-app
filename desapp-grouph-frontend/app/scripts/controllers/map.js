'use strict';

angular.module('desappGrouphFrontendApp')
.controller( 'MapCtrl', function ($scope) {

    var map;
    var latlng = {lat: -34.6123419, lng: -58.4384477};
    var options = {
      center: latlng,
      zoom: 12
    };
    var geocoder;

    $(document).ready(function(){});

    $('#buscar').click(function(){

      var address = $('#direccion').val();

      geocoder.geocode({'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          map.setCenter(results[0].geometry.location);
          map.setZoom(15);

          var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
          });

        }else{
          alert("No podemos encontrar la direccion, error: " + status);
        }
      });
    });

    $scope.initMap = function () {
      map = new google.maps.Map(document.getElementById('map'), options);
      geocoder = new google.maps.Geocoder();
    }


});
