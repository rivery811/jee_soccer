<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="../common/head.jsp"/>

<div></div>	
<div id = "title_join"><h1>회원가입화면</h1></div>	
<div></div>	
<div></div>	
	<div>
	<form id="join">
		<div id = "join_tab">
			
				<div>playerId<input class="join_input" type="text" name="playerId" /></div>
				<div>playerName<input class="join_input" type="text" name="playerName" /></div>
				<div>teamId<input class="join_input" type="text" name="teamId" /></div>
				<div>ePlayerName<input class="join_input"  type="text" name="ePlayerName" /></div>
				<div>nickName<input class="join_input" type="text" name="nickName" /></div>
				<div>joinYYYY<input class="join_input"  type="text" name="joinYYYY" /></div>
				<div>backNo<input class="join_input"  type="text" name="backNo" /></div>
				<div>nation<input class="join_input"  type="text" name="nation" /></div>
				<div>birthDate<input class="join_input"  type="text" name="birthDate" /></div>
				<div>solar<input class="join_input"  type="text" name="solar" /></div>
				<div>height<input class="join_input"  type="text" name="height" /></div>
				<div>weight<input class="join_input"  type="text" name="weight" /></div>	
				<div><h3><a class="back" href="#">뒤로가기</a></h3></div>
				<div><input class="back" type="submit" value = "회원가입" /></div>		
		
		</div>	
	</form>
	</div>	
<div></div>	
<div></div>										

<jsp:include page = "../common/foot.jsp"/>
<script>
app.init('${ctx}');
</script>
