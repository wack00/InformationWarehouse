<!DOCTYPE html>
<%@page import="java.io.IOException"%>
<%@page import="com.vacko.springapp.web.controllers.UserController"%>
<%@include file="taglib.jsp"%>
<%@page import="com.vacko.springapp.entities.Comment"%>
<%@page import="com.vacko.springapp.entities.Post"%>
<%@page import="java.util.*;"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Joke,Idea, Funny story</title>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="${rootLink}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${rootLink}/resources/bootstrap/css/blog-home.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<style>
.blue {
	color: black; //
	background-color: red;
}

#loginform {
	width: 500px;
	height: 330px;
	margin-top: 100px;
	background-color: #585858;
	border-radius: 3px;
	box-shadow: 0px 0px 10px 0px #424242;
	padding: 10px;
	box-sizing: border-box;
	font-family: helvetica;
	visibility: hidden;
	display: none;
}

#loginform1 {
	display: none;
}

#loginform #close_login {
	position: absolute;
	top: 140px;
	left: 735px;
	width: 15px;
	height: 15px;
}

#loginform p {
	margin-top: 40px;
	font-size: 22px;
	color: #E6E6E6;
}

#loginform #login {
	width: 250px;
	height: 40px;
	border: 2px solid silver;
	border-radius: 3px;
	padding: 5px;
}

#loginform #password {
	margin-top: 5px;
	width: 250px;
	height: 40px;
	border: 2px solid silver;
	border-radius: 3px;
	padding: 5px;
}

#loginform #dologin {
	margin-left: -5px;
	margin-top: 10px;
	width: 250px;
	height: 40px;
	border: none;
	border-radius: 3px;
	color: #E6E6E6;
	background-color: grey;
	font-size: 20px;
}
</style>

<body>

	<script type='text/javascript'>	
$(document).ready(function(){

	   $("#close_login").hide();
	   $("#show_login").click(function(){
	    showpopup();
	   });
	   $("#close_login").click(function(){
	    hidepopup();
	   });

	});
function showpopup()
{
   $("#loginform1").fadeIn();
   $("#loginform").css({"visibility":"visible","display":"block"});
   $("#show_login").hide();
   $("#close_login").show();
}

function hidepopup()
{
   $("#loginform1").fadeOut();
   $("#loginform").css({"visibility":"hidden","display":"none"});
   $("#show_login").show();
   $("#close_login").hide();
   
}


function approvePost(id)
{
	
	if(!$(".disapprove"+id).hasClass("active")){
	if($(".approve"+id).hasClass("active")){
		$(".approve"+id).removeClass("active");
		 $.ajax({
	          type: "GET",
	          url: "http://localhost:8080/InformationWarehouse/countApproveDown/" + id,
	          data: "id=" + id + "&name=" ,
	          success: function(msg){
	                    // alert( "Data Saved: " + msg );
	                  //  $(".disapprove"+id).addClass("active");
	                     $(".approve"+id).text(msg+ " Approve");
	                   }
	     })
	}
	else{
	//alert(id);
     $.ajax({
          type: "GET",
          url: "http://localhost:8080/InformationWarehouse/countApproveUp/" + id,
          data: "id=" + id + "&name=" ,
          success: function(msg){
                    // alert( "Data Saved: " + msg );
                    //$("#approve"+id).text("a");
                    $(".approve"+id).addClass("active");
                     $(".approve"+id).text(msg+ " Approve");
                   }
     })}};
}	

function disapprovePost( id )
{
	//alert(id);
	if(!$(".approve"+id).hasClass("active")){
	if($(".disapprove"+id).hasClass("active")){
		$(".disapprove"+id).removeClass("active");
		 $.ajax({
	          type: "GET",
	          url: "http://localhost:8080/InformationWarehouse/countDisapproveDown/" + id,
	          data: "id=" + id + "&name=" ,
	          success: function(msg){
	                    // alert( "Data Saved: " + msg );
	                  //  $("#disapprove"+id).addClass("active");
	                     $(".disapprove"+id).text(msg+ " Disapprove");
	                   }
	     })
	}
	else{
    $.ajax({
          type: "GET",
          url: "http://localhost:8080/InformationWarehouse/countDisapproveUp/" + id,
          data: "id=" + id + "&name=" ,
          success: function(msg){
                    // alert( "Data Saved: " + msg );
                    $(".disapprove"+id).addClass("active");
                     $(".disapprove"+id).text(msg+ " Disapprove");
                   }
     })}};
}	
</script>


	<!-- cel blog -->

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- /.row -->
                <div class="row">&nbsp;</div>
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
<!-- 				<a class="navbar-brand" href="#">Start Bootstrap</a> -->
					<a  href="#"><img src="${rootLink}/resources/logo/logo.png" style="height:50px"></img></a>
					
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${rootLink}/pag/1" class="active">Best</a></li>
					<li><a href="${rootLink}/sort/popular/1">Popular</a></li>
					<li><a href="${rootLink}/sort/newest/1">Newest</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li ><a href="${rootLink}/login/form">Login</a></li>
					
				</ul>

			</div>

			<!-- /.navbar-collapse -->
		</div>
		<!-- /.row -->
                <div class="row">&nbsp;</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container" style="    margin-top: 35px;">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

<!-- 				<li> -->
					
					<c:forEach var="post" items="${posts}">
						<!-- 					<div style="border: 1px solid;"> -->
						<div style="background-color:#E7E7E7; border-radius:4px; padding:5px;margin-bottom:15px">
							<!-- First Blog Post -->
							<div class="row">
							<div class="col-md-6">
									<h5 >
										<a href="${rootLink}/post/${post.getPostId()}">#${post.getPostId()}
										</a>
										
									</h5>
								</div>
								<div class="col-md-6">
									<h5 class="pull-right">
									${post.returnDate()}
									</h5>
								</div>
							</div>

						
						<div style="margin-top:-50px;">
							<p
								style="color: #080808;
	/* background-color: black; */ font-family: segoeuil; font-size: 24px;">
								${post.getDescription() }
							</p>
						</div>

						<div style="    padding-bottom: 5px;">
							<div class="btn btn-default approve${post.getPostId() }"
								OnClick="approvePost(${post.getPostId()});">
								${post.getCountApprove() } Approve 
							</div>
							<div
								class="btn btn-default
								disapprove${post.getPostId() }"
								OnClick="disapprovePost(${post.getPostId()});">${post.getCountDisapprove() }
								Disapprove
							</div>

							<a class="btn btn-default" href="${rootLink}/post/${post.getPostId()}">${post.getComments().size()-1 }
								<span class="glyphicon glyphicon-comment"></span>
							</a>
						</div>
						</div>
					</c:forEach>


					<nav>
						<ul class="pagination">
							<li>
							<a href="${rootLink}/${currentPageTag}/1" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
							</a>
							</li>


							<%
							int currentPage = (Integer) request.getAttribute("currentPage");
							int size = (Integer) request.getAttribute("size");
							String currentPageTag = (String) request.getAttribute("currentPageTag");
							String rootLink = (String) pageContext.getAttribute("rootLink");
							
							
							
							if(currentPage - 1 <= 0){															
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+currentPage+"'>" +currentPage + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(currentPage+1)+"'>" +(currentPage+1) + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(currentPage+2)+"'>" +(currentPage+2) + "</a></li>");								
							}else if(currentPage - 1 >= 1 && currentPage != size){
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(currentPage-1)+"'>" +(currentPage-1) + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(currentPage)+"'>" +(currentPage) + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(currentPage+1)+"'>" +(currentPage+1) + "</a></li>");			
							}else if(currentPage == size){				
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(size-2)+"'>" +(size-2) + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(size-1)+"'>" +(size-1) + "</a></li>");
								out.print("<li><a href='"+rootLink+"/"+currentPageTag+"/"+(size)+"'>" +(size) + "</a></li>");
								
								
							}
							
							
							 %>


							<li><a href="${rootLink}/${currentPageTag}/${size}" aria-label="Next">
									<span aria-hidden="t+rue">&raquo;</span>

							</a></li>
						</ul>
					</nav>
			</div>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Side Widget Well -->
				<div class="well">
					<div class="btn btn-default" id="show_login" OnClick="">Add</div>
					<div class="btn btn-default" id="close_login" OnClick="">Close</div>

					<div id="loginform1">
						<form role="form" method="POST"
							action="http://localhost:8080/InformationWarehouse/addPost">
							<div class="col-lg-6"></div>
							<div class="form-group">
								<label for="InputEmail">Post some idea,joke,funny story..</label>
								<input type="hidden" value="${returnTag} " name="returnTag">
								<div class="input-group">
									<textarea type="text" rows="1" class="form-control"
										name="descr"
										placeholder="Post some idea,joke,funny story.." > </textarea>
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<input type="submit" name="submit" id="submit" value="Submit"
								class="btn btn-info pull-right"> <br>
						</form>


					</div>

				</div>




				<!-- Blog Categories Well -->
				<div class="well">
					<h4>Random Post</h4>
						<div style=" border-radius:4px; padding:5px;margin-bottom:15px">
							<!-- First Blog Post -->
							<div class="row">
							<div class="col-md-6">
									<h5 >
										<a href="${rootLink}/post/${randomPost.getPostId()}">#${randomPost.getPostId()}
										</a>
										
									</h5>
								</div>
								<div class="col-md-6">
									<h5 class="pull-right">
									${randomPost.returnDate()}
									</h5>
								</div>
							</div>

						
						<div style="margin-top:-50px;">
							<p
								style="color: #080808;
	/* background-color: black; */ font-family: segoeuil; font-size: 24px;">
								${randomPost.getDescription() }
							</p>
						</div>

						<div style="    padding-bottom: 5px;">
							<div class="btn btn-default approve${randomPost.getPostId() }"
								OnClick="approvePost(${randomPost.getPostId()});">
								${randomPost.getCountApprove() } Approve 
							</div>
							<div
								class="btn btn-default
								disapprove${randomPost.getPostId() }"
								OnClick="disapprovePost(${randomPost.getPostId()});">${randomPost.getCountDisapprove() }
								Disapprove
							</div>

							<a class="btn btn-default" href="${rootLink}/post/${randomPost.getPostId()}">${randomPost.getComments().size()-1 }
								<span class="glyphicon glyphicon-comment"></span>
							</a>
						</div>
					</div>
					<!-- /.row -->
				</div>



			</div>

		</div>
		<!-- /.row -->


		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->






	

	<!-- jQuery -->
	<script src="${rootLink}/resources/bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${rootLink}/resources/bootstrap/js/bootstrap.min.js"></script>


	<!-- cel blog -->
	<!-- novo -->
	<!-- 	<div ng-app="myApp" ng-controller="customersCtrl"> -->

	<!-- 		<div class="panel panel-default"> -->
	<!-- 			<div class="panel-heading">Panel heading</div> -->

	<!-- 			<table class="table"> -->


	<!-- 				TODO: print the node here -->



	<!-- 				<thead> -->
	<!-- 					<tr> -->
	<!-- 						<th>Post id</th> -->
	<!-- 						<th>Description</th> -->
	<!-- 						<th>Date created</th> -->
	<!-- 						<th>Approve</th> -->
	<!-- 						<th>Disapprove</th> -->
	<!-- 						<th>State</th> -->
	<!-- 					</tr> -->
	<!-- 				</thead> -->
	<%-- 				<c:forEach var="post" items="${posts}"> --%>
	<!-- 					<thead> -->
	<!-- 						<tr> -->
	<%-- 							<th>${post.getId() }</th> --%>
	<%-- 							<th>${post.getDescription() }</th> --%>
	<%-- 							<th>${post.getDateCreated() }</th> --%>
	<%-- 							<th>${post.getCountApprove() }</th> --%>
	<%-- 							<th>${post.getCountDisapprove() }</th> --%>
	<%-- 							<th>${post.isState() }</th> --%>
	<!-- 						</tr> -->
	<!-- 					</thead> -->
	<%-- 				</c:forEach> --%>
	<!-- 			</table> -->

	<!-- 		</div> -->
	<!-- 	</div> -->

	<!-- paggination that prints all pages -->
	<!-- 	<nav> -->
	<!-- 		<ul class="pagination"> -->
	<!-- 			<li><a href="#" aria-label="Previous"> <span -->
	<!-- 					aria-hidden="true">&laquo;</span> -->
	<!-- 			</a></li> -->

	<%-- 				<c:forEach var="i" begin="1" end="${size}"> --%>


	<%-- 					<li><a href="${rootLink}/pag/${i}"><c:out value="${i}" /></a></li> --%>

	<%-- 				</c:forEach> --%>

	<!-- 			<li><a href="" aria-label="Next"> <span aria-hidden="t+rue">&raquo;</span> -->

	<!-- 			</a></li> -->
	<!-- 		</ul> -->
	<!-- 	</nav> -->

	<!-- paggination that prints first last active  next and last -->


</body>
</html>