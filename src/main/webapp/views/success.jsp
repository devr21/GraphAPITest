<!DOCTYPE html>
<html>
<head>
	<title>Logged IN</title>
	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/GraphAPITest/static/js/angular.js"></script>
	<script type="text/javascript" src="/GraphAPITest/static/js/usercontroller.js"></script>
	
</head>
<body>
<div ng-app="user" ng-controller="userCtrl" ng-init="userId='${it.user.getUserId() }'">
<input type="button" value="Start" ng-click="fetchUserDataFromFB()">
</div>


</body>
</html>