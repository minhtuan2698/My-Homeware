
<%@page import="Dao.BrandDao"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="Dao.SeasonDao_Impl"%>
<%@page import="Dao.SeasonDao"%>
<%@page import="Model.Season"%>
<%@page import="Model.Brand"%>
<%@page import="Dao.BrandDao_Impl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Category"%>
<%@page import="Dao.CategoryDao_Impl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Thể Loại | TS-Homeware</title>
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
		CategoryDao catedao = new CategoryDao_Impl();
		BrandDao branddao = new BrandDao_Impl();
		SeasonDao seasondao = new SeasonDao_Impl();
		
		
		
	%>


	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>DANH MỤC</h2>
			<div class="panel-group category-products" id="accordian">
				<%
					for (Category cate_parent : catedao.Getlist_ParentCategory()) {
				%>

				<div class="panel panel-default">
					<div class="panel-heading" >
						<%
							for (Category cate_child : catedao.GetList_ChildCategory(cate_parent.getId_category())) {
						%>




						<%-- <%=Parent_Category.getName_Category()%> --%>

					</div>
					<div class="panel-body">

						<ul >
							<li ><a
								href="index_hot.jsp?id_category=<%=cate_child.getId_category()%>&index1=1"><%=cate_child.getName_category()%></a></li>

						</ul>
						<%
							}
						%>
					</div>
				</div>

				<%
					}
				%>


			</div>


			<h2>NHÃN HIỆU</h2>
			<div class="panel-group category-products" id="accordian1">

				<%
					for (Brand brand_parent : branddao.getlist_ParentBrand()) {
				%>
				<div class="panel panel-default">
					<div class="panel-heading">

						<%
							for (Brand brand_child : branddao.getlist_ChildBrand(brand_parent.getId_brand())) {
						%>

					</div>

					<div class="panel-body">

						<ul>
							<li><a
								href="index_hot.jsp?id_brand=<%=brand_child.getId_brand()%>&index2=1"><%=brand_child.getName_brand()%></a></li>
							<%
								}
							%>
						</ul>

					</div>

				</div>
				<%
					}
				%>


			</div>

			<h2>Season</h2>
			<div class="panel-group category-products" id="accordian1">


				<div class="panel panel-default">
					<div class="panel-heading"></div>
					<%
						for (Season season : seasondao.GetSeason()) {
					%>


					<div class="panel-body">

						<ul>
							<li><a
								href="index_hot.jsp?id_season=<%=season.getID_Season()%>&index3=1"><%=season.getName_Season()%></a></li>

						</ul>

					</div>
					<%
						}
					%>

				</div>



			</div>




			<div class="price-range">
				<!--price-range-->
				<h2>Khoảng Giá</h2>
				<div class="well text-center">
				<select class="span2">
					<option>Dưới 10.000 Đ</option>
					<option>Danh sách 2 </option>
					</select>
				
				

				</div>
			</div>
			<!--/price-range-->

			<div class="shipping text-center">
				<h2 style="margin-top: 10px">Quảng Cáo</h2>

				<img style="margin-top: 2%" src="images/home/gioithieu4.jpg" alt="" />
				<!-- <img src="images/home/gioithieu1.jpg" alt="" />
				<img src="images/home/gioithieu3.jpg" alt="" />
				<img src="images/home/gioithieu.jpg" alt="" /> -->


			</div>

		</div>
		<div style="clear: both;"></div>
	</div>

</body>
</html>