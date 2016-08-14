'use strict';

app.controller(
'UserController',
[
    '$scope',
    '$routeParams',
    '$route',
    '$location',
    'UserService',
    '$http',

    function($scope, $routeParams, $route, $location, UserService, $http) {
        var self = this;
        var localUser = '';
        $scope.imageName = $routeParams.imageName;
        $scope.childrenId = $routeParams.childrenId;
        //$scope.imageName = $location.url().split("/")[2];
		//$scope.childrenId = $location.url().split("/")[3];

		
        self.create = function(user) {
            UserService
                    .create(user)
                    .then(
                            function successCallback(
                                    response) {
                                self.clear();
                                $scope.messages = 'User Created Successfully'
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
        };

        self.clear = function() {
            console.log('clearning the form');
            $scope.myForm.$setPristine();
        }

        self.submit = function() {
            console.log('Saving New User', self.user);
            $scope.user = self.user;
            var form = angular.element(document
                    .querySelector('#payment-form'))[0];
            console.log('form ==' + self.user.donationYes);
            // self.create(self.user);
            // form.find('.submit').prop('disabled', true);
            
            
            if(self.user.donationYes == false)
            	{
                	self.create($scope.user);

            	
            	}else{
            angular.element(document
                    .getElementById('register'))[0].disabled = true;

            // Request a token from Stripe:
            Stripe.card.createToken(form,
                    stripeResponseHandler);

            return false;
            	}

        };

        function stripeResponseHandler(status, response) {
            $scope
                    .$apply(function() {
                        console
                                .log('is the user availabel -- '
                                        + angular
                                                .toJson($scope.user));
                        // Grab the form:
                        var form = angular
                                .element(document
                                        .querySelector('#payment-form'))[0];

                        if (response.error) { // Problem!
                            $scope.messages = response.error.message;
                            angular
                                    .element(document
                                            .getElementById('register'))[0].disabled = true;
                        } else { // Token was created!
                            // Get the token ID:
                            var token = response.id;
                            $scope.user.token = token;
                            self.create($scope.user);
                            console
                                    .log('user is still available --  '
                                            + angular
                                                    .toJson($scope.user));

                        }
                    });

        }
        ;

    }
    ]);
