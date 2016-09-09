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
							
							var pages=function(callback) {
							         console.log('going inside the pages');
						         $http.get('/AKFoundation/admin/getPages')
							     .success(function(data) {
							         callback(data);
							         console.log('inside the images call method' + data);

							       //return data;
							     })
							     .error(function(data, status) {
							       console.error('Repos error', status, data);
							     });
							    };
									
									pages(function(data){
									        $scope.pages = data;
									        console.log(" the date is --  " + $scope.pages);
									    });
	
							
							$scope.choices = [];
							$scope.addNewChoice = function() {
							  var newItemNo = $scope.choices.length+1;
							  $scope.choices.push({'id':'choice'+newItemNo});
							};
							  
							$scope.removeChoice = function() {
							  var lastItem = $scope.choices.length-1;
							  $scope.choices.splice(lastItem);
							};
							
							
							
							
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
									
									self.selectAction = function(item) {
										
										console.log('going inside the on chnage thing' + item.pageId);
										
										AdminService.getPageSectionForPage(item.pageId)
										.then(
												
												function successCallback(response){
													
													console.log('success call back in getpagesection--  ' + response);
													$scope.choices = response
													
													
												},
												function errorCallback(response){
													
												}
												
										
										)
										
										
									};
									
									self.createPage = function() {
										
										console.log('inside the right create page method ');
										AdminService
										.createPage(self.pages)
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
										
										
												
									      
										self.createPageSection = function() {
											
											console.log('inside the right create page section method '+ $scope.choices[1].sectionDetail);

											
											
											};

						} ]);
