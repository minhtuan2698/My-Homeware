<%@page import="java.util.HashMap"%>
<%@page import="com.restfb.types.User"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="Model.*"%>
<%@page import="Model.Cart"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Thanh Toán | TS-Homeware</title>
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
</head>
<body>
	<%
		Cart cart = new Cart();
		if (session.getAttribute("cart") != null)
			cart = (Cart) session.getAttribute("cart");

		Account acc = new Account();
		if (session.getAttribute("SessionUsername") != null)
			acc = (Account) session.getAttribute("SessionUsername");
		
		if(session.getAttribute("cart")==null)  {
			response.sendRedirect("index.jsp");
		}
		else {
			if(session.getAttribute("SessionUsername")==null) {
				response.sendRedirect("account.jsp");
			}
	
		}

		NumberFormat nf = NumberFormat.getInstance();
		HashMap<Integer, Item> map = cart.getCart();
		
		
		SimpleDateFormat format = new SimpleDateFormat("E, dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 4);

		String date = format.format(calendar.getTime());
		
		
		
		
	%>


	<jsp:include page="header.jsp"></jsp:include>

	<section id="cart_items">
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="index.jsp">Home</a></li>
				<li class="active">Thanh Toán</li>
			</ol>
		</div>



		<br>
		<div class="shopper-informations" style="text-align: center;">
			<div class="row"
				style="border: 4px solid rgb(195, 157, 90); border-radius: 20px; background: silver;">
				<div style="width: 40%; margin-left: 28%;">
					<div class="shopper-info">
						<form action="Pay_Controller" method="post">
						
							<p
								style="margin-top: 20px; text-transform: uppercase; text-align: center; width: 511.27px">Tổng
								tiền</p>
							<span style="color: red;"></span> <input type="text"
								name="Total"
								value="<%=nf.format(cart.total(map))%>" VNĐ
								style="color: red; font-weight: bold; backgrounf: #DDDDDD; font-size: 20px; border: 2px solid #219AFC; text-align: center"
								readonly></input>
							<p style="text-transform: uppercase; width: 511.27px">Họ và
								tên</p>
							<span style="color: red;"></span> <input type="phone" name="Fullname"
								value="<%=acc.getFullname()%>"
								style="text-align: center; font-size: 15px"></input>



							<p style="text-transform: uppercase; width: 511.27px">Địa Chỉ
								Giao Hàng</p>

							<span style="color: red"></span> <input name="Shipping_Address"
								value="<%=acc.getAddress()%>"
								style="text-align: center; font-size: 15px"></input>


							<p style="text-transform: uppercase; width: 511.27px">Số điện
								thoại nhận hàng</p>
							<span style="color: red;"></span> <input type="phone"
								name="Phone" value="<%=acc.getPhone()%>"
								style="text-align: center; font-size: 15px"></input>
							
							<p style="text-transform: uppercase; width: 511.27px">Ngày
								giao hàng dự kiến</p>
							<span style="color: red;"></span> <input type="text"
								name="Time_Giaohang" value="<%=date %>" readonly
								style="text-align: center; font-size: 15px"></input>
							<p style="text-transform: uppercase; width: 511.27px">Phương
								Thức Thanh Toán</p>
							<span style="color: red;"></span> <select name="Payment_Method"
								onchange="validateSelectBox(this)">
								<option value="Thanh toán khi giao hàng">Thanh toán
									khi giao hàng</option>
								<option value="Thanh toán qua thẻ ngân hàng ">Thanh
									toán qua thẻ ngân hàng</option>
							</select>

							<%-- <input type="hidden" value="<%=user.getUsername()%>" name="Account" /> --%>
							<input type="submit" value="Xác Nhận Mua Hàng"
								class="btn btn-primary" id="okie" style="margin-bottom: 20px" />
						</form>
						<span style="color: red;">${message}</span>
					</div>
				</div>

				<div id="ss" style="display: none; margin-top: 30px">
					<!--  <img  style="width:400px" src="images/home/sa.png" alt="" /><br> -->
					<img style="width: 200px" src="images/home/paypal.png" alt="" />

					<div>
						<span style="margin-left: 80px;">Sản phẩm </span><span
							style="margin-left: 150px;">Giá tiền </span> <span
							style="margin-left: 110px;"> Số lượng</span>
					</div>
					<form action="${initParam['posturl']}" method="POST">
						<input type="hidden" name="upload" value="1" /> <input
							type="hidden" name="return" value="${initParam['returnurl']}" />
						<input type="hidden" name="cmd" value="_cart" /> <input
							type="hidden" name="business" value="${initParam['business']}" />

						<div>

							<input type="text" name="item_name_1" value="" readonly
								style="width: 25%; background: #DDDDDD;" /> <input type="text"
								name="amount_1" value="" readonly style="background: #DDDDDD" />

							<input type="text" name="quantity_1" value="" readonly
								style="background: #DDDDDD; width: 5%" />
						</div>

						<input type="submit" class="btn btn-primary"
							value="Xác nhận và Thanh toán"
							style="margin-top: 5%; margin-bottom: 20px" />

					</form>


				</div>
			</div>




		</div>
		</br>
		</hr>
		</br>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>



	<script language="javascript">
		function validateSelectBox(obj) {
			var options = obj.children;
			for (var i = 0; i < options.length; i++) {
				if (options[1].selected) {
					document.getElementById('ss').style.display = "block";
					document.getElementById('okie').style.display = "none";
				} else {
					document.getElementById('ss').style.display = "none";
					document.getElementById('okie').style.display = "block";

				}
			}

		}
	</script>
</body>
</html>