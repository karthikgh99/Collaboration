var myApp=angular.module("myApp1",['ngRoute','ngCookies']);

myApp.config(function($routeProvider,$locationProvider) 
    {
	 $locationProvider.hashPrefix('');
	alert("I am in Config function with Router Provider");
    $routeProvider
    .when("/login", {templateUrl : "c_user/Login.html",
    controller:"userController"
    })
    .when("/register",{
    	templateUrl : "c_user/Register.html",
    	controller:"userController"
    		})
    .when("/addBlog", {templateUrl:"c_user/AddBlog.html"})
  .when("/showBlog", {templateUrl:"c_user/ShowBlog.html"})
    .when("/userHome", {templateUrl : "c_user/UserHome.html"})
});

myApp.run(function($rootScope,$cookieStore){
	
	console.log('Iam in run function');
	console.log($rootScope.currentUser);
	
	if($rootScope,currentUser==undefined)
		{
		console.log($cookieStore.get('user'));
		$rootScope.CurrentUser=$cookieStore.get('user');
		}
});