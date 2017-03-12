<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<%@page import="com.vacko.springapp.web.controllers.UserController"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Post Pannel</title>

<!-- Bootstrap Core CSS -->
<link href="${rootLink}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
	
<!-- Custom CSS -->
<link href="${rootLink}/resources/css/sb-admin.css" rel="stylesheet">

<!--     Morris Charts CSS -->
<!--     <link href="css/plugins/morris.css" rel="stylesheet"> -->

<!--     Custom Fonts -->
<!--     <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<script type='text/javascript'>	

function acceptPost(id)
{
	
//	alert(id);

	 $.ajax({
         type: "GET",
         url: "http://localhost:8080/InformationWarehouse/acceptPost/" + id,
         data: "id=" + id + "&name=" ,
         success: function(msg){
                //  alert(msg);
                  $("#tableRow"+id).fadeOut();
                  }
    });
}	

function denyPost(id)
{
	//alert(id);

	$.ajax({
        type: "GET",
        url: "http://localhost:8080/InformationWarehouse/denyPost/" + id,
        data: "id=" + id + "&name=" ,
        success: function(msg){
                // alert(msg);
                 $("#tableRow"+id).fadeOut();
                 }
   });
}	
</script>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Admin Dashboard</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">

				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> <%=UserController.getCurrentUser().getName() %> <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						
						<li><a href="${rootLink}/logout"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="${rootLink}/adminPannel""><i
							class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>
					<li class="active"><a href="${rootLink}/postPannel""><i
							class="fa fa-fw fa-bar-chart-o"></i> Posts Waiting Approval</a></li>
					<li><a  href="${rootLink}/commentPannel"><i class="fa fa-fw fa-table"></i>
							Comments Waiting Approval</a></li>
					<li><a href="${rootLink}/reportPannel"><i class="fa fa-fw fa-edit"></i>
							Reported Comments</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Post Pannel<small>   Statistics Overview</small>
						</h1>
						
					</div>
				</div>
				<!-- /.row -->

				


				<!-- /.row -->

				<div class="row">


					<div class="col-lg-8">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-money fa-fw"></i> Post list
								</h3>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-bordered table-hover table-striped">
										<thead>
											<tr>
												<th>Post id #</th>
												<th>Post Date</th>
												<th>Description</th>
												<th>Approve</th>
												<th>Disapprove</th>									
												<th>&nbsp;</th>
												<th>&nbsp;</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="post" items="${posts}">
												<tr id="tableRow${post.getPostId() }">
													<td>${post.getPostId()}</td>
													<td>${post.getDateCreated()}</td>
													<td>${post.getDescription()}</td>
													<td>${post.getCountApprove()}</td>
													<td>${post.getCountDisapprove()}</td>
													<th><div  class="btn btn-primary" data-toggle="modal" data-target="#myModal${post.getPostId() }">Approve</div></th>
													<th><div  class="btn btn-danger" data-toggle="modal" data-target="#myModalDeny${post.getPostId() }">Deny</div></th>
													                 

													<!-- Modal -->
													<div class="modal fade" id="myModal${post.getPostId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
													  <div class="modal-dialog" role="document">
													    <div class="modal-content">
													      <div class="modal-header">
													        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
													        <h4 class="modal-title" id="myModalLabel">Approve post ${post.getPostId() }</h4>
													      </div>
													      <div class="modal-body">
													        Really Approve Post
													      </div>
													      <div class="modal-footer">
													        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
<!-- 													        <a href="#" class="btn btn-danger ">Reject</a> -->
													        <div onclick = "acceptPost(${post.getPostId()})" class="btn btn-primary " data-dismiss="modal">Approve</div>
<%-- 													      <a href="http://localhost:8080/InformationWarehouse/acceptPost/${post.getPostId() }"  class="btn btn-primary ">Approve</a> --%>
													      </div>
													    </div>
													  </div>
													</div>
													<!-- Modal  2 Deny-->
													<div class="modal fade" id="myModalDeny${post.getPostId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
													  <div class="modal-dialog" role="document">
													    <div class="modal-content">
													      <div class="modal-header">
													        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
													        <h4 class="modal-title" id="myModalLabel">Deny post ${post.getPostId() }</h4>
													      </div>
													      <div class="modal-body">
													        Really Deny Post
													      </div>
													      <div class="modal-footer">
													        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
<!-- 													        <a href="#" class="btn btn-danger ">Reject</a> -->
													        <div onclick = "denyPost(${post.getPostId()})" class="btn btn-danger " data-dismiss="modal">Deny</div>
<%-- 													      <a href="http://localhost:8080/InformationWarehouse/acceptPost/${post.getPostId() }"  class="btn btn-primary ">Approve</a> --%>
													      </div>
													    </div>
													  </div>
													</div>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
				                <!-- /.row -->
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                 <!-- /.row -->
                <div class="row">&nbsp;</div>
                 <!-- /.row -->
                <div class="row">&nbsp;</div>
                 <!-- /.row -->
                <div class="row">&nbsp;</div>
                 <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>
                <!-- /.row -->
                <div class="row">&nbsp;</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${rootLink}/resources/bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${rootLink}/resources/bootstrap/js/bootstrap.min.js"></script>

	<!--     Morris Charts JavaScript -->
	<!--     <script src="js/plugins/morris/raphael.min.js"></script> -->
	<!--     <script src="js/plugins/morris/morris.min.js"></script> -->
	<!--     <script src="js/plugins/morris/morris-data.js"></script> -->

</body>

</html>
