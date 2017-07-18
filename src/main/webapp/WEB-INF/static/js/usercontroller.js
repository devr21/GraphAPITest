angular.module('user', []).controller('userController', function($scope,$http){

	$scope.fetchUserDataFromFB = function(userId){
		console.log(userId);
		$http.get("http://localhost:8080/GraphAPITest/service/user/fetchfromfb/userId")
			.success(function(data,status,header,config){
				console.log(data);
				$scope.user = data;
			})
			.error(function(error){
				console.log(error);
			})
	}

}