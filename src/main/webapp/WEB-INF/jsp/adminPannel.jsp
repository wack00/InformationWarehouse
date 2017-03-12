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

    <title>Admin</title>

<!-- Bootstrap Core CSS -->
<link href="${rootLink}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

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

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Admin Dashboard</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>  <%=UserController.getCurrentUser().getName() %> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${rootLink}/logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="${rootLink}/adminPannel"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="${rootLink}/postPannel "><i class="fa fa-fw fa-bar-chart-o"></i> Posts Waiting Approval</a>
                    </li>
                    <li>
                        <a  href="${rootLink}/commentPannel"><i class="fa fa-fw fa-table"></i> Comments Waiting Approval</a>
                    </li>
                    <li>
                        <a href="${rootLink}/reportPannel"><i class="fa fa-fw fa-edit"></i> Reported Comments</a>
                    </li>

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
                            Admin Dashboard <h2>Welcome <%=UserController.getCurrentUser().getName() %> </h2> <small>Statistics Overview</small>
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->

                
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${numberPosts}</div>
                                        <div>New Posts!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${rootLink}/postPannel">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${numberComments }</div>
                                        <div>New Comments!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${rootLink}/commentPannel">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${numberReports }</div>
                                        <div>New Reports!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="${rootLink}/reportPannel">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            
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
