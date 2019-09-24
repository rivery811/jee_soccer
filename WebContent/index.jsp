<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<h2><a id = "btn2" href="#">2.포지션찾기</a></h2>
<form id="btn4" action="<%=request.getContextPath()%>/player.do">
팀아이디<input type="text" name="teamId" />
포지션<input type="text" name="position" />
<input type="hidden" name="action" value ="4_find_by_teamid_position" />
<input type="hidden" name="page" value = "4_find_by_teamid_position"/>
<input type="submit" value= "전송"/> <br />
</form>
<h2>5번</h2>
<form id = "btn5" action="<%=request.getContextPath()%>/player.do">
	팀아이디<input type="text" name ="teamId" /><br />
	키<input type="text" name ="height" /><br />
	이름<input type="text" name ="playerName" /><br />
	<input type="hidden" name ="action" value="5_find_by_teamid_height_name"/><br />
	<input type="hidden" name ="page" value="5_find_by_teamid_height_name"/><br />
	<input type="submit" value="전송"/>

</form>

	
	
<script>
$('#btn2').click(function() {
	alert('클릭');
	location.assign('<%=request.getContextPath()%>/player.do?action=move&page=2_positions');
});
$('#btn4').submit(function() {
	alert('찾기');
});
$('#btn5').submit(function () {
	alert('찾기5');
});
</script>
</body>
</html>