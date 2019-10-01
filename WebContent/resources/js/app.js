var app = (()=>{
	return {
		init : (ctx)=>{
			playerService.login();	
	
			
			$('#a_join').click(()=>{
				alert('회원가입이동');
				location.assign(ctx+'/player.do?action=move&page=join');
			});
		
			$('#back').click(()=>{
				alert('뒤로가라');
				location.assign(ctx+'/player.do?action=move&page=login');
			});
		
		}
	};
})();


var player = (()=>{
	var _playerId, _playerName, _teamId, _ePlayerName, _nickName, _joinYYYY,
	_position, _backNo, _nation, _birthDate, _solar, _height, _weight;
	var setPlayerId=(playerId)=>{this._playerId = playerId;}
	var setSolar=(solar)=>{this._solar = solar;}
	var getPlayerId = ()=>{return this._playerId;}
	var getSolar = ()=>{return this._solar;}
	return {
		setPlayerId : setPlayerId,
		setSolar : setSolar,
		getPlayerId : getPlayerId,
		getSolar : getSolar
	};
})();

var playerService = (()=>{
	return {
		login:()=>{
			$('#login_btn').click(()=>{
				if($('#username').val()===''||$('#userid').val()===''){
					alert('필수값이 없음');
				}else{
					alert('입력한 아이디값'+$('#username').val()+$('#userid').val());
					$('#login_form').attr('action','/jee-soccer/player.do');
					$('#login_form').submit();	
				}
				
			});
		}
	};
})();




