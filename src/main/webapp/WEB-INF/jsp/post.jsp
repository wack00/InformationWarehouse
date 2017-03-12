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

<title>Post</title>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>


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
.inner1 {
	color: #080808;
/* 	border: 1px solid; */
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: red; */
	margin-left: 20px !important;
}

.inner2 {
/* 	border: 1px solid; */
	color: #080808;
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: green; */
	margin-left: 40px !important;
}

.inner3 {
/* 	border: 1px solid; */
	color: #080808;
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: yellow; */
	margin-left: 60px !important;
}

.inner4 {
/* 	border: 1px solid; */
	color: #080808;
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: green; */
	margin-left: 80px !important;
}

.inner5 {
/* 	border: 1px solid; */
	color: #080808;
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: green; */
	margin-left: 90px !important;
}

.inner0 {
	color: #080808;
	/* background-color: black; */
	font-family: segoeuil;
	font-size: 24px;
	/* 	color: green; */
	padding-left: 10px !important;
}
.commentBox{
display: none;
}
.reportBox{
display: none;
}
</style>

<script type='text/javascript'>	 
$(document).ready(function(){

	   $(".close_login").hide();
	   $(".close_report").hide();
// 	   $(".show_login").click(function(){
// 	    showpopup();
// 	   });
// 	   $(".close_login").click(function(){
// 	    hidepopup();
// 	   });

	});
function showpopup(id)
{
	//alert(id);
   $("#loginform"+id).fadeIn();
   $("#loginform").css({"visibility":"visible","display":"block"});
   $("#show_login"+id).hide();
   $("#close_login"+id).show();
}

function hidepopup(id)
{
   $("#loginform"+id).fadeOut();
   $("#loginform").css({"visibility":"hidden","display":"none"});
   $("#show_login"+id).show();
   $("#close_login"+id).hide();
   
}
function showreport(id)
{
	//alert(id);
   $("#reportform"+id).fadeIn();
   $("#reportform").css({"visibility":"visible","display":"block"});
   $("#show_report"+id).hide();
   $("#close_report"+id).show();
}

function hidereport(id)
{
   $("#reportform"+id).fadeOut();
   $("#reportform").css({"visibility":"hidden","display":"none"});
   $("#show_report"+id).show();
   $("#close_report"+id).hide();
   
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

                    $(".disapprove"+id).addClass("active");
                     $(".disapprove"+id).text(msg+ " Disapprove");
                   }
     })}};
}	

function approveComment(id)
{

	if(!$(".disapproveComment"+id).hasClass("active")){
	if($(".approveComment"+id).hasClass("active")){
		$(".approveComment"+id).removeClass("active");
		 $.ajax({
	          type: "GET",
	          url: "http://localhost:8080/InformationWarehouse/commentCountApproveDown/" + id,
	          data: "id=" + id + "&name=" ,
	          success: function(msg){

	                     $(".approveComment"+id).text(msg+ " Approve");
	                   }
	     })
	}
	else{
	//alert(id);
     $.ajax({
          type: "GET",
          url: "http://localhost:8080/InformationWarehouse/commentCountApproveUp/" + id,
          data: "id=" + id + "&name=" ,
          success: function(msg){

                    $(".approveComment"+id).addClass("active");
                     $(".approveComment"+id).text(msg+ " Approve");
                   }
     })}};
}	

function disapproveComment( id )
{

	if(!$(".approveComment"+id).hasClass("active")){
	if($(".disapproveComent"+id).hasClass("active")){
		$(".disapproveComment"+id).removeClass("active");
		 $.ajax({
	          type: "GET",
	          url: "http://localhost:8080/InformationWarehouse/commentCountDisapproveDown/" + id,
	          data: "id=" + id + "&name=" ,
	          success: function(msg){

	                     $(".disapproveComment"+id).text(msg+ " Disapprove");
	                   }
	     })
	}
	else{
    $.ajax({
          type: "GET",
          url: "http://localhost:8080/InformationWarehouse/commentCountDisapproveUp/" + id,
          data: "id=" + id + "&name=" ,
          success: function(msg){
                    // alert( "Data Saved: " + msg );
                    $(".disapproveComment"+id).addClass("active");
                     $(".disapproveComment"+id).text(msg+ " Disapprove");
                   }
     })}};
}	



</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<body>

	<!-- cel blog -->

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
					<li><a href="${rootLink }/pag/1">Best</a></li>
					<li><a href="${rootLink }/sort/popular/1">Popular</a></li>
					<li><a href="${rootLink }/sort/newest/1">Newest</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li ><a href="${rootLink}/login/form">Login</a></li>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		 <div class="row">&nbsp;</div>
		<!-- /.container -->
	</nav>
	<!-- Page Content -->
	<div class="container" style="    margin-top: 35px;">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">


				<!-- 					<div style="border: 1px solid;"> -->
										<div style="background-color:#E7E7E7; border-radius:4px; padding:5px;margin-bottom:15px">
							<!-- First Blog Post -->
							<div class="row">
							<div class="col-md-6">
									<h5 >
										<a href="${rootLink}/userDetails/${post.getPostId()}">#${post.getPostId()}
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

<div class='btn btn-default show_login' id='show_login${post.getComments().get(0).getCommentId() }' 
					OnClick='showpopup(${post.getComments().get(0).getCommentId()});'><span class='glyphicon glyphicon-chevron-down'></span></div>
					<div class='btn btn-default close_login' id='close_login${post.getComments().get(0).getCommentId() }' 
					OnClick='hidepopup(${post.getComments().get(0).getCommentId()});'><span class='glyphicon glyphicon-chevron-up'></span></div>
					<div class="commentBox" id="loginform${post.getComments().get(0).getCommentId()}">
					   <form role="form" method="POST" action="http://localhost:8080/InformationWarehouse/addComment">
					      <div class="col-lg-6"></div>
					      <div class="form-group">
					         <h4 style="padding-top: 10px; font-weight: bold;  font-family: segoeuil; font-size: 24px;">Name</h4>
					         <div class="input-group">		<textarea type="text" rows="1" class="form-control" id="InputDescription" name="authorName" placeholder="Enter description       " required=""> </textarea>		<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>	</div>
					      </div>
					      <input type="hidden" value="${post.getPostId() }" name="postId"> <input type="hidden" value="${post.getComments().get(0).getCommentId()}" name="parentComment"> 
					      <div class="form-group">
					         <h4 style="padding-top: 10px; font-weight: bold;  font-family: segoeuil; font-size: 24px;">Enter Description</h4>
					         <div class="input-group">		<textarea type="text" rows="2" class="form-control" id="InputDescription" name="descr" placeholder="Enter description       " required=""> </textarea>		<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>	</div>
					      </div>
					      <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right"> <br>
					   </form>
					</div>

							
						</div>
						</div>
				
				
				<div class="panel panel-default">
					<div class="panel-heading">Comment pannel</div>


					<%!
	void preOrder(Comment root, int level, JspWriter out,int postId,Comment rootComment) throws IOException {

		if (root == null)
			return;

		String s = "";
		for (int j = 0; j <= level; j++) {
			s += "-";
		}
		if(! root.isState()){
			return;
		}
		
		if(root.getCommentId()!=rootComment.getCommentId()){
	
			out.print("<div class='inner" + level + "'>");
			out.print("<h4 style='font-style: italic;'>");
			out.print(root.getAuthorName());
			out.print("</h4>");
			out.print("<h6 >");
			out.print("<span class='glyphicon glyphicon-time'></span> Posted ");
			out.print(root.returnDate());
			out.print(" ago");
			out.print("</h6>");
			//out.print("<hr>");
	
			out.print("<p>");
			out.print(root.getText());
			out.print("</p>");
			out.print("<div class='btn btn-default approveComment"+root.getCommentId()+"' onclick='approveComment("+ root.getCommentId()+"); ' >"
					+ root.getCountApprove()
					+ " Approve </div>");
			out.print("<div class='btn btn-default disapproveComment"+root.getCommentId()+"' onclick='disapproveComment("+ root.getCommentId()+"); ' >"
					+ root.getCountDisapprove()
					+ " Disapprove </div>");
			//out.print("<a class='btn btn-danger' href='#'> Reply <span class='glyphicon glyphicon-chevron-down'></span></a>");
			out.print("<div class='btn btn-default show_login' id='show_login"+root.getCommentId()+"' OnClick='showpopup("+root.getCommentId()+");'>reply <span class='glyphicon glyphicon-chevron-down'></span> </div>");
			out.print("<div class='btn btn-default close_login' id='close_login"+root.getCommentId()+"' OnClick='hidepopup("+root.getCommentId()+");'>reply <span class='glyphicon glyphicon-chevron-up'></span></div>");
			out.print("<div class='btn btn-default show_report' id='show_report"+root.getCommentId()+"' OnClick='showreport("+root.getCommentId()+");'>report <span class='glyphicon glyphicon-chevron-down'></span> </div>");
			out.print("<div class='btn btn-default close_report' id='close_report"+root.getCommentId()+"' OnClick='hidereport("+root.getCommentId()+");'>report<span class='glyphicon glyphicon-chevron-up'></span></div>");
			//comment box for commenting 
			out.print("<div class='commentBox' id='loginform"+root.getCommentId()+"'>");
			out.print("<form role='form' method='POST' action='http://localhost:8080/InformationWarehouse/addComment'>");
			out.print("<div class='col-lg-6'></div>");
			out.print("<div class='form-group'>");
			out.print("	<h4 style='padding-top: 10px; font-weight: bold;  font-family: segoeuil; font-size: 24px;'>Name</h4>");
			out.print("	<div class='input-group'>");
			out.print("		<textarea type='text' rows='1' class='form-control'");
			out.print("			id='InputDescription' name='authorName'");
			out.print("			placeholder='Enter description       ' required> </textarea>");
			out.print("		<span class='input-group-addon'><span");
			out.print("			class='glyphicon glyphicon-asterisk'></span></span>");
			out.print("	</div>");
			out.print("</div>");
			out.print("<input type='hidden' value='"+postId+"' name='postId' /> ");
			out.print("<input type='hidden' value='"+root.getCommentId()+"' name='parentComment' /> ");
			out.print("<div class='form-group'>");
			out.print("	<label for='InputEmail'>Enter description</label>");
			out.print("	<div class='input-group'>");
			out.print("		<textarea type='text' rows='2' class='form-control'");
			out.print("			id='InputDescription' name='descr'");
			out.print("			placeholder='Enter description       ' required> </textarea>");
			out.print("		<span class='input-group-addon'><span");
			out.print("			class='glyphicon glyphicon-asterisk'></span></span>");
			out.print("	</div>");
			out.print("</div>");
			out.print("<input type='submit' name='submit' id='submit' value='Submit'");
			out.print("	class='btn btn-info pull-right'> <br>");
			out.print("</form>");
			out.print("</div>");
			//report box
			out.print("<div class='reportBox' id='reportform"+root.getCommentId()+"'>");
			out.print("<form role='form' method='POST' action='http://localhost:8080/InformationWarehouse/reportComment'>");
			out.print("<div class='col-lg-6'></div>");
			out.print("<div class='form-group'>");
			out.print("	<label for='InputEmail'>Why are you reporting this comment</label>");
			out.print("	<div class='input-group'>");
			out.print("		<textarea type='text' rows='3' class='form-control'");
			out.print("			id='InputDescription' name='description'");
			out.print("			placeholder='Enter description       ' required> </textarea>");
			out.print("		<span class='input-group-addon'><span");
			out.print("			class='glyphicon glyphicon-asterisk'></span></span>");
			out.print("	</div>");
			out.print("</div>");
			//out.print("<input type='hidden' value='"+postId+"' name='postId' /> ");
			out.print("<input type='hidden' value='"+root.getCommentId()+"' name='commentId' /> ");

			// 			out.print("<div class='form-group'>");
// 			out.print("	<label for='InputEmail'>Enter description</label>");
// 			out.print("	<div class='input-group'>");
// 			out.print("		<textarea type='text' rows='2' class='form-control'");
// 			out.print("			id='InputDescription' name='descr'");
// 			out.print("			placeholder='Enter description       ' required> </textarea>");
// 			out.print("		<span class='input-group-addon'><span");
// 			out.print("			class='glyphicon glyphicon-asterisk'></span></span>");
// 			out.print("	</div>");
// 			out.print("</div>");

			out.print("<input type='submit' name='submit' id='submit' value='Submit'");
			out.print("	class='btn btn-info pull-right'> <br>");
			out.print("</form>");
			out.print("</div>");
			out.print("<hr>");
	
			out.print("</div>");
		}
		//System.out.println(s + root.getId());

		if (root.getComments() == null)
			return;

		//for(int j = 0;j<root.)
		
		List<Comment> localCom = root.getComments();
		level = level + 1;
		for (int i = 0; i < root.getComments().size(); i++) {

			preOrder(root.getComments().get(i), level, out,postId,rootComment);
			// preOrder(root.rightNode());
		}

	}%>

					<%
						Post p = (Post) request.getAttribute("post");
						//out.print(p.getId());
						int postId = p.getPostId();
						List<Comment> com = (List<Comment>) request
								.getAttribute("comments");
						Comment cc = com.get(0);
							if (com == null) {
								out.print("No comments yet. Be the first one to comment!");
							}
							if (com.size() == 0) {
								out.print("No comments yet. Be the first one to comment!");
							} else {
								//if(cc.getComments() != null && cc.getComments().size() != 0){
									//Comment c1 = cc.getComments().get(0);
									Comment c1 = cc;
									preOrder(c1, 0, out,postId,c1);
								//}
								//else{
							//		out.print("no coments");
								//}
								
							}
						
					%>

				</div>





			</div>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4">

				

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
	




	<!-- <!-- new showing comments with div tags -->




	<!-- jQuery -->
	<script src="${rootLink}/resources/bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${rootLink}/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>