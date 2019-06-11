myApp.controller("jobController",function($scope,$location,$http,$rootScope,$cookieStore)
{
$scope.job={"jobId":0,"designation":"","jobDesc":"","lastDatetoApply":"","CTC":0,"jobLocation":""};
$scope.jobs;

$scope.publishJob=function()
{
	console.log($scope.job);
	$http.post("http://localhost:8081/Collaboration/addJob",$scope.job)
	.then(function(response){
		alert("Job Added");
});
}
	
	function showJobs()
	{
		$http.post("http://localhost:8081/CollaborationMiddleware/showJob",$scope.job)
		.then(function(response)
				{
			$scope.jobs=response.data;
			console.log($scope.jobs);
				alert("Job Added")
	});
}
	$scope.detailJob=function(jobId)
	{
		$rootScope.jobId=jobId;
		location.path("showDetailJob");
	}
	showJobs();
});