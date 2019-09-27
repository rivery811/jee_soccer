<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>축구협회 관리 시스템</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${js}/app.js"></script>
	
</head>
<body>
<img src="${img}/soccer-ball.jpg" alt="" style="width :350px ; height : 250px"/>
<div id = "wrapper" style="width:100%; height:100%">
	<form id="login_form">
		<table border = "1" style="width:350px; height:200px; margin:300px auto">
			<tr>
				<td style="width : 300px">
					아이디<input type="text" name="playerId" />

				</td>
				<td rowspan="2">
					<input type="hidden" name = "action" value ="login"/>
					<input type="hidden" name = "page" value ="home"/>
					<input type="submit" value = "로그인" style="width:100%;height:100%" />
				</td>
			</tr>
			<tr>
				<td>
					비밀번호<input type="text" name = "solar"/>
				</td>		
			</tr>
	
		</table>
	
	</form>
	
	<h3 style="width:300px; margin:0 auto"><a id="a_join" href="#">회원가입</a></h3>
</div>
<script>
app.init('${ctx}');
</script>	
</body>
</html>