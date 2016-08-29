'use strict';
app

	.controller(
				'AdminController',
				
			
				[
						'$scope',
						'$routeParams',
						'$route',
						'$location',
						'$http',

						function($scope, $routeParams, $route, $location,
							$http) {
							var self = this;
							
								self.submitUser = function() {
									
								console.log('inside the submite user method');
								var file = $scope.myFile;
								console.log('the file is --  ' + file);
								var uploadUrl = "/AKFoundation/admin/saveUserDataAndFile";
								var fd = new FormData();
								fd.append('file', file);
								fd.append('children',angular.toJson($scope.children,true));
								console.log('Socpe of user'+$scope.children.firstName);
								$http.post(uploadUrl, fd, {
								transformRequest : angular.identity,
								headers : {
								'Content-Type' : undefined
								}
								}).success(function() {
								console.log('success');
								}).error(function() {
								console.log('error');
								});
								};

						} ]);
