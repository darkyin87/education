<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<!-- Set the viewport so this responsive site displays correctly on mobile devices -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register New User</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}

}
</style>



<!-- Include bootstrap CSS -->
<link href="<c:url value='/resources/style.css/'/>" rel="stylesheet"></link>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="<c:url value='/resources/jquery/jquery-2.2.0.min.js' />"></script>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-route.min.js"></script>

<script src="<c:url value='/angular/module/carousel.js' />"></script>

<script src="<c:url value='/angular/controller/carousel_controller.js' />"></script>
<script src="<c:url value='/angular/service/carousel_service.js' />"></script>

</head>
<body>

  <div ng-app="carousel">
  
  <div class="banner">
		<div class="container">

			<h1>Twitter Bootstrap 3: Responsive Design Tutorial</h1>
			<p>A comprehensive tutorial showing you how to quickly create
				responsive designs using Twitter Bootstrap 3.</p>
		</div>
	</div>
	
	
  <div class="container" ng-controller="CarouselController"> 
    <!-- Carousel================================================== -->
        
            {{firstName}}
        
    <div id="myCarousel" class="carousel slide" data-ride="carousel"> 
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" ng-repeat="img in images" class="{active : (img === 0)}" data-slide-to="{{img.childrenId}}"></li>
      </ol>
      <div class="carousel-inner">
        <div ng-class="{item: true, active : (img === 0)}" ng-repeat="img in images"> <img ng-src="image/gallery/{{img.picture}}.jpg" alt="Slide numder {{img}}">
          <div class="container">
            <div class="carousel-caption"> </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> </div>
   
  </div>
</div>

<!-- Include jQuery and bootstrap JS plugins -->
	
</body>
</html>