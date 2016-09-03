'use strict';
app

	.controller(
				'AdminController',
				
			
				[
						'$scope',
						'$routeParams',
						'$route',
						'$location',
						'AdminService',
						'$http',

						function($scope, $routeParams, $route, $location,AdminService,
							$http) {
							var self = this;
							
								self.addChildren = function() {
									
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
								
								
								self.addTestimonials = function() {
									
									
									AdminService
									.save(self.testimonial)
									.then(
											function successCallback(
													response) {
												self.clear();
												$scope.messages = 'testimonial created Successfully'
												// this callback will be
												// called asynchronously
												// when the response is
												// available
											},
											function errorCallback(response) {
												alert('fail' + response);
												// called asynchronously if
												// an error occurs
												// or server returns
												// response with an error
												// status.
											})
									
									//console.log('inside the submit testimonials method' + self.testimonial.company);
									
									};

						} ]);
