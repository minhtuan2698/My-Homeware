
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="util.DataUtil"%>
<%@page import="Model.Season"%>
<%@page import="Dao.SeasonDao_Impl"%>
<%@page import="Dao.SeasonDao"%>
<%@page import="Dao.BrandDao_Impl"%>
<%@page import="Dao.BrandDao"%>
<%@page import="Model.Brand"%>
<%@page import="Model.Category"%>
<%@page import="Dao.CategoryDao_Impl"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="Dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.ProductDao_Impl"%>
<%@page import="Model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Sản Phẩm | TS-Homeware</title>
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
	<script type="text/javascript"></script>



	<%
	
	NumberFormat currentLocale = NumberFormat.getInstance();
		ProductDao prdao = new ProductDao_Impl();
		CategoryDao catedao = new CategoryDao_Impl();
		BrandDao branddao = new BrandDao_Impl();
		SeasonDao seasondao = new SeasonDao_Impl();

		
		int index = 1;
		if (request.getParameter("index") != null)
			index = Integer.parseInt(request.getParameter("index"));

		ArrayList<Product> List_AllProduct_Hot = prdao.PagingProduct_Hot(index);

		int index1 = 1;
		if (request.getParameter("index1") != null)
			index1 = Integer.parseInt(request.getParameter("index1"));
		String id_category = request.getParameter("id_category");
		Category cate = catedao.GetName_CateGory(id_category);

		ArrayList<Product> List_ProductByCategory_Hot = prdao.PagingProduct_ByCategory_Hot(id_category, index1);

		int index2 = 1;
		if (request.getParameter("index2") != null)
			index2 = Integer.parseInt(request.getParameter("index2"));
		String id_brand = request.getParameter("id_brand");
		Brand brand = branddao.GetName_Brand(id_brand);

		ArrayList<Product> List_ProductByBrand_Hot = prdao.PagingProduct_ByBrand_Hot(id_brand, index2);

		int index3 = 1;
		if (request.getParameter("index3") != null)
			index3 = Integer.parseInt(request.getParameter("index3"));
		int id_season = 1;
		if (request.getParameter("id_season") != null) {
			id_season = Integer.parseInt(request.getParameter("id_season"));
		}
		Season season = seasondao.GetNameSeason(id_season);

		ArrayList<Product> List_ProductBySeason_Hot = prdao.PagingProduct_BySeason_Hot(id_season, index3);
	%>
	
	
	
	
	
	
	<div class="features_items"
			<%if (request.getParameter("id_category") == null && request.getParameter("id_brand") == null
					&& request.getParameter("id_season") == null) {%>
			style="display: block" <%} else {%> style="display:none" <%}%>>
			
			
			<div class="category-tab tim-kiem">
				<!--category-tab-->
				<div class="col-sm-12 tim-kiem">
					<ul class="nav nav-tabs" style="margin-bottom: 5%;">
						<li class="active"><a href="index.jsp" >Tổng Hợp Sản Phẩm </a></li>

						<li class="active"
							style="border-right: 1px solid black; border-left: 1px solid black"><a
							href="index_sale.jsp"> Sản Phẩm Khuyến Mãi</a></li>

						<li class="active"><a href="index_hot.jsp" style="background: #696763; color: white"> Bán Chạy Nhất</a></li>

						<li class="active"><a href="index_foru.jsp"
							style="display: block; border-left:1px solid black;">
								Dành Riêng Cho Bạn</a></li>


					</ul>

				</div>
			</div>
			
			<!-- // danh sách sản phẩm -->
			<marquee width="96%" behavior="alternate" bgcolor="#fe980f"
				style="margin-left: 2%; margin-bottom: 3%; border: 2px solid black ;background-color: rgb(195, 157, 90)">
				<h2 class="title1 text-center"
					style="color: black; font-size: 18px; text-transform: uppercase; width: 60%">
					Tổng Hợp Sản Phẩm</h2>
			</marquee>
			<br>

			<h2 class="title text-center">Danh Sách Sản Phẩm</h2>
			<div style="display: flex; flex-wrap: wrap;">

				<%
					for (Product pr : List_AllProduct_Hot) {
				%>

				<div class="col-sm-3 tim-kiem">
					<div class="product-image-wrapper" style="height: 422px">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="<%=pr.getImage()%>" alt="" />
								<h2><%=currentLocale.format(pr.getPrice() - pr.getSale())%> VNĐ</h2>
								<h4 <%if (pr.getSale() == 0) {%> style="color: white;"
									<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr.getSale())%> VNĐ
								</h4>
								<p <%if (pr.getSale() == 0) {%>
									style="font-weight: bold; min-height: 40px" <%%> <%} else {%>
									style="font-weight: bold; min-height:40px" <%}%>><%=pr.getName_product()%></p>
								<p style="font-size: 12px">
									<b>Số lượng</b>: còn
									<%=pr.getQuantity()%>
									sản phẩm
								</p>
								<a
									href="Cart_Controller?action=insert&ID_Product=<%=pr.getId_product()%>"
									<%if (pr.getQuantity() == 0) {%>
									style="pointer-events: none; background: #DDDDDD; color: white"
									<%} else {%> style=" pointer-events: auto;" <%}%>
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ Hàng</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<%-- <img src="<%=sp.getImage()%>" alt="" />
								<h2><%=nf.format(sp.getPrice())%>
									VNĐ
								</h2>
								<h4><%=nf.format(nh.getSale())%>
								VNĐ</h4>
								<p style="font-weight: bold"><%=sp.getName_Product()%></p> --%>
									<img src="<%=pr.getImage()%>" alt="" />
									<h2>
										<%=currentLocale.format(pr.getPrice() - pr.getSale())%> VNĐ
									</h2>
									<h4 <%if (pr.getSale() == 0) {%> style="color: #219AFC;"
										<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr.getPrice())%> VNĐ
									</h4>
									<p <%if (pr.getSale() == 0) {%> style="font-weight: bold;"
										<%} else {%> style="font-weight: bold;" <%}%>><%=pr.getName_product()%></p>
									<p style="font-size: 12px">
										<b>Số lượng</b>: còn
										<%=pr.getQuantity()%>
										sản phẩm
									</p>
									<a
										href="Cart_Controller?action=insert&ID_Product=<%=pr.getId_product()%>"
										<%if (pr.getQuantity() == 0) {%>
										style="pointer-events: none; background: #DDDDDD; color: white"
										<%} else {%> style=" pointer-events: auto;" <%}%>
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
								</div>
							</div>
							<img src="images/home/banchay.png" class="new" alt="" /> <img
								<%if (pr.getQuantity() == 0) {%>
								style="display: block; position: absolute; top: 320px; right: 25px;"
								<%} else {%> style="display:none" <%}%> src="images/home/hf.jpg"
								class="proend" alt="" />
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href="detail.jsp?id_product=<%=pr.getId_product()%>"><i
										class="fa fa-plus-square"></i>Xem chi tiết</a></li>
							</ul>
						</div>
					</div>
				</div>

				<%
					}
				%>
				<div style="clear: both"></div>




			</div>
			<div>
				<ul class="pagination tim-kiem">
					<%
						int count = prdao.GetTotalProduct_Hot();
						int endpage = count / 8;
						if(count<=8) endpage = 0; 
						else if (count / 8 != 0)
							endpage++;
						

						for (int i = 1; i <= endpage; i++) {
					%>
					<li><a class="tim-kiem" href="index_hot.jsp?&index=<%=i%>"
						style="border: 1px solid black; color: white; font-weight: bold; background: #696763"><%=i%></a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>





		<%-- ------------------------------------------------------------------------------------------------------------------ --%>
	
	
	
	
	

	<div class="col-sm-9 padding-right">

		<div class="features_items"
			<%if (request.getParameter("id_category") != null) {%>
			style="display: block;" <%} else {%> style="display:none" <%}%>>
			<div class="category-tab tim-kiem">
				<!--category-tab-->
				<div class="col-sm-12 tim-kiem">
					<ul class="nav nav-tabs" style="margin-bottom: 5%;">
						<li class="active"><a href="index.jsp" >Tổng Hợp Sản Phẩm </a></li>

						<li class="active"
							style="border-right: 1px solid black; border-left: 1px solid black"><a
							href="index_sale.jsp"> Sản Phẩm Khuyến Mãi</a></li>

						<li class="active"><a href="index_hot.jsp" style="background: #696763; color: white"> Bán Chạy Nhất</a></li>

						<li class="active"><a href="index_foru.jsp"
							style="display: block; border-left:1px solid black;">
								Dành Riêng Cho Bạn</a></li>


					</ul>

				</div>
			</div>

			<!-- // danh sách sản phẩm -->
			<marquee width="96%" behavior="alternate" bgcolor="#fe980f"
				style="margin-left: 2%; margin-bottom: 3%; border: 2px solid black;background-color: rgb(195, 157, 90)">
				<h2 class="title1 text-center"
					style="color: black; font-size: 18px; text-transform: uppercase; width: 60%">
					Sản Shẩm
					<%=cate.getName_category()%>
				</h2>
			</marquee>
			<br>

			<h2 class="title text-center">Danh Sách Sản Phẩm</h2>
			
			<div style="display: flex; flex-wrap: wrap;">

				<%
					for (Product pr1 : List_ProductByCategory_Hot) {
				%>

				<div class="col-sm-3 tim-kiem">
					<div class="product-image-wrapper" style="height: 422px">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="<%=pr1.getImage()%>" alt="" />
								<h2><%=currentLocale.format(pr1.getPrice() - pr1.getSale())%> VNĐ</h2>
								<h4 <%if (pr1.getSale() == 0) {%> style="color: white;"
									<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr1.getSale())%>
									VNĐ
								</h4>
								<p <%if (pr1.getSale() == 0) {%>
									style="font-weight: bold; min-height: 40px" <%%> <%} else {%>
									style="font-weight: bold; min-height:40px" <%}%>><%=pr1.getName_product()%></p>
								<p style="font-size: 12px">
									<b>Số lượng</b>: còn
									<%=pr1.getQuantity()%>
									sản phẩm
								</p>
								<a
									href="Cart_Controller?action=insert&ID_Product=<%=pr1.getId_product()%>"
									<%if (pr1.getQuantity() == 0) {%>
									style="pointer-events: none; background: #DDDDDD; color: white"
									<%} else {%> style=" pointer-events: auto;" <%}%>
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ Hàng</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<%-- <img src="<%=sp.getImage()%>" alt="" />
								<h2><%=nf.format(sp.getPrice())%>
									VNĐ
								</h2>
								<h4><%=nf.format(nh.getSale())%>
								VNĐ</h4>
								<p style="font-weight: bold"><%=sp.getName_Product()%></p> --%>
									<img src="<%=pr1.getImage()%>" alt="" />
									<h2>
										<%=currentLocale.format(pr1.getPrice() - pr1.getSale())%> VNĐ
									</h2>
									<h4 <%if (pr1.getSale() == 0) {%> style="color: #219AFC;"
										<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr1.getPrice())%> VNĐ
									</h4>
									<p <%if (pr1.getSale() == 0) {%> style="font-weight: bold;"
										<%} else {%> style="font-weight: bold;" <%}%>><%=pr1.getName_product()%></p>
									<p style="font-size: 12px">
										<b>Số lượng</b>: còn
										<%=pr1.getQuantity()%>
										sản phẩm
									</p>
									<a
										href="Cart_Controller?action=insert&ID_Product=<%=pr1.getId_product()%>"
										<%if (pr1.getQuantity() == 0) {%>
										style="pointer-events: none; background: #DDDDDD; color: white"
										<%} else {%> style=" pointer-events: auto;" <%}%>
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
								</div>
							</div>
							<img src="images/home/banchay.png" class="new" alt="" /> <img
								<%if (pr1.getQuantity() == 0) {%>
								style="display: block; position: absolute; top: 320px; right: 25px;"
								<%} else {%> style="display:none" <%}%> src="images/home/hf.jpg"
								class="proend" alt="" />
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href="detail.jsp?id_product=<%=pr1.getId_product()%>"><i
										class="fa fa-plus-square"></i>Xem chi tiết</a></li>
							</ul>
						</div>
					</div>
				</div>

				<%
					}
				%>
				<div style="clear: both"></div>




			</div>

			<ul class="pagination tim-kiem">
				<%
					int count1 = prdao.GetTotalProduct_ByCategory_Hot(id_category);
					int endpage1 = count1 / 8;
					if(count1 <= 8) endpage1 = 0; 
					else if (count1 / 8 != 0)
						endpage1++;

					for (int i = 1; i <= endpage1; i++) {
				%>
				<li><a class="tim-kiem"
					href="index_hot.jsp?id_category=<%=id_category%>&index1=<%=i%>"
					style="border: 1px solid black; color: white; font-weight: bold; background: #696763"><%=i%></a></li>
				<%
					}
				%>
			</ul>
			<div style="clear: both"></div>

		</div>




		<%--   			 ------------------------------------------------     --%>












		<%--   			 ------------------------------------------------     --%>


		<div class="features_items"
			<%if (request.getParameter("id_brand") != null) {%>
			style="display: block;" <%} else {%> style="display:none" <%}%>>
			<div class="category-tab tim-kiem">
				<!--category-tab-->
				<div class="col-sm-12 tim-kiem">
					<ul class="nav nav-tabs" style="margin-bottom: 5%;">
						<li class="active"><a href="index.jsp" >Tổng Hợp Sản Phẩm </a></li>

						<li class="active"
							style="border-right: 1px solid black; border-left: 1px solid black"><a
							href="index_sale.jsp"> Sản Phẩm Khuyến Mãi</a></li>

						<li class="active"><a href="index_hot.jsp" style="background: #696763; color: white"> Bán Chạy Nhất</a></li>

						<li class="active"><a href="index_foru.jsp"
							style="display: block; border-left:1px solid black;">
								Dành Riêng Cho Bạn</a></li>


					</ul>

				</div>
			</div>
			<!-- // danh sách sản phẩm -->
			<marquee width="96%" behavior="alternate" bgcolor="#fe980f"
				style="margin-left: 2%; margin-bottom: 3%; border: 2px solid black;background-color: rgb(195, 157, 90)">
				<h2 class="title1 text-center"
					style="color: black; font-size: 18px; text-transform: uppercase; width: 60%">
					Sản Phẩm
					<%=brand.getName_brand()%>
				</h2>
			</marquee>
			<br>
			<h2 class="title text-center">Danh Sách Sản Phẩm</h2>

			<div style="display: flex; flex-wrap: wrap;">

				<%
					for (Product pr2 : List_ProductByBrand_Hot) {
				%>

				<div class="col-sm-3 tim-kiem">
					<div class="product-image-wrapper" style="height: 422px">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="<%=pr2.getImage()%>" alt="" />
								<h2><%=currentLocale.format(pr2.getPrice() - pr2.getSale())%> VNĐ</h2>
								<h4 <%if (pr2.getSale() == 0) {%> style="color: white;"
									<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr2.getSale())%> VNĐ
								</h4>
								<p <%if (pr2.getSale() == 0) {%>
									style="font-weight: bold; min-height: 40px" <%%> <%} else {%>
									style="font-weight: bold; min-height:40px" <%}%>><%=pr2.getName_product()%></p>
								<p style="font-size: 12px">
									<b>Số lượng</b>: còn
									<%=pr2.getQuantity()%>
									sản phẩm
								</p>
								<a
									href="Cart_Controller?action=insert&ID_Product=<%=pr2.getId_product()%>"
									<%if (pr2.getQuantity() == 0) {%>
									style="pointer-events: none; background: #DDDDDD; color: white"
									<%} else {%> style=" pointer-events: auto;" <%}%>
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ Hàng</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<%-- <img src="<%=sp.getImage()%>" alt="" />
								<h2><%=nf.format(sp.getPrice())%>
									VNĐ
								</h2>
								<h4><%=nf.format(nh.getSale())%>
								VNĐ</h4>
								<p style="font-weight: bold"><%=sp.getName_Product()%></p> --%>
									<img src="<%=pr2.getImage()%>" alt="" />
									<h2>
										<%=currentLocale.format(pr2.getPrice() - pr2.getSale())%> VNĐ
									</h2>
									<h4 <%if (pr2.getSale() == 0) {%> style="color: #219AFC;"
										<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr2.getPrice())%> VNĐ
									</h4>
									<p <%if (pr2.getSale() == 0) {%> style="font-weight: bold;"
										<%} else {%> style="font-weight: bold;" <%}%>><%=pr2.getName_product()%></p>
									<p style="font-size: 12px">
										<b>Số lượng</b>: còn
										<%=pr2.getQuantity()%>
										sản phẩm
									</p>
									<a
										href="Cart_Controller?action=insert&ID_Product=<%=pr2.getId_product()%>"
										<%if (pr2.getQuantity() == 0) {%>
										style="pointer-events: none; background: #DDDDDD; color: white"
										<%} else {%> style=" pointer-events: auto;" <%}%>
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
								</div>
							</div>
							<img src="images/home/banchay.png" class="new" alt="" /> <img
								<%if (pr2.getQuantity() == 0) {%>
								style="display: block; position: absolute; top: 320px; right: 25px;"
								<%} else {%> style="display:none" <%}%> src="images/home/hf.jpg"
								class="proend" alt="" />
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href="detail.jsp?id_product=<%=pr2.getId_product()%>"><i
										class="fa fa-plus-square"></i>Xem chi tiết</a></li>
							</ul>
						</div>
					</div>
				</div>

				<%
					}
				%>
				<div style="clear: both"></div>




			</div>

			<ul class="pagination tim-kiem">
				<%
					int count2 = prdao.GetTotalProduct_ByBrand_Hot(id_brand);
					int endpage2 = count2 / 8;
					if(count<=8) endpage = 0; 
					else if (count2 / 8 != 0)
						endpage2++;

					for (int i = 1; i <= endpage2; i++) {
				%>
				<li><a class="tim-kiem"
					href="index_hot.jsp?id_brand=<%=id_brand%>&index2=<%=i%>"
					style="border: 1px solid black; color: white; font-weight: bold; background: #696763"><%=i%></a></li>
				<%
					}
				%>
			</ul>
			<div style="clear: both"></div>


		</div>



		<%--   			 ------------------------------------------------     --%>







		



		<div class="features_items"
			<%if (request.getParameter("id_season") != null) {%>
			style="display: block;" <%} else {%> style="display:none" <%}%>>
			<div class="category-tab tim-kiem">
				<!--category-tab-->
				<div class="col-sm-12 tim-kiem">
					<ul class="nav nav-tabs" style="margin-bottom: 5%;">
						<li class="active"><a href="index.jsp" >Tổng Hợp Sản Phẩm </a></li>

						<li class="active"
							style="border-right: 1px solid black; border-left: 1px solid black"><a
							href="index_sale.jsp"> Sản Phẩm Khuyến Mãi</a></li>

						<li class="active"><a href="index_hot.jsp" style="background: #696763; color: white"> Bán Chạy Nhất</a></li>

						<li class="active"><a href="index_foru.jsp"
							style="display: block; border-left:1px solid black;">
								Dành Riêng Cho Bạn</a></li>


					</ul>

				</div>
			</div>
			<!-- // danh sách sản phẩm -->
			<marquee width="96%" behavior="alternate" bgcolor="#fe980f"
				style="margin-left: 2%; margin-bottom: 3%; border: 2px solid black;background-color: rgb(195, 157, 90)">
				<h2 class="title1 text-center"
					style="color: black; font-size: 18px; text-transform: uppercase; width: 60%">
					Sản Phẩm
					<%=season.getName_Season()%>
					<%--(<%=dateStart %> - <%=dateEnd %> ) --%>

				</h2>
			</marquee>
			<br>
			<h2 class="title text-center">Danh Sách Sản Phẩm</h2>

			<div style="display: flex; flex-wrap: wrap;">

				<%
					for (Product pr3 : List_ProductBySeason_Hot) {
				%>

				<div class="col-sm-3 tim-kiem">
					<div class="product-image-wrapper" style="height: 422px">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="<%=pr3.getImage()%>" alt="" />
								<h2><%=currentLocale.format(pr3.getPrice() - pr3.getSale())%> VNĐ</h2>
								<h4 <%if (pr3.getSale() == 0) {%> style="color: white;"
									<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr3.getSale())%> VNĐ
								</h4>
								<p <%if (pr3.getSale() == 0) {%>
									style="font-weight: bold; min-height: 40px" <%%> <%} else {%>
									style="font-weight: bold; min-height:40px" <%}%>><%=pr3.getName_product()%></p>
								<p style="font-size: 12px">
									<b>Số lượng</b>: còn
									<%=pr3.getQuantity()%>
									sản phẩm
								</p>
								<a
									href="Cart_Controller?action=insert&ID_Product=<%=pr3.getId_product()%>"
									<%if (pr3.getQuantity() == 0) {%>
									style="pointer-events: none; background: #DDDDDD; color: white"
									<%} else {%> style=" pointer-events: auto;" <%}%>
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ Hàng</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<%-- <img src="<%=sp.getImage()%>" alt="" />
								<h2><%=nf.format(sp.getPrice())%>
									VNĐ
								</h2>
								<h4><%=nf.format(nh.getSale())%>
								VNĐ</h4>
								<p style="font-weight: bold"><%=sp.getName_Product()%></p> --%>
									<img src="<%=pr3.getImage()%>" alt="" />
									<h2>
										<%=currentLocale.format(pr3.getPrice() - pr3.getSale())%> VNĐ
									</h2>
									<h4 <%if (pr3.getSale() == 0) {%> style="color: #219AFC;"
										<%} else {%> style="display: block;" <%}%>><%=currentLocale.format(pr3.getPrice())%> VNĐ
									</h4>
									<p <%if (pr3.getSale() == 0) {%> style="font-weight: bold;"
										<%} else {%> style="font-weight: bold;" <%}%>><%=pr3.getName_product()%></p>
									<p style="font-size: 12px">
										<b>Số lượng</b>: còn
										<%=pr3.getQuantity()%>
										sản phẩm
									</p>
									<a
										href="Cart_Controller?action=insert&ID_Product=<%=pr3.getId_product()%>"
										<%if (pr3.getQuantity() == 0) {%>
										style="pointer-events: none; background: #DDDDDD; color: white"
										<%} else {%> style=" pointer-events: auto;" <%}%>
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
								</div>
							</div>
							<img src="images/home/banchay.png" class="new" alt="" /> <img
								<%if (pr3.getQuantity() == 0) {%>
								style="display: block; position: absolute; top: 320px; right: 25px;"
								<%} else {%> style="display:none" <%}%> src="images/home/hf.jpg"
								class="proend" alt="" />
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href="detail.jsp?id_product=<%=pr3.getId_product()%>"><i
										class="fa fa-plus-square"></i>Xem chi tiết</a></li>
							</ul>
						</div>
					</div>
				</div>

				<%
					}
				%>
				<div style="clear: both"></div>




			</div>

			<ul class="pagination tim-kiem">
				<%
					int count3 = prdao.GetTotalProduct_BySeason_Hot(id_season);
					int endpage3 = count3 / 8;
					if(count<=8) endpage = 0; 
					if (count3 / 8 != 0)
						endpage3++;

					for (int i = 1; i <= endpage3; i++) {
				%>
				<li><a class="tim-kiem"
					href="index_hot.jsp?id_season=<%=id_season%>&index3=<%=i%>"
					style="border: 1px solid black; color: white; font-weight: bold; background: #696763"><%=i%></a></li>
				<%
					}
				%>
			</ul>
			<div style="clear: both"></div>


		</div>


	</div>
</body>
</html>