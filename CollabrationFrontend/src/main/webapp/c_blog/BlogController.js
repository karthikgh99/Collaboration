myApp.controller("BlogController",function($scope,$location,$http,$rootScope)
{			
$scope.blog={"blogid":"0","blogname":"","blogcontent":"","username":"","createdate":"","status":"","likes":"","dislike":""};
	
	$scope.blogData=[];
	
	$scope.addBlog=function(blog)
	{
		console.log('Adding Blog Information');
		
		$http.post('http://localhost:8081/CollaborationMiddleware/addBlog',blog)
		.then(function(response)
				{
			alert("Adding a Blog Info");
			loadBlogs();
			$location.path("/addBlog");
			});
	}
	
	$scope.incrementLikes=function(blogId)
	{
		console.log('I am in implementing Likes Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/incrementLikes/'+blogId)
		.then(function(response){
			alert("Blog likes incremented")
			loadBlogs();
			$location.path("/showBlog");
	});
	}
	
	$scope.incrementDisLikes=function(blogId)
	{
		console.log('I am in implementing DisLikes Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/incrementDisLikes/'+blogId)
		.then(function(response){
			alert("Blog Dislikes incremented")
			loadBlogs();
			$location.path("/showBlog");
	});
	}
	
	$scope.deleteBlog=function(blogId)
	{
		console.log('I am in Deleting Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/deleteBlog/'+blogId)
		.then(function(response){
			alert("Blog is deleted")
	});
	}
	
	$scope.approve=function(blogId)
	{
		console.log('I am in Approving Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/approveBlog/'+blogId)
		.then(function(response){
			alert("Blog is approved with BlogID"+blogId);
			loadBlogs();
			$location.path("/manageBlog");
	});
	}
	
	$scope.reject=function(blogId)
	{
		console.log('I am in Rejecting Blog');
		
		$http.get('http://localhost:8081/CollaborationMiddleware/rejectBlog/'+blogId)
		.then(function(response)
				{
			alert("Blog is rejected with BlogID"+blogId);
			loadBlogs();
			$location.path("/manageBlog");
	});
	}
	
	function loadBlogs()
	{
		console.log('Blog list');
		$http.get('http://localhost:8081/CollaborationMiddleware/showAllBlogs')
		.then(function(response)
		{
			console.log(response.data);
			$scope.blogData=response.data;
				});
	}
	
	$scope.showComments=function(blogId)
	{
		console.log('Showing Blog Comments');
		$rootScope.blogId=blogId;
		$location.path("/showBlogComments");
	}
	
	loadBlogs();
});
				