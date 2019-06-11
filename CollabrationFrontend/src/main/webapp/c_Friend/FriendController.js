myApp.controller("friendController",function($scope,$location,$http,$rootScope,$cookieStore)
{
	$scope.friend={"friendId":"0","username":'',"friendusername":'',"status":''};
	
	$scope.friendList;
	
	$scope.pendingFriendList;
	
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('I am in Showing Friend List');
		
		console.log($rootScope.currentUser.username);
	
		$http.get('http://localhost:8081/CollaborationMiddleware/showFriendList/'+$rootScope.currentUser)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.friendList);
		});
	}
	showFriendList();
});