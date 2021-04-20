
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Tài Khoản | TS-Homeware</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-social.css" rel="stylesheet">
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=327890844754184&autoLogAppEvents=1"></script>


</head>
<body>

	<div id="fb-root"></div>

	<div class="hidden-header-login">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	
	<% String error = "";
	if(request.getAttribute("error")!=null)
		error = (String) request.getAttribute("error");
	
	%>

	<section id="form-login-ts">
	<div class="container-login">
		<div class="login-form" style="width: 36%">
			<h2>Vui lòng nhập mã xác minh</h2>
			
			<form action="VerifyCode" method="post">

				<input type="text"
					onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"
					placeholder="Nhập mã xác minh gồm 6 số" name="code" value=""
					style="padding-left:0px; margin-bottom: 3%; width: 300px; text-align: center;"; maxlength="6" /> 
					<p id="userregister-error"
				style="color: black; margin-left: 25%; margin-top: 2%"><%=error%></p>
			
				
				
				<button style="margin:25px auto; width: 300px" type="submit" class="btn btn-default">Tiếp theo</button>



			</form>
		</div>

	</div>

	</section>




	<jsp:include page="footer.jsp"></jsp:include>
	<div class="modal fade" id="forgotModal" role="dialog"
		style="display: none; width: 50%; margin: auto">
		<div class="modal-dialog modal-center" role="document">
			<div class="modal-content" style="border: 1px solid lightgray">
				<div class="modal-header" style="background-color: #F5F5F5">
					<h5 class="modal-title" style="color: black">Quên mật khẩu</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
				</div>
				<div class="modal-body">
					<p>Vui lòng nhập địa chỉ email của bạn!</p>
					<input type="text" name="email"
						style="width: 100%; border-radius: 5px; border: 1px solid lightgray; padding: 5px"
						placeholder="E-mail" id="emailForgot" /> <span class="alert"
						style="font-size: 15px; padding: 10px 0px" id="alert-emailForgot"></span>
					<span class="alert"
						style="font-size: 15px; color: green; padding: 10px 0px"
						id="alert-emailSuccess"></span>
					<button
						style="width: 20%; margin-top: 30px; margin-bottom: 30px; text-align: center; margin-left: 35%"
						class="btn btn-success" id="sendForgot">GỬI</button>
					<button type="button" id="clo" class="btn btn-default"
						style="margin-left: 30px; display: none" data-dismiss="modal">Đóng</button>
					</form>
				</div>

			</div>
		</div>
	</div>
	<div class="modal fade" id="resendModal" role="dialog"
		style="display: none">
		<div class="modal-dialog modal-center" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Mail</h5>
				</div>
				<div class="modal-body">
					<p>Mail đã được gửi. Vui lòng kiểm tra email!</p>
				</div>
				<div class="modal-footer">
					<button type="button" id="btn-ok" class="btn btn-success"
						data-dismiss="modal">Đồng ý</button>
				</div>
			</div>
		</div>
</body>
</html>