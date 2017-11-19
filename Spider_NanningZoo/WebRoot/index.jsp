<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>南宁动物园网络爬虫</title>
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
  
 
 
 //弹出提示框的CSS
   <link rel="stylesheet" href="css/iziToast.min.css">
  
  </head>
  
  <body>
  
  
  <div class="content">
		<h1>南宁动物园</h1>
		<div class="main vlcone">
			<div class="alert-close"> </div>
			<h2>南宁动物园爬虫</h2>
			<h3><a class="trigger-custom2">点击开始爬取</a></h3>
			<div align="center">
			<button class="btn1"  ><a class="trigger-custom2"><i class="fa fa-play-circle" aria-hidden="true"></i></a></button>
			</div>
			<div class="w3ls-form">
				<form action="index.jsp" method="post">
					<input type="email" placeholder="点击右边的按钮查看评论" name="Subscribe" required="">
					<button class="btn1" onclick="window.location.href = 'result.jsp'"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
				 <input type="email" placeholder="点击右边的按钮查看信息" name="Subscribe" required="">
					<button class="btn1" onclick="window.location.href = 'result_spider_information.jsp'"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
				</form>
			</div>
			<div class="agileits-info">
				<h5>OR</h5>
				
			</div>
			<div class="share-icons">
				<a class="facebook" href="attrations.jsp"><i class="fa fa-check-circle-o" aria-hidden="true"></i><span>景点简介</span></a>
				<a class="pinterest" href="image.jsp"><i class="fa fa-file-image-o" aria-hidden="true"></i><span>图片</span></a>
				<a class="twitter" href="hospital.jsp"><i class="fa fa-hospital-o" aria-hidden="true"></i><span>附近酒店</span></a>
				<a class="google" href="food.jsp"><i class="fa fa-coffee" aria-hidden="true"></i><span>美食</span></a>
				<a class="vk" href="travel.jsp"><i class="fa fa-car" aria-hidden="true"></i><span>交通</span></a>
			</div>
		</div>
		<div class="copyright">
			<p class="footer">&copy; 2017 All Rights Reserved | Design by <a href="http://w3layouts.com/"> 黄启威</a></p>
		</div>
	</div>
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="js/iziToast.min.js" type="text/javascript"></script>
    <script src="js/demo.js" type="text/javascript"></script>
    
  </body>
</html>
