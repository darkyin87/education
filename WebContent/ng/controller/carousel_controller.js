'use strict';

app
		.controller(
				'CarouselController',
				[
						'$rootScope',
						'$scope',
						'CarouselService',
						'$http',
						'$location',

						function($rootScope, $scope, CarouselService, $http,
								$location) {
							$scope.firstName = 'Gokul'

							$scope.data = {
								singleSelect : null,
								multipleSelect : [],
								option1 : 'option-1',
							};

							$scope.fetchVolunteerPage = function(callback) {
								$http.get("/AKFoundation/volunteer/register");

							};

							$scope.w = window.innerWidth;
							$scope.h = window.innerHeight - 20;

							var images;

							var images = function(callback) {
								console.log('going inside the images');
								$http
										.get('/AKFoundation/Children/getAll')
										.success(
												function(data) {
													callback(data);
													console
															.log('inside the images call method'
																	+ data);

													// return data;
												}).error(
												function(data, status) {
													console.error(
															'Repos error',
															status, data);
												});
							};

							images(function(data) {
								$scope.images = data;
							});

							var testimonials = function(callback) {
								console.log('going inside the testimonials');
								$http
										.get('/AKFoundation/Testimonial/getAll')
										.success(
												function(data) {
													callback(data);
													console
															.log('inside the testimonials call method'
																	+ data);
												}).error(
												function(data, status) {
													console.error(
															'Repos error',
															status, data);
												});
							};

							testimonials(function(data) {
								$scope.testimonials = data;
							});

							$('#myCarousel')
									.bind(
											'slide.bs.carousel',
											function(e) {
												var activeSlide = $('#myCarousel div.active');
												var completedPercent = 0;
												var remainingPercent = 100;
												if (activeSlide.index() != -1) {
													var completedPercent = parseFloat(angular
															.element(
																	activeSlide[0])
															.attr(
																	'completedpercent'));
												}
												$('#completedPercent').text(
														completedPercent
																+ "% reached");
												$('#remainingPercent')
														.text(
																(100 - completedPercent)
																		+ "% remaining");
												var progressEl = angular
														.element($('#myCarousel .progress-bar')[0]);
												progressEl.css('width',
														completedPercent + '%');
												var progressDangerEl = angular
														.element($('#myCarousel .progress-bar-danger')[0])
												progressDangerEl
														.attr(
																'aria-valuenow',
																(100 - completedPercent));
												progressDangerEl
														.css(
																'width',
																(100 - completedPercent)
																		+ '%');
											});

							var authenticate = function(credentials, callback) {

								var headers = credentials ? {
									authorization : "Basic "
											+ btoa(credentials.username + ":"
													+ credentials.password)
								} : {};

								$http.get('/AKFoundation/login/user', {
									headers : headers
								}).success(function(data) {

									console.log(data);
									if (data.firstName) {
										$rootScope.authenticated = true;
										$rootScope.userName = data.firstName

									} else {
										$rootScope.authenticated = false;
									}
									callback && callback();
								}).error(function() {
									$rootScope.authenticated = false;
									callback && callback();
								});
							}
							authenticate();
							$scope.credentials = {};

							$scope.login = function() {
								$http
										.post(
												'login',
												$.param($scope.credentials),
												{
													headers : {
														"content-type" : "application/x-www-form-urlencoded"
													}
												})
										.success(
												function(data) {
													authenticate(
															$scope.credentials,
															function() {
																if ($rootScope.authenticated) {
																	$location
																			.path("/addChildren");
																	$scope.error = false;
																} else {
																	$location
																			.path("/login");
																	$scope.error = true;
																}
															});
												}).error(function(data) {
											$location.path("/");
											$scope.error = true;
											$rootScope.authenticated = false;
										})
							};

						} ]);