<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div>
		<h1 id="title_comm">Grade Management System</h1> 
	</div>
		<div style="text-align: center;width:100px;height: 50px">
			<h4 style="font-size: 20px;color: red;">${message}</h4>
		</div>
	<div id="container" style="margin-top:100px">
		<form id="login_box" name="login_box" > 
			<img src="${img}/java.png" alt="" /><br />
			<span id="login_id">ID</span>
			<input type="text" id="input_id" name="id" value="lee"/> <br />
			<span id="login_pass">PASSWORD</span> 
			<input type="text" id="input_pass" name="pass" value="1"/> <br /><br />
			<input id="loginBtn" type="submit" value="LOGIN"/>
			<input type="hidden" name="action" value="login" />
			<input type="hidden" name="page" value="main" />
			<input id="cancel_btn" type="reset"  value="CANCEL" />
		</form>
		
	</div>
</div>

</body>
</html>
<script>
alert('app.auth.init() 진입');
app.auth.init();
</script>










