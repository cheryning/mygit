<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title></title>
</head>
<body>
	<div id="main">
		<h1>登录test</h1>
		<img src="${user.image}">
		<!--  
		<form action="user/file" method="post" enctype="multipart/form-data">
		
			用户名：<input type="text" name="username" id="username"><br>
			密码：<input type="password" name="password" id="pass"><br>
		
			上传头像：<input type="file" name="file">
			<span id = "message"></span></br>
			<input type="submit" value="提交" id="submit">
			</br>
			
		</form>
		-->	
	</div>
	<!--  
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#submit').click(function(){
				var username = $('#username').val();
				var password = $('#pass').val();
				  
					$.ajax({
						url:'/user/show',
						type:'post',
						dataType:'json',
						data:{
							"username":username,
							"password":password
						},
						success:function(data){
							console.log(data);;
							if(data.stu=='error'){
								$("#message").append("<b>用户名或密码错误</b>");
								}
							if(data.stu=='ok'){
								var href = '${pageContext.request.contextPath}/user/test';
								window.top.location.href = href;
							}
						}
			  });	
			})
		})
	</script>
	-->
</body>
</html>
