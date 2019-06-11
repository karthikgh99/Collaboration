var myApp=angular.module("myApp1",['ngRoute','ngCookies']);

myApp.config(function($routeProvider,$locationProvider) 
    {
	 $locationProvider.hashPrefix('');
	alert("I am in Config function with Router Provider");
    $routeProvider.when("/userhome",{templateUrl:"index.html"})
    .when("/login", {templateUrl : "c_user/Login.html",
    controller:"userController"
    })
    .when("/register",{
    	templateUrl : "c_user/Register.html",
    	controller:"userController"
    		})
    		.when("/profilePicture",{
    	templateUrl : "c_user/ProfilePicture.html",
    	controller:"userController"
    		})
    .when("/addBlog", {templateUrl:"c_blog/AddBlog.html",
    controller:"BlogController"	
    })
     .when("/manageBlog", {templateUrl:"c_blog/AdminBlog.html",
    controller:"BlogController"	
    })
  .when("/showBlog", {templateUrl:"c_blog/ShowBlog.html",
	  controller:"BlogController"
  })
   .when("/showBlogComments", {
	   templateUrl:"c_blog/ShowBlogComments.html",
	  controller:"BlogCommentController"
  })
  .when("/userHome", {templateUrl : "c_user/UserHome.html",
    controller:"userController"
})
   .when("/friend", {templateUrl:"c_Friend/FriendList.html",
	  controller:"FriendController"
  })
    
.when("/chat",{templateUrl : "c_chat/Chat.html",
controller:"chatController"
})
.when("/addjob",{templateUrl : "c_job/Job.html",
controller:"JobController"
})
});

myApp.run(function($rootScope,$cookieStore){
	
	console.log('Iam in run function');
	console.log($rootScope.currentUser);
	
	if($rootScope.currentUser==undefined)
		{
		console.log($cookieStore.get('userdetails'));
		$rootScope.currentUser=$cookieStore.get('userdetails');
		}
});