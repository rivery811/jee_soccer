<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 쿼리 -->
<h2>5번</h2>
<form id = "btn5_form" action="<%=request.getContextPath()%>/player.do">
	팀아이디<input type="text" name ="teamId" /><br />
	키<input type="text" name ="height" /><br />
	이름<input type="text" name ="playerName" /><br />
	<input type="hidden" name ="action" value="search"/><br />
	<input type="hidden" name ="page" value="5_find_by_teamid_height_name"/><br />
	<input type="hidden" name="word" value="find5" />
	<input id="btn5" type="button" value="전송"/>

</form>
<script>
app.init('${ctx}');
</script>

