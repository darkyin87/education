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
</style>
<!-- Include bootstrap CSS -->
<link href="<c:url value='/resources/style.css/'/>" rel="stylesheet"></link>
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-route.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
	
	<script type="text/javascript">
  Stripe.setPublishableKey('pk_test_HDGRdtAbsQP3JT5FGgY3NaNz');
</script>

<script src="<c:url value='/angular/module/app.js' />"></script>
<script src="<c:url value='/angular/controller/user_controller.js' />"></script>
<script src="<c:url value='/angular/service/user_service.js' />"></script>
<script src="<c:url value='/node/index.js' />"></script>

<script src="http://cdn.rawgit.com/laurihy/angular-payments/2472bc9befa256780d106a8e53a9dea12b7341ed/lib/angular-payments.js"></script>

<script>
/* $(function() {
	  var $form = $('#payment-form');
	  $form.submit(function(event) {
	    // Disable the submit button to prevent repeated clicks:
	    $form.find('.submit').prop('disabled', true);

	    // Request a token from Stripe:
	    Stripe.card.createToken($form, stripeResponseHandler);
			
	    // Prevent the form from being submitted:
	    return false;
	  });
	});
	
function stripeResponseHandler(status, response) {
	  // Grab the form:
	  var $form = $('#payment-form');

	  if (response.error) { // Problem!

	    // Show the errors on the form:
	    $form.find('.payment-errors').text(response.error.message);
	    $form.find('.submit').prop('disabled', false); // Re-enable submission

	  } else { // Token was created!

	    // Get the token ID:
	    var token = response.id;
		alert('token created'+ token);
	    // Insert the token ID into the form so it gets submitted to the server:
	    $form.append($('<input type="hidden" name="stripeToken">').val(token));

	    // Submit the form:
	    $form.get(0).submit();
	  }
	}; */
	
</script>
</head>
<body ng-app="user">
	<!-- Site header and navigation -->
	<header class="top" role="header">
		<div class="container">
			<a href="#" class="navbar-brand pull-left"> BS3 TUTORIAL </a>
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="glyphicon glyphicon-align-justify"></span>
			</button>
			<nav class="navbar-collapse collapse" role="navigation">
				<ul class="navbar-nav nav">
					<li><a href="/CricketLeague/displayTeams">Teams</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<!-- Site banner -->
	<div class="banner">
		<div class="container">

			<h1>Twitter Bootstrap 3: Responsive Design Tutorial</h1>
			<p>A comprehensive tutorial showing you how to quickly create
				responsive designs using Twitter Bootstrap 3.</p>
		</div>
	</div>

	<!-- Middle content section -->
	<div class="middle">
		<div class="container" ng-controller="UserController as userCtrl">
			<div id="messages" class="alert alert-success"
				data-ng-show="messages" data-ng-bind="messages"></div>
			<div class="col-md-9 content">
 				<form ng-submit="userCtrl.submit()" name="myForm" id="payment-form" class="form-horizontal">
<!-- 				<form action="/volunteer" method="POST" id="payment-form">
 --> 				 
					<h1>${imageName}</h1>
					
					<span class="payment-errors"></span>
					<input type="hidden" ng-model="userCtrl.user.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="fname">First
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="userCtrl.user.firstName" id="fname"
									class="username form-control input-sm"
									placeholder="Enter your first name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.fname.$error.required">This is a
										required field</span> <span ng-show="myForm.fname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.fname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="lname">Last
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="userCtrl.user.lastName" id="lname"
									class="username form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.lname.$error.required">This is a
										required field</span> <span ng-show="myForm.lname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.lname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="userCtrl.user.emailID" id="email"
									class="username form-control input-sm"
									placeholder="Enter your Email" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="phoneno">Phone
								Number</label>
							<div class="col-md-7">
								<input type="number" ng-model="userCtrl.user.phoneNumber"
									id="phonenbr" class="username form-control input-sm"
									placeholder="Enter your Phone Number" required
									ng-minlength="10" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.phonenbr.$error.required">This is
										a required field</span> <span
										ng-show="myForm.phonenbr.$error.minlength">Minimum
										length required is 3</span> <span
										ng-show="myForm.phonenbr.$error.minlength">Max length
										required is 10</span> <span ng-show="myForm.phonenbr.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="addressline1">Address
								Line 1</label>
							<div class="col-md-7">
								<input type="addres" ng-model="userCtrl.user.addressLine1"
									id="address" class="username form-control input-sm"
									placeholder="Enter your Address" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.address.$error.required">This is a
										required field</span> <span ng-show="myForm.address.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="city">City</label>
							<div class="col-md-7">
								<input type="city" ng-model="userCtrl.user.city" id="city"
									class="username form-control input-sm"
									placeholder="Enter your City" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.city.$error.required">This is a
										required field</span> <span ng-show="myForm.city.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="state">State</label>
							<div class="col-md-7">
								<input type="state" ng-model="userCtrl.user.state" id="state"
									class="username form-control input-sm"
									placeholder="Enter your state" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.state.$error.required">This is a
										required field</span> <span ng-show="myForm.state.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="zipCode">Zip
								Code</label>
							<div class="col-md-7">
								<input type="number" ng-model="userCtrl.user.zipCode"
									id="zipCode" class="username form-control input-sm"
									placeholder="Enter your zip code"
									ng-minlength="{{user.zipCode.minlength}}"
									ng-maxlength="{{user.zipCode.maxlength}}"
									ng-required='user.zipCode.required' />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.zipCode.$error.required">This is a
										required field</span> <span ng-show="myForm.zipCode.$invalid">This
										field is invalid </span> <span
										ng-show="myForm.zipCode.$error.minlength">Minimum
										length required is 5</span> <span
										ng-show="myForm.zipCode.$error.maxlength">Max length
										required is 5</span>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="password">Password</label>
							<div class="col-md-7">
								<input type="password" ng-model="userCtrl.user.password"
									id="password" class="username form-control input-sm"
									placeholder="Enter your Password" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.password.$error.required">This is
										a required field</span> <span ng-show="myForm.password.$invalid">This
										field is invalid </span>

								</div>
							</div>
						</div>
					</div>



				<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="image">Password</label>
							<img ng-src="/AKFoundation/image/gallery/${imageName}.jpg" alt="Slide numder {{img.childrenId}}">
						</div>
					</div>

					<br />



<input type="hidden" name="childrenId"  ng-model="userCtrl.user.childrenId" ng-init="userCtrl.user.childrenId='biy'" />


<label for="chkPassport">
            <input type="checkbox" id="chkPassport" ng-model="ShowPassport" ng-change="ShowHide()" />
            Do you want to Donate money
        </label>


<div class="row" ng-show="ShowPassport">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="amount">Donation Amount</label>
							<div class="col-md-7">
								<input type="amount" ng-model="userCtrl.user.amount"
									id="amount" class="amount form-control input-sm"
									placeholder="Donation Amount" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.amount.$error.required">This is
										a required field</span> <span ng-show="myForm.amount.$invalid">This
										field is invalid </span>

								</div>
							</div>
						</div>
					

					
					 
					<div class="form-row">
    <label>
      <span>Card Number</span>
      <input type="text" size="20" data-stripe="number">
    </label>
  </div>

  <div class="form-row">
    <label>
      <span>Expiration (MM/YY)</span>
      <input type="text" size="2" data-stripe="exp_month">
    </label>
    <span> / </span>
    <input type="text" size="2" data-stripe="exp_year">
  </div>

  <div class="form-row">
    <label>
      <span>CVC</span>
      <input type="text" size="4" data-stripe="cvc">
    </label>
  </div>
  </div>
  <div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Register" id="register"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">


						</div>
					</div>

<!--   <input type="submit" class="submit" value="Submit Payment">
 -->  
				</form>

			</div>


		</div>
	</div>

	<!-- Site footer -->
	<div class="bottom">
		<div class="container">
			<div class="col-md-4">
				<h3>
					<span class="glyphicon glyphicon-heart"></span> Footer section 1
				</h3>
				<p>Content for the first footer section.</p>
			</div>
			<div class="col-md-4">
				<h3>
					<span class="glyphicon glyphicon-star"></span> Footer section 2
				</h3>
				<p>Content for the second footer section.</p>
			</div>
			<div class="col-md-4">
				<h3>
					<span class="glyphicon glyphicon-music"></span> Footer section 3
				</h3>
				<p>Content for the third footer section.</p>
			</div>
		</div>
	</div>

	
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
</body>
</html>
