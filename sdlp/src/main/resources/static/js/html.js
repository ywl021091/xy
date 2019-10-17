	// jqeury version
         $(document).ready(function () {
             // chrome 浏览器直接加上下面这个样式就行了，但是ff不识别
             $('body').css('zoom', 'reset');
             $(document).keydown(function (event) {
 
               if ((event.ctrlKey === true || event.metaKey === true)
                 && (event.which === 61 || event.which === 107
                     || event.which === 173 || event.which === 109
                     || event.which === 187  || event.which === 189))
                {
                    event.preventDefault();
                }
             });
 
                $(window).bind('mousewheel DOMMouseScroll', function (event) {
                    if ((event.ctrlKey === true || event.metaKey=== true)
                    		&&(event.wheelDelta>0 || event.wheelDelta<0 
                    				||event.detail>0 || event.detail<0)) {
                        event.preventDefault();
                    }
 
             });
         });






	setInterval(function() {
		var va = document.getElementById("time")
		var tim = new Date();
		//获取年   
		var year = tim.getFullYear();
		//获取月
		var mon = tim.getMonth() + 1;
		//获取日
		var dat = tim.getDate();
		//获取时
		var ho = tim.getHours();
		//获取分
		var mi = tim.getMinutes();
		//获取秒
		var se = tim.getSeconds();
		//获取周
		var day = tim.getDay();
		var a = new Array("日", "一", "二", "三", "四", "五", "六");
		/* var times = year + "年" + mon + "月" + dat + "日 " + ho + "时" + mi + "分"
				+ se + "秒" + " 星期" + a[day]; */
		var times = year + "年" + mon + "月" + dat + "日 " + ho + "时" + mi + "分"
				+ " 星期" + a[day];
		va.innerHTML = times
	}, 1000);
	
	//限制字符非空
	function update_check() {
		var oldpass = $("#oldpass").val();
		var length = oldpass.length;
		var newpass = $("#newpass").val();
		var length2 = newpass.length;
		var confirmpass = $("#confirmpass").val();
		var length3 = confirmpass.length;
		if (length == "" || length2 == "" || length3 == "") {
			$("#passNullAlert").show();
			return;
		} else {
			$("#passNullAlert").hide();

		}
		if (newpass == confirmpass) {
			$("#passDifferenceAlert").hide();
		} else {
			$("#passDifferenceAlert").show();
			return;
		}
		$.ajax({
			"url" : "/sysuser/updatePass",
			"data" : {
				"oldpass" : oldpass,
				"newpass" : newpass,
				"confirmpass" : confirmpass
			},
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				if (data.status == "失败") {
					$("#passErrorAlert").show();
					return;
				}
				if (data.status == "成功") {
					$("#passErrorAlert").hide
					$("#passModal").modal('hide');
				}
			},
			"error" : function() {
				alert("提交失败");
				return;
			}
		});
	};
	//动态生成菜单
	$(document).ready(function(){
		$.ajax({
			"url" : "/role/selectPermissionList",
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				for (let i = 0; i < data.length; i++) {
					if(data[i].name == "用户管理"){
						$("#public_basic ul").append("<li><a href='/sysuser/listSysuserHtml'>用户管理</a></li>");
					}
					if(data[i].name == "SIM卡维护"){	
						$("#public_basic ul").append("<li><a href='/simcard/sim_index'>SIM卡维护</a></li>");
					}
					if(data[i].name == "授权管理"){	
						$("#public_basic ul").append("<li><a href='/role/listRoleHtml'>授权管理</a></li>");
					}
					if(data[i].name == "客户信息管理"){	
						$("#public_basic ul").append("<li><a href='/customer/listHtml'>客户信息管理</a></li>");
					}
					if(data[i].name == "终端信息维护"){
						$("#public_basic ul").append("<li><a href='/terminal/listTerminalHtml'>终端信息维护</a></li>");
					}
					if(data[i].name == "终端类型"){
						$("#public_basic ul").append("<li><a href='/template/listHtml'>终端类型</a></li>");
					}
					if(data[i].name == "远程信息查询"){
						$("#public_data ul").append("<li><a href='/getdata/queryDataHtml'>远程信息查询</a></li>");
					}
					if(data[i].name == "信息展示"){	
						$("#public_data ul").append("<li><a href='/getdata/dataListHtml'>信息展示</a></li>");
					}
					if(data[i].name == "信息告警"){	
						$("#public_data ul").append("<li><a href='/warn/warnMessageHtml'>信息告警</a></li>");
					}
					/*if(data[i].name == "统计分析"){	
						$("#public_statistics ul").append("<li><a href=''>统计分析</a></li>");
					}*/
					if(data[i].name == "日志"){	
						$("#public_statistics ul").append("<li><a href='/logger/getLoggerHtml'>日志</a></li>");
					}
					/*if(data[i].name == "控制指令"){	
						$("#public_control ul").append("<li><a href='/commandData/commandInstructionHtml'>控制指令</a></li>");
					}*/
					if(data[i].name == "地图"){	
						$("#public_control ul").append("<li><a href='/getMap/cityMapHtml'>地图</a></li>");
					}
				}
				//通过UTL地址打开对应导航栏目录
				let url = window.location.pathname;
				let url1= url.slice(1,5);
				if(url1 == "role"){
					$("#public_basic").addClass("show");
				};
				url1= url.slice(1,7);
				if(url1 == "getMap"){
					$("#public_basic").addClass("show");
				};
				url1= url.slice(1,8);
				if(url1 == "sysuser" || url1 == "simcard"){
					$("#public_basic").addClass("show");
				};
				url1= url.slice(1,9);
				if(url1 == "terminal" || url1 == "customer"||url1 == "template"){
					$("#public_basic").addClass("show");
				};
				url1= url.slice(1,13);
				if(url1 == "usercustomer"){
					$("#public_basic").addClass("show");
				};
				if(url == "/getdata/queryDataHtml" || url == "/getdata/dataListHtml" || url == "/warn/warnMessageHtml"){
					$("#public_data").addClass("show");
				};
				if(url == "/logger/getLoggerHtml"){
					$("#public_statistics").addClass("show");
				};
				if(url == "/commandData/commandInstructionHtml"){
					$("#public_control").addClass("show");
				};
			},
		});
	});
	//首页头部展示当前用户姓名
	$(document).ready(function(){
		$.ajax({
			"url" : "/activeUser",
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				$("#public_namefirst").text(data.name);
			},
		});
	});
	//动态生成修改密码的头部
	function getActiveUser(){
		$.ajax({
			"url" : "/activeUser",
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				$("#public_name").text(data.name);
				$("#public_usernum").text(data.usernum);
			},
		});
	};
	// 从数据库获取显示设备识别码
	$.ajax({
		"url" : "/getdata/show_sbsbm",
		"type" : "POST",
		"dataType" : "json",
		"success" : function(data) {
			var sbsbm = document.getElementById('sbsbm');
			for (i = 0; i < data.length; i++) {
				sbsbm.options[i] = new Option(data[i], data[i]);
			}
			show_sbsbm(sbsbm);
		}
	});
	function show_sbsbm(sbsbm) {

		if (sbsbm != "") {
			$.ajax({
				"url" : "/getdata/toSbsbm",
				"data" : {
					"sbsbm" : sbsbm.value
				},
				"type" : "POST",
				"dataType" : "text"
			// "success" : function() {
			// //alert(data);
			// }
			});
		}
	}
	function test_sbsbm() {
		$.ajax({
			"url" : "/getdata/show_sbsbm",
			"type" : "POST",
			"dataType" : "json",
			"success" : function(data) {
				var sbsbm = document.getElementById('sbsbm');
				for (i = 0; i < data.length; i++) {
					sbsbm.options[i] = new Option(data[i], data[i]);
				}
			}
		})
	};