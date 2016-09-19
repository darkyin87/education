'use strict';

app.controller('CarouselController', ['$scope', 'CarouselService','$http','$location',

function($scope, CarouselService,$http,$location) {
    $scope.firstName = 'Gokul'

    $scope.data = {
            singleSelect: null,
            multipleSelect: [],
            option1: 'option-1',
           };

    $scope.fetchVolunteerPage = function(callback){
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
    
    
    var testimonials=function(callback) {
        console.log('going inside the testimonials');
       $http.get('/AKFoundation/Testimonial/getAll')
    .success(function(data) {
        callback(data);
        console.log('inside the testimonials call method' + data);
    })
    .error(function(data, status) {
      console.error('Repos error', status, data);
    });
   };
   
   testimonials(function(data){
       $scope.testimonials = data;
   });


    $('#myCarousel').bind('slide.bs.carousel', function (e) {
        var activeSlide = $('#myCarousel div.active');
        var completedPercent = 0;
        var remainingPercent = 100;
        if (activeSlide.index() != -1) {
            var completedPercent = parseFloat(angular.element(activeSlide[0]).attr('completedpercent'));
        }
        $('#completedPercent').text(completedPercent + "% reached");
        $('#remainingPercent').text((100 - completedPercent) + "% remaining");
        var progressEl = angular.element($('#myCarousel .progress-bar')[0]);
        progressEl.css('width', completedPercent + '%');
        var progressDangerEl = angular.element($('#myCarousel .progress-bar-danger')[0])
        progressDangerEl.attr('aria-valuenow', (100 - completedPercent));
        progressDangerEl.css('width', (100 - completedPercent)+'%');
    });

}]);