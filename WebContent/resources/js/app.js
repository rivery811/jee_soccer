var app = (()=>{
	return {
		init : (ctx)=>{
			
			$('#login_form').submit(()=>{
				alert('로그인버튼 클릭');
			});
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