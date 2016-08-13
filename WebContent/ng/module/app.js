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



app.run([
  '$rootScope',
  function($rootScope) {
    // see what's going on when the route tries to change
    $rootScope.$on('routeChangeStart', function(event, next, current) {

      console.log('Starting to leave %s to go to %s', current.currentPath, next.nextPath);
    });
  }
]);