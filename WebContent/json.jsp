<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#add").click(function(){
		var userName = $("#userName").attr("value");
		var age =$("#age").attr("value");
		var user = {username:userName,age:age};
		$.ajax({
			url:"/SpringMVC/user/register",
			type:"post",
			data:user,
			success:function(result){
				alert("username--->" + result.username + "age--->" + result.age );
				
			}
		});
	});
});
</script>
</head>
<body>
	<h1>json添加用户</h1>
	姓名：<input type="text" id="userName" name="userName">
	年龄：<input type="text" id="age" name="age">
	<input type="button" id="add" value="添加">
</body>
</html>