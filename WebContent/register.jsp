
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Đăng ký | TS-Homeware</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {

		$("#userregister").keypress(function() {
			$("#userregister-error").html('');
		});
		$("#passregister").keypress(function() {
			$("#passregister-error").html('');
		});
		$("#repassregister").keypress(function() {
			$("#repassregister-error").html('');
		});
		$("#emailregister").keypress(function() {
			$("#emailregister-error").html('');
		});
		$("#nameregister").keypress(function() {
			$("#nameregister-error").html('');
		});
		$("#sdtregister").keypress(function() {
			$("#sdtregister-error").html('');
		});
		$("#addressregister").change(function() {
			$("#addressregister-error").html('');
		});

		/* $('#email-login #password-login  #btn-login').keypress(function(event) {
			 if (event.keyCode == 13 || event.which == 13) {
			         event.preventDefault();      
			    }
			}); */
		/* if($("#email-login").val() != '' && $("#password-login").val() !=''){
			$('#rememberme').prop('checked', true);
		} */

	})
</script>
</head>
<body>
	<%
		String eUsername = "", ePassword1 = "", ePassword2 = "", eEmail = "", eFullname = "", ePhone = "", eAddress = "";
		if (request.getAttribute("eUsername") != null) {
			eUsername = (String) request.getAttribute("eUsername");
		}
		if (request.getAttribute("ePassword1") != null) {
			ePassword1 = (String) request.getAttribute("ePassword1");
		}
		if (request.getAttribute("ePassword2") != null) {
			ePassword2 = (String) request.getAttribute("ePassword2");
		}

		if (request.getAttribute("eEmail") != null) {
			eEmail = (String) request.getAttribute("eEmail");
		}
		if (request.getAttribute("eFullname") != null) {
			eFullname = (String) request.getAttribute("eFullname");
		}
		if (request.getAttribute("ePhone") != null) {
			ePhone = (String) request.getAttribute("ePhone");
		}
		if (request.getAttribute("eAddress") != null) {
			eAddress = (String) request.getAttribute("eAddress");
		}
	%>
	<div class="hidden-header-register">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<section id="form-register-ts">
	<div class="container-register">

		<div class="signup-form">
			<h2>ĐĂNG KÝ TÀI KHOẢN</h2>
			<form action="Register_Controller" method="post">

				<input type="text" id="userregister" placeholder="Tài khoản"
					name="username" value="" />
				<p id="userregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=eUsername%></p>


				<input type="password" id="passregister" placeholder="Mật khẩu"
					name="password1" value="" />
				<p id="passregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=ePassword2%></p>


				<input type="password" id="repassregister"
					placeholder="Nhập lại mật khẩu" name="password2" value="" />
				<p id="repassregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=ePassword2%></p>



				<input type="text" id="emailregister" placeholder="Địa chỉ Email"
					name="email" value="" />
				<p id="emailregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=eEmail%></p>


				<input type="text" id="nameregister" placeholder="Họ và tên"
					name="fullname" value="" />
				<p id="nameregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=eFullname%></p>


				<input type="tel" id="sdtregister" placeholder="Số điện thoại"
					name="phone" value="" />
				<p id="sdtregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=ePhone%></p>


				<input type="text" id="addressregister" placeholder="Địa chỉ"
					name="address" value="" />
				<p id="addressregister-error"
					style="color: black; margin-left: 7%; margin-top: 2%"><%=eAddress%></p>
				<span
					style="color: white; margin-left: 7%; margin-top: 2%; font-weight: bold">${message}</span>
				<br> </br>
				<button type="submit" class="btn btn-default">Đăng Ký</button>
				<div class="click">
					<a id="login-click" href="account.jsp"> Bạn đã có tài khoản?
						Đăng nhập ngay ! </a>
				</div>
			</form>

		</div>

	</div>


	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>