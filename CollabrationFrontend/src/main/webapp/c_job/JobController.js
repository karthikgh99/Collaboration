myApp.controller("jobController",function($scope,$location,$http,$rootScope,$cookieStore)
{
$scope.job={"jobId":"0","designation":"","jobDesc":"","lastDatetoApply":"","CTC":"","jobLocation":"","companyName":"","skill":""};
$scope.jobs;

$scope.publishJob=function(job)
{
	$scope.job=job;
	console.log(job.CTC);
	$http.post("http://localhost:8081/CollaborationMiddleware/addJob",job)
	.then(function(response){
		console.log(response.data)
		alert("Job Added");
});
}
	
	function showJobs()
	{
		$http.get("http://localhost:8081/CollaborationMiddleware/showJobs")
		.then(function(response)
				{
			$scope.jobs=response.data;
			console.log($scope.jobs);
				
	});
}
	$scope.detailJob=function(jobId)
	{
		$rootScope.jobId=jobId;
		location.path("showDetailJob");
	}
	showJobs();
});