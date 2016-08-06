'use strict';
//var user = angular.module("user",  ["ngRoute"]);
var app = angular.module("app", ["ngRoute"]);
app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/views/index.html', {
          controller: function() {
                      debugger;
                     }
        }).
        when('/AKFoundation/welcome', {
          controller: function() {
            debugger;
           }
        }).
        when('/AKFoundation/volunteer/register/:imageName', {
            controller: function() {
                debugger;
            }
        })
}]);