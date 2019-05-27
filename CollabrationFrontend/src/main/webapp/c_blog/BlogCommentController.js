myApp.controller("BlogCommentController",function($scope,$location,$http,$rootScope)
		{
	$scope.blog={"blogId":0,"blogName":"","blogContent":"","username":"","createDate":"","status":"","like":"","dislikes":""};
	$scope.blogCommentData;
	
	$scope.blogComment={"commentId":0,"commentData":"","createDate":"","username":""};
	
	function loadBlogComments()
	{
		console.log('Blog Comment List');
		$http.get('http://localhost:8088/CollaborationMiddleware/listBlogComments/'+$rootScope.blogId)
				.then(function(response)
						{
					console.log(responsedata);
					$scope.blogCommentdata=response.data;
						});
	}
	
	$scope.insertComment=function(blogId)
	{
		console.log('Inserting comment');
		
		$scope.blogComment.username=$rootScope.currrentUser.username;
		$scope.blogComment.blogId=blogId;
		
		console.log($scope.blogComment);
		
		$http.get('http://localhost:8088/CollaborationMiddleware/addblogComment',$scope.blogComment)
				.then(function(response){
						console.log('Blog Comment Added');
					$location.path("/showBlogComment");
						});
	}
	
	$scope.deleteComment=function(blogId)
	{
		console.log('I am in Blog Comment Deletion');
		
		
		$http.get('http://localhost:8088/CollaborationMiddleware/deleteBlogComment'+commentId)
				.then(function(response){
						console.log('Blog Comment Deleted');
					$location.path("/showBlogComment");
						});
	}
	
	$scope.incrementLikes=function(blogId)
	{
		console.log('I am in Incrementing Likes Blog')
		
		$http.get('http://localhost:8088/CollaborationMiddleware/incrementLikes/'+blogId)
		.then(function(response)
						{
			alert("Blog Likes are Incremented");
						});
	}
	
	function loadBlogData()
	{
		console.log('Blog Data');
		$http.get('http://localhost:8088/CollaborationMiddleware//'+$rootScope.blogId)
				.then(function(response)
						{
					$scope.blog=response.data;
						});
	}
	loadBlogData();
	loadBlogComments();
		});