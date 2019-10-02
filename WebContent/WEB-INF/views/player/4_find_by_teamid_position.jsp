<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 4. 결과 -->>
<h3>4번</h3>
<form id="btn4_form">
팀아이디<input type="text" name="teamId" />
포지션<input type="text" name="position" />
<input type="hidden" name="action" value ="search" />
<input type="hidden" name="page" value = "4_find_by_teamid_position"/>
<input type="hidden" name="word" value = "find4" />
<input id="btn4" type="button" value= "전송"/> <br />
</form>
<script>
app.init('${ctx}');
</script>
