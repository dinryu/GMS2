/* member javascript */

var app =app || {};

app.path=(function(){
	var init = function(ctx){
		app.session.init(ctx);
		onCreate();
	};
	var onCreate=function(){
		alert('ctx : '+ctx);
		setContentView();
		location.href=ctx()+"/auth/login_view";
	};
	var setContentView=function(){
		
	};
	var ctx=function(){
		return app.session.getPath('ctx');
	};
	var js=function(){
		return app.session.getJsPath('js');
	};
	var img=function(){
		return app.session.getImgPath('img');
	};
	var css=function(){
		return app.session.getCssPath('css');
	};

	return {
		
		init:init,
		ctx:ctx,
		js:js,
		img:img,
		css:css
	}
	
})();

app.session=(function(){
	var init = function(ctx){
		sessionStorage.setItem('ctx', ctx);
		sessionStorage.setItem('js', '/resources/js');
		sessionStorage.setItem('img', '/resources/img');
		sessionStorage.setItem('css', '/resources/css');
	};
	var getPath=function(x){
		return sessionStorage.getItem(x);
	};
	return {
		'init' : init,
		'getPath' : getPath
	}
})();

app.auth=(function(){
	var init=function(){

		//이벤트 핸들러
		$('#loginBtn').on('click',function(){
			if($('#input_id').val()===""){
				alert("id를 입력해 주세요");
				return false;
			}
			if($('#input_pass').val()===""){
				alert("pass를 입력해 주세요");
				return false;
			}
			alert('경로지정');
			$('#login_box').attr('action',app.path.ctx()+"/auth/login");
			alert(app.path.ctx()+"/auth/main_view");
			$('#login_box').attr('method','post');
			return true;
		});
	};
	return {
		init:init
	};
})();

app.main=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	
		$('.list-group').children().addClass("list-group-item");
 		
 		$('.list-group-item a').eq(0).on('click',function(){
 			alert('0');
 			location.href=app.path.ctx()+"/member/mAdd";
 		});
 		$('.list-group-item a').eq(1).on('click',function(){
 			alert('1');
 			location.href=app.path.ctx()+"/member/mlist";
// 			app.controller.list('member','member_list','1');
 		});
 		$('.list-group-item a').eq(2).on('click',function(){
 			alert('2');
 			location.href=app.path.ctx()+"/member/mdetail";
 		});
 		$('.list-group-item a').eq(3).on('click',function(){
 			alert('3');
 			location.href=app.path.ctx()+"/member/mdelete";
 		});
 		
 		
 		$('.list-group-item a').eq(4).on('click',function(){
 			alert('4');
 			location.href=app.path.ctx()+"/grade/gAdd";
 		});
 		$('.list-group-item a').eq(5).on('click',function(){
 			alert('5');
 			location.href=app.path.ctx()+"/grade/glist";
// 			app.controller.list('member','member_list','1');
 		});
 		$('.list-group-item a').eq(6).on('click',function(){
 			alert('6');
 			location.href=app.path.ctx()+"/grade/gdetail";
 		});
 		$('.list-group-item a').eq(7).on('click',function(){
 			alert('7');
 			location.href=app.path.ctx()+"/grade/gdelete";
 		});
 		
 		
 		$('.list-group-item a').eq(4).on('click',function(){
 			alert('8');
 			location.href=app.path.ctx()+"/board/bWrite";
 		});
 		$('.list-group-item a').eq(5).on('click',function(){
 			alert('9');
 			location.href=app.path.ctx()+"/board/blist";
// 			app.controller.list('member','member_list','1');
 		});
 		$('.list-group-item a').eq(6).on('click',function(){
 			alert('10');
 			location.href=app.path.ctx()+"/board/bdetail";
 		});
 		$('.list-group-item a').eq(7).on('click',function(){
 			alert('11');
 			location.href=app.path.ctx()+"/board/bdelete";
 		});
 		
 		
	};
	var setContentView=function(){
		//객체 앞에 $를 붙이면 컴포넌트 객체로 구분짓는 것 (값은 담는 임시 객체가 아닌)
		var $u1 = $("#main_ul_stu");
 		var $u2 = $("#main_ul_grade");
 		var $u3 = $("#main_ul_board");
 		
 		$u1.addClass("list-group");
 		$u2.addClass("list-group");
 		$u3.addClass("list-group");
 
	};
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
		
	};
	var setContentView=function(){
		var $n1 = $("#nav_stu");
 		var $n2 = $("#nav_grade");
 		var $n3 = $("#nav_board");
 		var $n4 = $("#home");
 		var $n5 = $("#logout");
 		
 		$n1.addClass('dropdown-menu');
 		$n2.addClass('dropdown-menu');
 		$n3.addClass('dropdown-menu');
 		$n4.addClass("active");

		$('.active a').on('click',function(){
 			alert('home');
 			controller.moveTo('common','main');
 		});
 		$n5.on('click',function(){
 			alert('logout');
 			controller.logout('common','home');
 		});
 		$('.dropdown-menu a').eq(0).on('click',function(){
 			alert('0');
 			controller.moveTo('member','member_add');
 		});
 		$('.dropdown-menu a').eq(1).on('click',function(){
 			alert('1');
 			controller.list('member','member_list','1');
 		});
 		$('.dropdown-menu a').eq(2).on('click',function(){
 			
 			controller.detailStudent(prompt('조회할 id를 입력하세요.'));
 		});
 		$('.dropdown-menu a').eq(3).on('click',function(){
 			alert('2');
 			controller.deleteTarget('member');
 		});
	};
	return{
		init : init
	};
})();



app.member=(function(){
	var init=function(){
		onCreate();
		
	};
	var onCreate=function(){
		
		$('#update_btn').on('click',function(){
			//id, phone, email, title
			sessionStorage.setItem('id', $("#detail_id").val());
			sessionStorage.setItem('name', $("#detail_name").text());
			sessionStorage.setItem('phone', $("#detail_phone").text());
			sessionStorage.setItem('email', $("#detail_email").text());
			sessionStorage.setItem('title', $("#update_title").text());
			controller.moveTo('member','member_update');
		});
		setContentView();
	};
	var setContentView=function(){
		
	};
	
	return {
		init : init
	};
})();

app.grade=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		
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
		
	};
	var setContentView=function(){};
	return {
		init : init
	};
})();


app.controller=(function(){
	var init=function(){
	};
	var moveTo=function(dir,page){
		location.href=app.path.ctx()+'/'+dir+'.do?action=move&page='+page;
	};
	var list=function(dir, page, pageNum){
		location.href=app.path.ctx()+'/'+dir+".do?action=list&page="+page+"&pageNum="+pageNum;
	}
	var logout=function(dir, page){
		location.href=app.path.ctx()+'/'+dir+'.do?action=logout&page='+page;
	}
	var deleteTarget=function(var1){
		window.prompt(var1+" ID?","");
	}
	var updateStudent=function(id, email){
 		alert('update 진입');
 		location.href=app.path.ctx()+'/member.do?action=update&page=member_update&id='+id+'&email='+email;
 	}
	var deleteStudent=function(id){
 		alert('삭제할 id '+id);
 		location.href=app.path.ctx()+'/member.do?action=delete&page=member_list&id='+id;
 	}
	var detailStudent=function(id){
 		alert('조회할 id '+id);
 		location.href=app.path.ctx()+'/member.do?action=detail&page=member_detail&id='+id;
 	}
	var findName=function(){
 		var findname = document.getElementById("findName").value;
 		alert('find_name: '+findname);
 		location.href=app.path.ctx()+'/member.do?action=search&page=member_list&findname='+findname;
 	}
	return {
		init : init,
		moveTo : moveTo,
		logout : logout,
		deleteTarget : deleteTarget,
		list : list,
		updateStudent : updateStudent,
		deleteStudent : deleteStudent,
		detailStudent : detailStudent,
		findName : findName
	};
})();