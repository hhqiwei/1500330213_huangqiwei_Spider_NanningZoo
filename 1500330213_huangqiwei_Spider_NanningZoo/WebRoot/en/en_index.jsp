<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Nanning Zoo Spider</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
    #main {
      position: absolute;
      width: 400px;
      height: 200px;
      left: 50%;
      top: 50%;
      margin-left: -200px;
      margin-top: -100px;
    }
	</style>
  
	<style type="text/css">
	.language
	{
		color: white;
	}
	</style>
  
  <!-- //for-mobile-apps -->
	<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- font-awesome icons -->
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- //font-awesome icons -->
	<!-- script for close -->
	<script>
		$(document).ready(function(c) {
			$('.alert-close').on('click', function(c) {
				$('.vlcone').fadeOut('slow', function(c) {
					$('.vlcone').remove();
				});
			});
		});
	</script>
	<!-- //script for close -->
  
 
 
	<!-- 弹出提示框的CSS -->
	<link rel="stylesheet" href="css/iziToast.min.css">
  
  </head>
  
  <body>
	<div class="language">
		
		<span>	
		<img src="images/lang_ch.jpg">&nbsp;<a href="index.jsp">简体中文</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<img src="images/lang_en.jpg">&nbsp;<a href="en/en_index.jsp">Englsih</a>
		<br>
		Email：<a href="mailto:1059640638@qq.com">1059640638@qq.com</a>
		</span> 
	
	</div>
  
  <div class="content">
		<h1>Nannning Zoo</h1>
		<div class="main vlcone">
			<div class="alert-close"> </div>
			<h2>Nanning Zoo Spider</h2>
			<h3><a class="trigger-custom2">Click Start Crawl</a></h3>
			<div align="center">
			<button class="btn1"  ><a class="trigger-custom2"><i class="fa fa-play-circle" aria-hidden="true"></i></a></button>
			</div>
			<div class="w3ls-form">
				<form action="en_index.jsp" method="post">
					<input type="email" placeholder="View the comments" name="Subscribe" required="">
					<button class="btn1" onclick="window.location.href = 'en/en_result.jsp'"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
					<input type="email" placeholder="View the information" name="Subscribe" required="">
					<button class="btn1" onclick="window.location.href = 'en/en_result_spider_information.jsp'"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
				</form>
			</div>
			<div class="agileits-info">
				<h5>OR</h5>
				
			</div>
			<div class="share-icons">
				<a class="facebook" href="en/en_attrations.jsp"><i class="fa fa-check-circle-o" aria-hidden="true"></i><span>景点简介</span></a>
				<a class="pinterest" href="en/en_image.jsp"><i class="fa fa-file-image-o" aria-hidden="true"></i><span>图片</span></a>
				<a class="twitter" href="en/en_hospital.jsp"><i class="fa fa-hospital-o" aria-hidden="true"></i><span>附近酒店</span></a>
				<a class="google" href="en/en_food.jsp"><i class="fa fa-coffee" aria-hidden="true"></i><span>美食</span></a>
				<a class="vk" href="en/en_travel.jsp"><i class="fa fa-car" aria-hidden="true"></i><span>交通</span></a>
			</div>
		</div>
		<div class="copyright">
			<p class="footer">&copy; 2017 All Rights Reserved | Design by <a href="http://hhqiwei.biz/">huangqiwei</a></p>
		</div>
	</div>
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    	<script src="js/iziToast.min.js" type="text/javascript"></script>
    	<script src="js/demo.js" type="text/javascript"></script>
  </body>
</html>
