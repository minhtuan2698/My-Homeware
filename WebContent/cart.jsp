<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Giỏ Hàng | TS-Homeware</title>
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
if(session.getAttribute("cart")!=null)
	cart = (Cart) session.getAttribute("cart"); 
HashMap<Integer,Item> map = cart.getCart();
Set<Map.Entry<Integer,Item>> set = map.entrySet();

NumberFormat nf = NumberFormat.getInstance();

String error = "";
if(request.getAttribute("error")!=null) 
	error = (String) request.getAttribute("error");



%>


	<jsp:include page="header.jsp"></jsp:include>

	<section>
	<div class="container">
		<div class="row">

			<section id="cart_items">
			<div class="container">
				<div class="breadcrumbs">
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li > Giỏ Hàng </li>
				</div>
				
				<div class="table-responsive cart_info center">
					<table class="table table-condensed">
						<thead>
							<tr style="text-align:center" class="cart_menu">
								<td  class="image">Hình Ảnh</td>
								<td class="description" >Thông Tin Sản Phẩm</td>
								<td class="price">Giá Bán</td>
								<td class="price">Giảm Giá</td>
								<td class="quantity">Số Lượng</td>
								<td class="total">Thành Tiền</td>
								<td></td>
							</tr>
						</thead>
						
						<tbody>
						
						<%for (Entry<Integer, Item> i : set){ %>
						
							
							<tr style="border:1px solid rgb(195, 157, 90)">
								<td style="margin-left: 0px" class="cart_product"><a href="detail.jsp?id_product=<%=i.getValue().getProduct().getId_product()%>"><img style="width: 45%"
										src="<%=i.getValue().getProduct().getImage() %>" alt=""></a></td>
								<td class="cart_description">
									<h4>
										<a href="detail.jsp?id_product=<%=i.getValue().getProduct().getId_product()%>"><%=i.getValue().getProduct().getName_product() %></a>
									</h4>
									<br>
									<p> 
										Mã sản phẩm: <%=i.getKey() %>
										</p>
										
								</td>
								<td class="cart_price">
									<p>
									<%=nf.format(i.getValue().getProduct().getPrice()) %>
									</p>
								</td>
								<td class="cart_price">
									<p>
									<%=nf.format(i.getValue().getProduct().getSale()) %>
									</p>
								</td>
								
								<td class="cart_quantity">
									<div class="cart_quantity_button">
									<a class="cart_quantity_down"
											href="Cart_Controller?action=sub&ID_Product=<%=i.getValue().getProduct().getId_product()%>">
											- </a><input class="cart_quantity_input" type="text"
											value="<%=i.getValue().getQuantity() %>" autocomplete="off" size="2"
											disabled=""> 
										<a class="cart_quantity_up"
											href="Cart_Controller?action=insert&ID_Product=<%=i.getValue().getProduct().getId_product()%>">
											+ </a> 
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price"><%=nf.format((i.getValue().getProduct().getPrice()-i.getValue().getProduct().getSale())*i.getValue().getQuantity()) %>
									</p>
								</td>
								<td class="cart_delete"><a class="cart_quantity_delete"
									href="Cart_Controller?action=remove&ID_Product=<%=i.getValue().getProduct().getId_product()%>"><i
										class="fa fa-times"></i></a></td>
							</tr>

							
<%} %>
						</tbody>
					</table>
					<p style="font-size: 20px; font-weight: bold; margin: 30px">Tổng tiền: <%=nf.format(cart.total(map)) %> VNĐ</p>
				</div>
				
			</div>
			</section>
			<!--/#cart_items-->

			<section id="do_action">
			<div class="container">
				<!-- <div class="heading">
					<h3>Bạn muốn làm gì tiếp theo?</h3>
					
				</div> -->
				<div class="row">				
					<div class="col-sm-12" style="text-align:center; color:white">
						<!-- <div class="total_area">						
							<a class="btn btn-default update" href="index.jsp" onclick="return confirm('Bạn muốn hủy đơn hàng ?')">Hủy Đơn Hàng</a> 
							<a
								class="btn btn-default check_out" href="checkout.jsp">Mua Hàng</a>
						</div> -->
						<a class="btn btn-default check_out" onclick="testAlertDialog()" href="Checkout">Mua Hàng</a>
						
					</div>
				</div>
				<p style="color: red; font-size: 20px; text-align: center; padding-top: 30px;" ><%=error %></p>
				
				
			</div>
			</section>
			<!--/#do_action-->
		</div>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>