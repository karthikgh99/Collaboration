myApp.controller("userController",function($scope,$location,$http,$rootScope)
{
	//$scope.user={"username":"","password":"","name":"","emailid":"","role":"","status":"","isonline":""};
	
	
	
	$scope.loginCheck=function()
	{
			console.log("I am in Login Check");
			console.log($scope.user.username);
			console.log($scope.user.password);
			

			$http.post("http://localhost:8088/CollaborationMiddleware/checkUser",$scope.user)
			.then(function(response)
					{
				console.log('Loged In');
				$scope.user=resonse.data;
				$rootScope.currentUser=response.data;
				console.log($rootScope.currentUser);
				$cookieStore.put('userdatails',response.data);
				console.log(response.data);
				$location.path("/userHome");
					
	});
	}
	
	$scope.logout=function()
	{
		console.log('I am in logout Function');
		delete $rootScope.currentUser;
		$coookiestore.remove('user');
		$location.path("/logout");
	}
	
	
	$scope.register=function(user)
	{
		console.log("I am in Register Function");
//		$scope.user=user;
//		$scope.user.role="ROLE_USER";
//		$scope.user.status='A';
//		$scope.user.isOnline='Y';
//		
//		console.log($scope.user.name);
//		console.log($scope.user.emailid);
//		
		console.log(user);
		$http.post("http://localhost:8088/CollaborationMiddleware/registerUser",user)
		.then(function(response)
				{
			console.log('Registered');
			$location.path("/login");
				});
	}
		});

	
