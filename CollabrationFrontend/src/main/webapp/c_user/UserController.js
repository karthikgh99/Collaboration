myApp.controller("userController",function($scope,$location,$http,$rootScope,$cookieStore)
{
	$scope.user={"username":"","password":"","name":"","emailid":"","role":"","status":"","isOnline":""};
	
	
	
	$scope.loginCheck=function()
	{
			console.log("I am in Login Check");
			console.log($scope.user.username);
			console.log($scope.user.password);
			

			$http.post("http://localhost:8081/CollaborationMiddleware/checkUser",$scope.user)
			.then(function(response)
					{
				console.log('Loged In');
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				console.log($rootScope.currentUser);
				$cookieStore.put('userdetails',response.data);
				console.log(response.data);
				$location.path("/userHome");
					
	});
	}
	
	$scope.logout=function()
	{
		console.log("I am in logout Function");
		$http.put("http://localhost:8081/CollaborationMiddleware/logout",$scope.user)
		.then(function(response)
		{
		delete $rootScope.currentUser;
		$cookieStore.remove('userdetails');
		$location.path("/login");
	})
	}
	
	
	$scope.register=function(user)
	{
		console.log("I am in Register Function");
	$scope.user=user;
	$scope.user.role="ROLE_USER";
	$scope.user.status='A';
	$scope.user.isOnline='Y';
	console.log($scope.user.name);
	console.log($scope.user.emailid);
	
		console.log(user);
		$http.post("http://localhost:8081/CollaborationMiddleware/registerUser",user)
		.then(function(response)
				{
			$scope.user=response.data;
			
			console.log('Registered '+$scope.user);
			$location.path("/login");
				});
	}
		});

	
