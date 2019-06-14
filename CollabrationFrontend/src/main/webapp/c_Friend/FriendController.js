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
	
		$http.get('http://localhost:8081/CollaborationMiddleware/showFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.friendList);
		});
	}
	
	function showPendingFriendList()
	{
		console.log('I am in Showing Pending Friend List');
		
		console.log($rootScope.currentUser.username);
	
		$http.get('http://localhost:8081/CollaborationMiddleware/pendingFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.pendingFriendList=response.data;
			console.log($scope.pendingFriendList);
		});
	}
	
	function showSuggestedFriendList()
	{
		console.log('I am in Showing Suggested Friend List');
		
		console.log($rootScope.currentUser.username);
	
		$http.get('http://localhost:8081/CollaborationMiddleware/suggestedFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.suggestedFriendList=response.data;
			console.log($scope.suggestedFriendList.length);
		});
	}
	
	$scope.unfriend=function(friendId)
	{
		console.log('I am in Unfriend '+friendId);
		$http.get('http://localhost:8081/CollaborationMiddleware/deleteFriendRequest/'+friendId)
		.then(function(response){
			console.log('Unfriend Successful');
			$location.path('/friend');
		});
	}
	
	$scope.accept=function(friendId)
	{
		console.log('I am in Accepting friend Request');
		$http.get('http://localhost:8081/CollaborationMiddleware/acceptFriendRequest/'+friendId)
		.then(function(response){
			console.log('Accepted Successful');
			
			$location.path('/friend');
		});
	}
	
	$scope.friendRequest=function(friendusername)
	{
		console.log('i am in Send Friend Request');
		$scope.friend.username=$rootScope.currentUser.username;
		$scope.friend.friendusername=friendusername;
		$http.post('http://localhost:8081/CollaborationMiddleware/sendFriendRequest',$scope.friend)
		.then(function(response){
			console.log('Friend Request sent Successful');
			$location.path('/friend');
	});
	}
	
	showFriendList();
	showPendingFriendList();
	showSuggestedFriendList();
});