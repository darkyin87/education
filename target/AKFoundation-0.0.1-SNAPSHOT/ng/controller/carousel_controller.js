'use strict';
 
app.controller('CarouselController', ['$scope', 'CarouselService','$http','$location', function($scope, CarouselService,$http,$location) {
    $scope.firstName = 'Gokul'

    $scope.data = {
            singleSelect: null,
            multipleSelect: [],
            option1: 'option-1',
           };

    $scope.fetchVolunteerPage = function(callback){
        console.log("test method");

        $http.get( "/AKFoundation/volunteer/register" );

    };

  $scope.w = window.innerWidth;
  $scope.h = window.innerHeight-20;
 
    var images;


    var images=function(callback) {
         console.log('going inside the images');
        $http.get('/AKFoundation/Children/getAll')
     .success(function(data) {
         callback(data);
         console.log('inside the images call method' + data);

       //return data;
     })
     .error(function(data, status) {
       console.error('Repos error', status, data);
     });
    };


    images(function(data){
        $scope.images = data;
    });

}]);