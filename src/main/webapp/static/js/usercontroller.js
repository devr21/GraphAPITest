angular.module('user', []).controller('userCtrl', function($scope,$http){
console.log("loading");
	$scope.fetchUserDataFromFB = function(){
		console.log($scope.userId);
		var userId = $scope.userId;
		$http.get("http://localhost:8080/GraphAPITest/service/user/fetchfromfb/"+userId)
			.success(function(data,status,header,config){
				console.log(data);
				$scope.user = data;
			})
			.error(function(error){
				console.log(error);
			})
	}

});