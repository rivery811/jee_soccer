<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 쿼리 -->
<h2>5번</h2>
<form id = "btn5" action="<%=request.getContextPath()%>/player.do">
	팀아이디<input type="text" name ="teamId" /><br />
	키<input type="text" name ="height" /><br />
	이름<input type="text" name ="playerName" /><br />
	<input type="hidden" name ="action" value="5_find_by_teamid_height_name"/><br />
	<input type="hidden" name ="page" value="5_find_by_teamid_height_name"/><br />
	<input type="submit" value="전송"/>

</form>
    <!-- 결과 -->
포지션은 이고 이름은 입니다.
