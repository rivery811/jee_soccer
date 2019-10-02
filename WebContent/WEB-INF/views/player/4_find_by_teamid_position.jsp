<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 4. 결과 -->>
<h3>4번</h3>
<form id="btn4" action="<%=request.getContextPath()%>/player.do">
팀아이디<input type="text" name="teamId" />
포지션<input type="text" name="position" />
<input type="hidden" name="action" value ="4_find_by_teamid_position" />
<input type="hidden" name="page" value = "4_find_by_teamid_position"/>
<input type="submit" value= "전송"/> <br />
</form>
<!-- 4. 결과 -->>
해당 팀의 아이디가 ${players.teamId} 팀의 포지션 ${players.position}일치하는 선수는 홍길동입니다.
