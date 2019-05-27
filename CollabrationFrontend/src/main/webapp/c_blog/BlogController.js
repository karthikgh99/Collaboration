myApp.controller("BlogController",function($scope,$location,$http,$rootscope)
{			
$scope.blog={"blogId":"0","blogName":"","blogContent":"","username":"","createdate":"","status":"","likes":"","dislike":""};
	
	$scope.blogData;
	
	$scope.addBlog=function()
	{
		console.log('Adding Blog Information');
		
		$http.post('http://localhost:8088/CollaborationMiddleware/addBlog',$scope.blog)
		.then(function(response)
				{
			alert("Adding a Blog Info");
			$location.path("/addBlog");
			});
	}
	
	$scope.incrementLikes=function(blogId)
	{
		console.log('I am in implementing Likes Blog');
		
		$http.get('http://localhost:8088/CollaborationMiddleware/incrementLikes/'+blogId)
		.then(function(response){
			alert("Blog likes incremented")
	});
	}
	
	$scope.incrementDisLikes=function(blogId)
	{
		console.log('I am in implementing DisLikes Blog');
		
		$http.get('http://localhost:8088/CollaborationMiddleware/incrementDisLikes/'+blogId)
		.then(function(response){
			alert("Blog Dislikes incremented")
	});
	}
	
	$scope.deleteBlog=function(blogId)
	{
		console.log('I am in Deleting Blog');
		
		$http.get('http://localhost:8088/CollaborationMiddleware/deleteBlog/'+blogId)
		.then(function(response){
			alert("Blog is deleted")
	});
	}
	
	$scope.approve=function(blogId)
	{
		console.log('I am in Approving Blog');
		
		$http.get('http://localhost:8088/CollaborationMiddleware/')
		.then(function(response){
			alert("Blog is approved with BlogID"+blogId);
	});
	}
	
	$scope.reject=function(blogId)
	{
		console.log('I am in Rejecting Blog');
		
		$http.get('http://localhost:8088/CollaborationMiddleware/')
		.then(function(response){
	});
	}
	
	function loadBlogs()
	{
		console.log('Blog list');
		$http.get('http://localhost:8088/CollaborationMiddleware/showAllBlogs')
		.then(function(response)
		{
			console.log(response.data);
			$scope.blogData=response.data;
				});
	}
	
	$scope.showComments=function(blogId)
	{
		console.log('Showing Blog Comments');
		$rootScope.blogId=BlogId;
		$location.path("/showBlogComments");
	}
	loadBlogs();
});
				