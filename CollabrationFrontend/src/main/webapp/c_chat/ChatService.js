/**
 * 
 */
myApp.filter('reverse', function() {
	  return function(items) {
	    return items.slice().reverse();
	  };
	});

myApp.directive('ngFocus', function() {
	  return function(scope, element, attrs) {
	    element.bind('click', function() {
	      $('.' + attrs.ngFocus)[0].focus();
	    });
	  };
	});

myApp.factory('ChatService', function($rootScope,$http) {
		var chatService={}
		chatService.getAllFriends=function(){
			return $http.get('http://localhost:8081/CollaborationMiddleware/showFriendList/'+$rootScope.currentUser.username);
			
		}
		
		var ulist=$http.get("http://localhost");
//		return chatService;
	  alert('app factory')
	    var socket = new SockJS('/CollaborationMiddleware/chatmodule');
	    var stompClient = Stomp.over(socket);
	    stompClient.connect('', '', function(frame) {
	      $rootScope.$broadcast('sockConnected', frame);
	    });

	    return {
	      stompClient: stompClient,
	      users:chatService.getAllFriends()
	    };
	});