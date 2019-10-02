<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div></div>	
<div id = "title_join"><h1>회원가입화면</h1></div>	
<div></div>	
<div></div>	
	<div>
	<form id="join_form">
		<div id = "join_tab">
			
				<div class="join_input">playerId<input  id = "join_id"type="text" name="playerId" /></div>
				<div class="join_input">playerName<input  type="text" name="playerName" /></div>
				<div class="join_input">teamId<input  type="text" name="teamId" /></div>
				<div class="join_input">ePlayerName<input type="text" name="ePlayerName" /></div>
				<div class="join_input">nickName<input  type="text" name="nickName" /></div>
				<div class="join_input">joinYYYY<input   type="text" name="joinYYYY" /></div>
				<div class="join_input">backNo<input   type="text" name="backNo" /></div>
				<div class="join_input">nation<input   type="text" name="nation" /></div>
				<div class="join_input">birthDate<input  type="text" name="birthDate" /></div>
				<div class="join_input">solar<input  id = "join_solar" type="text" name="solar" /></div>
				<div class="join_input">height<input   type="text" name="height" /></div>
				<div class="join_input">weight<input  type="text" name="weight" /></div>
				<input type="hidden" name = "action" value ="create"/>
				<input type="hidden" name = "page" value ="login"/>	
				<div class="back"><h3><a  href="#">뒤로가기</a></h3></div>
				<div class="back" ><input id="join_btn" type="button" value = "회원가입" /></div>		
		
		</div>	
	</form>
	</div>	
<div></div>	
<div></div>										


<script>
app.init('${ctx}');
</script>
