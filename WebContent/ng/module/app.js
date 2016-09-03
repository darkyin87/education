'use strict';
// var user = angular.module("user", ["ngRoute"]);
var AngularSpringApp = {};
var app = angular.module("AngularSpringApp", [ "ngRoute" ]);

app.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$routeProvider.when('/register/:imageName/:childrenId', {
				templateUrl : '/AKFoundation/views/registerVolunteer.html',
				controller : 'UserController',
				controllerAs : 'userCtrl'
			}).when('/', {
				templateUrl : "/AKFoundation/views/index.html",
				controller : "CarouselController"
			}).when('/addChildren', {
				templateUrl : "/AKFoundation/views/addChildren.html",
				controller : "AdminController",
				controllerAs : "adminCtrl"
			})
			.when('/addTestimonials', {
				templateUrl : "/AKFoundation/views/addTestimonials.html",
				controller : "AdminController",
				controllerAs : "adminCtrl"
			})
		} ]);

app.directive('googleplace', function() {
	return {
		require : 'ngModel',
		link : function(scope, element, attrs, model) {
			var options = {
				// types: ['address'],
				types : [ 'geocode' ],
				componentRestrictions : {}
			};
			scope.gPlace = new google.maps.places.Autocomplete(element[0],
					options);

			google.maps.event.addListener(scope.gPlace, 'place_changed',
					function() {
						// var geoComponents = scope.gPlace.getPlace();
						// var addressComponents =
						// geoComponents.address_components;
						//
						// addressComponents =
						// addressComponents.filter(function(component){
						// switch (component.types[0]) {
						// case "locality": // city
						// return true;
						// case "administrative_area_level_1": // state
						// return true;
						// case "country": // country
						// return true;
						// default:
						// return false;
						// }
						// }).map(function(obj) {
						// return obj.long_name;
						// });

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

app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					console.log("is it going insid eht ebind methodh of the scope apply");
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);