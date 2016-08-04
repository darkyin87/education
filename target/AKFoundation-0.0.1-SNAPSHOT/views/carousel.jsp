<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en" ng-app="carousel">
<head>
<meta charset="UTF-8">
<title>Welcome To AKFoundation</title>


<style type="text/css">
.carousel{
    background: #2f4357;
    margin-top: 20px;
}
.carousel .item img{
    margin: 0 auto; /* Align slide image horizontally center */
}
.bs-example{
	margin: 20px;	
	
}
</style>



<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-route.min.js"></script>
<script src="<c:url value='/angular/module/carousel.js' />"></script>
<script src="<c:url value='/angular/controller/carousel_controller.js' />"></script>
<script src="<c:url value='/angular/service/carousel_service.js' />"></script>


</head>
<body ng-controller="CarouselController" >


  <div>
  	<div class="container"> 
    <!-- Carousel================================================== -->        
    <div id="myCarousel" class="carousel slide" data-interval="5000" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" ng-repeat="img in images" class="{active : ({{img.childrenId}} === 1)}" data-slide-to="{{img.childrenId}}"></li>
      </ol>
      <div class="carousel-inner">
        <div ng-class="{item: true, active : ({ {img.childrenId}} === 1)}" ng-repeat="img in images">
        <img ng-src="/AKFoundation/image/gallery/{{img.picture}}.jpg" alt="Slide numder {{img.childrenId}}">
          
              <div class="container">
          
          <div class="carousel-caption">
              <h1>Help us grow our campaign</h1>
              <p>Every cent counts to our goal !!!</p>
              <p><a  class="btn btn-lg btn-primary" href="/AKFoundation/volunteer/register/{{img.picture}}" role="button"> Donate</a></p>
                       </div>
            </div>
      </div>
          
        </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> </div>
   
  </div>
</div>
<div class="container"> 
</div>
</body>
</html>