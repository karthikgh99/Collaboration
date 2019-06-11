myApp.controller("BlogCommentController",function($scope,$location,$http,$rootScope)
		{
	$scope.blog={"blogid":"0","blogname":"","blogcontent":"","username":"","createdate":"","status":"","likes":"","dislike":""};

	
	$scope.blogCommentData;
	
	$scope.blogComment={"blogcommentid":0,"commentdata":"","commentedon":"","blog":"","user":""};
	
	function loadBlogComments()
	{
		console.log('Blog Comment List');
		$http.get('http://localhost:8081/CollaborationMiddleware/listBlogComments/'+$rootScope.blogId)
				.then(function(response)
						{
					console.log(response.data);
					$scope.blogCommentdata=response.data;
						});
	}
	
	$scope.insertComment=function(blog)
	{
		console.log('Inserting comment');
		
		$scope.blogComment.user=$rootScope.currrentUser;
		$scope.blogComment.blog=blog;
		
		console.log($scope.blogComment);
		
		$http.post('http://localhost:8081/CollaborationMiddleware/addBlogComment',$scope.blogComment)
				.then(function(response){
						console.log('Blog Comment Added');
						loadBlogComments();
					$location.path("/showBlogComments");
						});
	}
	
	$scope.deleteComment=function(blogId)
	{
		console.log('I am in Blog Comment Deletion');
		
		
		$http.get('http://localhost:8081/CollaborationMiddleware/deleteBlogComment'+commentId)
				.then(function(response){
						console.log('Blog Comment Deleted');
						loadBlogComments();
					$location.path("/showBlogComments");
						});
	}
	
	$scope.incrementLikes=function(blogId)
	{
		console.log('I am in Incrementing Likes Blog')
		
		$http.get('http://localhost:8081/CollaborationMiddleware/incrementLikes/'+blogId)
		.then(function(response)
						{
			alert("Blog Likes are Incremented");
						});
	}
	
	$scope.incrementDisLikes=function(blogId)
	{
		console.log('I am in implementing DisLikes Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/incrementDisLikes/'+blogId)
		.then(function(response){
			alert("Blog Dislikes incremented")
	});
	}
	
	function loadBlogData()
	{
		console.log('Blog Data');
		$http.get('http://localhost:8081/CollaborationMiddleware/getBlog/'+$rootScope.blogId)
				.then(function(response)
						{
					$scope.blog=response.data;
						});
	}
	loadBlogData();
	loadBlogComments();
		});