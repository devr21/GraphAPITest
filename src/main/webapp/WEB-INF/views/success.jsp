<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Logged IN</title>
	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script type="text/javascript" src="../static/js/usercontroller.js"></script>
	<script type="text/javascript">
		
	$(function() {
    console.log( $("#userId").val() 	 );
	});

	</script>
</head>
<body>
<div ng-app="user">
<input type="hidden" name="userId" id="userId" ng-model="userId" value="${it.user.getUserId() }"></input>
<input type="button" ng-model="FetchFromFB" ng-click="fetchUserDataFromFB(userId)">
</div>


</body>
</html>