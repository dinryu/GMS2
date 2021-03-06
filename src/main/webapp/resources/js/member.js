/* member javascript */
var app=app || {};

app.path=(function(){
	var init=function(ctx){
		app.session.init(ctx);
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		location.href=ctx()+"/auth/login_view";
	};
	var setContentView=function(){		
	};
	var ctx=function(){
		return app.session.getPath('ctx');
	};
	var js=function(){
		return app.session.getPath('js');
	};
	var img=function(){
		return app.session.getPath('img');
	};
	var css=function(){
		return app.session.getPath('css');
	};
	return {
		init : init,
		ctx : ctx,
		js : js,
		img : img,
		css : css
	};
})();

app.session=(function(){
	var init=function(ctx){
		sessionStorage.setItem('ctx',ctx);
		sessionStorage.setItem('js',ctx+'/resources/js');
		sessionStorage.setItem('img',ctx+'/resources/img');
		sessionStorage.setItem('css',ctx+'/resources/css');
	};
	var getPath=function(x){
		return sessionStorage.getItem(x);
	};
	return {
		init : init,
		getPath : getPath
	}
})();

app.main=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		$('.list-group li').eq(0).on('click',function(){
			alert('app.main.member 추가');			
			app.controller.moveTo('member','member_add');
		});
		$('.list-group li').eq(1).on('click',function(){
			alert('리스트');
			app.member.list('1');
		});
		$('.list-group li').eq(2).on('click',function(){
			app.controller.moveTo('member','member_detail');
		});
		$('.list-group li').eq(3).on('click',function(){
			app.controller.deleteTarget('lee','member','member_delete');
		});
		
		$('.list-group li').eq(4).on('click',function(){
			app.controller.moveTo('grade','grade_add');
		});
		$('.list-group li').eq(5).on('click',function(){
			app.controller.moveTo('grade','grade_list');
		});
		$('.list-group li').eq(6).on('click',function(){
			app.controller.moveTo('grade','grade_detail');
		});
		$('.list-group li').eq(7).on('click',function(){
			app.controller.deleteTarget('hong','grade','grade_delete');
		});
		
		$('.list-group li').eq(8).on('click',function(){
			app.controller.moveTo('board','board_write');
		});
		$('.list-group li').eq(9).on('click',function(){
			app.controller.moveTo('board','board_list');
		});
		$('.list-group li').eq(10).on('click',function(){
			app.controller.moveTo('board','board_detail');
		});
		$('.list-group li').eq(11).on('click',function(){
			app.controller.deleteTarget('hong','board','board_delete');
		});
	};
	var setContentView=function(){
		var $u1=$("#main_ul_stu");
		var $u2=$("#main_ul_grade");
		var $u3=$("#main_ul_board");
		$u1.addClass("list-group");
		$u2.addClass("list-group");
		$u3.addClass("list-group");
		$('.list-group').children().addClass("list-group-item");
	};
	return {
		init:init
	};
})();

app.auth=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		$('#loginBtn').on('click',function(){
			if($('#input_id').val()===""){
				alert('ID 를 입력해 주세요');
				return false;
			}
			if($('#input_pass').val()===""){
				alert('PASS 를 입력해 주세요');
				return false;
			}
			$('#login_box').attr('action',app.path.ctx()+"/auth/login");
			$('#login_box').attr('method','post');
			return true;
		});
	};
	var setContentView=function(){};
	return {
		init : init
	};
})();

app.navbar=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		$('.dropdown-menu a').eq(0).on('click',function(){
			app.controller.moveTo('member','member_add');
		});
		$('.dropdown-menu a').eq(1).on('click',function(){
			app.member.list('1');
		});
		$('.dropdown-menu a').eq(2).on('click',function(){
			app.controller.moveTo('member','member_detail');
		});
		$('.dropdown-menu a').eq(3).on('click',function(){
			app.controller.deleteTarget('hong','member','member_delete');
		});
		$('.dropdown-menu a').eq(4).on('click',function(){
			app.controller.moveTo('grade','grade_add');
		});
		$('.dropdown-menu a').eq(5).on('click',function(){
			app.controller.moveTo('hong','grade','grade_list');
		});
		$('.dropdown-menu a').eq(6).on('click',function(){
			app.controller.moveTo('grade','grade_detail');
		});
		$('.dropdown-menu a').eq(7).on('click',function(){
			app.controller.deleteTarget('hong','grade','grade_delete');
		});
		$('.dropdown-menu a').eq(8).on('click',function(){
			app.controller.moveTo('board','board_write');
		});
		$('.dropdown-menu a').eq(9).on('click',function(){
			app.controller.moveTo('board','board_list');
		});
		$('.dropdown-menu a').eq(10).on('click',function(){
			app.controller.moveTo('board','board_detail');
		});
		$('.dropdown-menu a').eq(11).on('click',function(){
			app.controller.deleteTarget('hong','board','board_delete');
		});
	};
	var setContentView=function(){
		var $u1=$("#navbar_ul_stu");
		var $u2=$("#navbar_ul_grade");
		var $u3=$("#navbar_ul_board");
		$u1.addClass("dropdown-menu");
		$u2.addClass("dropdown-menu");
		$u3.addClass("dropdown-menu");		
	};
	return {init:init};
})();

app.member=(function(){ //ns패턴
	var init=function(){
		onCreate();	

	};
	var onCreate=function(){
		setContentView();
		$('#updateBtn').on('click',function(){
		//	id,phone,email,title;
			/*
			sessionStorage.setItem('id',$('#detail_id').text());
			sessionStorage.setItem('phone',$('#detail_phone').text());
			sessionStorage.setItem('email',$('#detail_email').text());
			sessionStorage.setItem('title',$('#detail_title').text());
			*/
			app.controller.moveTo('member','member_update');
		});
	};
	var setContentView=function(){		
	};
	var list=function(pageNumber){
		alert('app.member.list(pageNumber) : '+pageNumber);
		location.href=app.path.ctx()+'/member/mlist/'+pageNumber;
	};
	var insert=function (){
		alert('app.member.insert ...');
		$('#join_yes_btn').on('click',function(){
			alert('버튼클릭 회원추가');
			$('#join_form').attr('action',app.path.ctx()+"/member/minsert");
			$('#join_form').attr('method','post');
			return true;
		});						
	};
	var update=function (){
		$('#updatebtn').on('click',function(){			
			alert('상세 수정할');
			$('#confirmBtn').attr('action',app.path.ctx()+"/student/mupdate");
			$('#confirmBtn').attr('method','post');
			return true;
		});	
	};
	
	return {
		init : init,
		list : list,
		insert : insert,
		update : update
	};
})();

app.grade=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){};
	return {
		init : init
	};
})();

app.board=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){};
	return {
		init : init
	};
})();

app.controller=(function(){
	alert("app.controller");
	var init=function(){		
	  };
	var moveTo=function(dir,page){	
		alert("app.controller.moveTo : "+app.path.ctx()+"/common/path/"+dir+"/"+page);
		location.href=app.path.ctx()+"/common/path/"+dir+"/"+page;
	  };
	  
	var logout=function (dir,page){
		location.href="${ctx}/"+dir+".do?action=logout&page="+page;
	  };
	
	var deleteTarget=function (target,dir,page){
		prompt(target+'의 ID?');
		location.href=
			app.path.ctx()+'/'+dir+"/"+page;
	  };
	var list=function (dir,page,pageNumber){
		location.href=app.ctx()+"/"+dir+".do?action=list&page="+page
					+"&pageNumber="+pageNumber;
	  };
    var updateStudent=function (id,email){
		alert('수정할 id'+id);
		location.href=app.ctx()+"/member.do?action=update&page=member_update&id="
			+id+"&email="+email;
	  };
	var deleteStudent=function (id){
		alert('삭제할 id'+id);
		location.href=app.path.ctx()+"/member/mdelete/"+id;
	  };
	var detailStudent=function (id){
		alert('var detailStuden 진입 id : '+app.path.ctx()+"/member/mdetail/"+id);
		location.href=app.path.ctx()+"/member/mdetail/"+id;
	  };
	var searchStudent=function (){
		var search=document.getElementById('search').value;
		location.href=app.ctx()+"/member.do?action=search&page=member_list&search="+search;
	  };	
	return {
		init : init,
		moveTo : moveTo,
		logout : logout,
		deleteTarget : deleteTarget,
		list : list,
		updateStudent : updateStudent,
		deleteStudent : deleteStudent,
		detailStudent : detailStudent,
		searchStudent : searchStudent
	  };
})();

