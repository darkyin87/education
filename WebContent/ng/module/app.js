'use strict';
//var user = angular.module("user",  ["ngRoute"]);
var AngularSpringApp = {};
var app = angular.module("AngularSpringApp", ["ngRoute"]);

app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/register/:imageName/:childrenId', {
          templateUrl: '/AKFoundation/views/registerVolunteer.html',
          controller: 'UserController',
          controllerAs: 'userCtrl'
        })
        .when('/', {
            templateUrl: "/AKFoundation/views/index.html",
            controller: "CarouselController"
        })
}]);


app.directive('googleplace', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, model) {
            var options = {
                //types: ['address'],
            	types:['geocode'],
                componentRestrictions: {}
            };
            scope.gPlace = new google.maps.places.Autocomplete(element[0], options);


            google.maps.event.addListener(scope.gPlace, 'place_changed', function() {
              // var geoComponents = scope.gPlace.getPlace();
              // var addressComponents = geoComponents.address_components;
              //
              // addressComponents = addressComponents.filter(function(component){
              //       switch (component.types[0]) {
              //           case "locality": // city
              //               return true;
              //           case "administrative_area_level_1": // state
              //               return true;
              //           case "country": // country
              //               return true;
              //           default:
              //               return false;
              //       }
              //   }).map(function(obj) {
              //       return obj.long_name;
              //   });

              scope.$apply(function() {
                // model.city.name = addressComponents[0];
                // model.state.name = addressComponents[1];
                // model.country.name = addressComponents[2];
                model.$setViewValue(element.val());
              });
            });
        }
    };
});



// app.run([
//   '$rootScope',
//   function($rootScope) {
//     // see what's going on when the route tries to change
//     $rootScope.$on('routeChangeStart', function(event, next, current) {
//
//       console.log('Starting to leave %s to go to %s', current.currentPath, next.nextPath);
//     });
//   }
// ]);
