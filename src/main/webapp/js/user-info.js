$(function() {
	$("#changeName").click(function() {
		var name = $("input[name='name']").val();
		if (name != "") {
			$.ajax({
				type: 'post',
				url: '/caticket/user/editName',
				data:{
					name: name
				},
				dataType: 'json',
				success: function(data) {
					if (data.msg == "true") {
						$("#username").text(data.info);
						$("#errorInfo").text("");			
					} else {
						$("#errorInfo").text(data.info);
					}	
				},
				error: function(XMLHttpRequest) {
					$("#errorInfo").text("网络连接失败.");
				}
			});
		} else if (name == "") {
			$("#errorInfo").text("用户名不能为空.");
		} else {
			$("#errorInfo").text("用户名更新出现错误.");
		}
	});
	$("#changePassword").click(function() {
		var password = $("input[name='password']").val();
		if (password != "") {
			$.ajax({
				type: 'post',
				url: '/caticket/user/editPassword',
				data:{
					password: password
				},
				dataType: 'json',
				success: function(data) {
					if (data.msg == "true") {
						$("#errorInfo").text(data.info);						
					} else {
						$("#errorInfo").text(data.info);
					}	
				},
				error: function(XMLHttpRequest) {
					$("#errorInfo").text("网络连接失败.");
				}
			});
		} else if (password == "") {
			$("#errorInfo").text("密码不能为空.");
		} else {
			$("#errorInfo").text("密码更新出现错误.");
		}
	});
});