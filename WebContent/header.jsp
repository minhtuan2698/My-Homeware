<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Cart"%>
<%@page import="Dao.CategoryDao_Impl"%>
<%@page import="Dao.CategoryDao"%>

<%@page import="Model.Account"%>
<%@page import="Model.Category"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | T-Homeware</title>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.3&appId=327890844754184&autoLogAppEvents=1"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css"
	integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
	crossorigin="anonymous">
<link rel="stylesheet" href="../Css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.dropbtn {
	font-size: 14px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: rgba(0, 0, 0, 0.6);;
	min-width: 100px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	padding: 16px 20px;
	text-decoration: none;
	display: block;
	margin-left: 5px;
}

.navbar-nav .log .dropdown-content a:hover {
	color: #FE980F;
}

.dropdown-content li a:hover {
	background-color: red;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropdown-content ul li:hover a {
	color: red;
}
</style>
</head>
<!-- <script>
$(document).ready(function(){
	  $("#btnSearchIndex").click(function(){
	    var value = $("#textSearchIndex").val().toLowerCase();
	    $(".tim-kiem").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	</script> -->


<script>
	$(document)
			.ready(
					function() {
						$("#btnSearch")
								.click(
										function() {
											var flag = 0;
											/*  alert("fsdfds"); */
											var textSearch = $("#text-Search")
													.val()
											/* alert(textSearch);  */
											if (textSearch.trim() == '') {
												$("#err11")
														.html(
																"M???i b???n nh???p t??? kh??a!")
												flag = 1
											}
											if (flag == 0) {
												$
														.ajax({
															type : "post",
															url : "/homeware/searchServlet",
															data : {
																textSearch : textSearch
															},
															success : function(
																	response) {

																window.location.href = "http://localhost:8080/homeware/index10.jsp"

															}
														});
											}
										})

					})
</script>
<body>

	<%
		CategoryDao catedao = new CategoryDao_Impl();

		Cart cart = (Cart) session.getAttribute("cart");
		int SizeCart = 0;
		if (cart != null)
			SizeCart = cart.countItem();

		Account user = (Account) session.getAttribute("SessionUsername");
		
		String username = "";
		if (user != null) {
			username = user.getUsername();
		} else {
			username = "";
		}
		
		
		
		
	%>


	<script type="text/javascript">
		function clock() {
			var date = new Date();
			var gio = date.getHours();
			var phut = date.getMinutes();
			var giay = date.getSeconds();
			var a = "";

			if (gio < 10)
				gio = "0" + gio;
			
			if (phut < 10)
				pghut = "0" + phut;
			if (giay < 10)
				giay = "0" + giay;
			

			var ngay = [ "Ch??? nh???t", "Th??? 2", "Th??? 3", "Th??? 4", "Th??? 5",
					"Th??? 6", "Th??? 7" ];
			var thang = [ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12" ];
			var timee = gio + ":" + phut + ":" + giay + " " + a + ",  "
					+ ngay[date.getDay()] + " Ng??y " + date.getDate()
					+ " Th??ng " + thang[date.getMonth()] + " N??m "
					+ date.getFullYear();
			document.getElementById('time').innerHTML = timee;
			setTimeout("clock()", 1000);
		}
	</script>


	<header id="header">


	<div class="header_top">
		<!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6" style="width: 70%">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href="#"><i class="fa fa-phone"></i> 0963526004</a></li>
							<li><a href="#"><i class="fa fa-envelope"></i>
									nguyentuan2698@gmail.com</a></li>
							<li style="padding-left: 100px"> <p id="time" style="font-size: 12px; padding: 10px 15px; color: white; margin: 0px" ></p> </li>
	

						</ul>
					</div>
				</div>
				<div class="col-sm-6" style="float: right; width: 30%">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a target="_blank"
								href="https://www.facebook.com/hop.spirit" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a target="_blank"
								href="https://www.youtube.com/channel/UCrG7w-hCIQO0n07tJj9TnRQ?view_as=subscriber"
								title="Youtube"><i class="fa fa-youtube-play"></i></a></li>
							<li><a target="_blank"
								href="https://myaccount.google.com/?utm_source=OGB&tab=wk&utm_medium=act"
								title="Google"><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="header-middle">
		<div class="container" style="width: 1250px">
			<div class="row">
				<div class="col-sm-2">
					<div class="logo pull-left">
						<a href="index.jsp"><img src="images/home/mylogo.png" alt="" /></a>
					</div>
				</div>
				<div class="col-sm-2">



					<!-- <input type="text" id= "textSearchIndex" class="form-control" style="width:120%; border-radius:15px; border:2px solid #219AFC; padding:18px 15px;position:relative" type="text" placeholder="Search">
    <div id="btnSearchIndex" class="icon"><i class="fas fa-search" style="position: absolute; top: 30%; right: 0%"></i></div>  -->
					<input type="text" id="text-Search" class="form-control"
						style="width: 120%; border-radius: 15px; border: 2px solid #219AFC; padding: 18px 15px; position: relative"
						type="text" placeholder="T??m ki???m...">
					<div id="btnSearch" class="icon">
						<i class="fas fa-search"
							style="position: absolute; top: 30%; right: 0%"></i>
					</div>
					<span id="err11" style="color: white"></span>
					<!-- <div class="search-h">
                        <input type="text" id="text-Search" placeholder="T??m ki???m...">
                        <button id="btnSearch"><i class="fas fa-search"></i></button>
                    </div>   -->
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">

							<li><a <%if (user != null) {%> style="display: block;"
								<%} else {%> style="display:none" <%}%>><i
									class="fa fa-user"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									Hi, <%=username%></a>

								<ul role="menu" class="sub-menu" <%if (user == null) {%>
									style="display: none" <%}%>>
									<li><a href="profile.jsp">Th??ng tin t??i kho???n</a></li>
									<li><a href="InvoiceDetail.jsp">Xem chi ti???t ????n h??ng</a></li>
									<li><a href="InvoiceHistory.jsp">Xem l???ch s??? ????n h??ng</a></li>
									<li><a href="CheckBH.jsp">B???o h??nh s???n ph???m</a></li>
									<li><a href="Login_Controller?enter=logout">????ng xu???t</a></li>

								</ul></li>
							<li class="dropdown log"><a class="dropbtn"
								<%if (user != null) {%> style="display: none;" <%} else {%>
								style="display:block" <%}%>><i class="fa fa-user"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									T??i Kho???n<i class="fa fa-angle-down"></i></a>
								<ul role="menu" class="dropdown-content sub-menu1">
									<li><a href="account.jsp"
										style="color: white; font-size: 14px"><i
											class="fa fa-lock"></i> ????ng nh???p </a></li>
									<li><a href="register.jsp"
										style="color: white; font-size: 14px; padding-bottom: 10px;"><i
											class="fa fa-lock"></i> ????ng k??</a></li>

								</ul></li>



							<%
								for (Category cate_parent : catedao.Getlist_ParentCategory()) {
							%>
							<li><a href="#"><i class="fa fa-star"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									Danh S??ch<i class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<%
										for (Category cate_child : catedao.GetList_ChildCategory(cate_parent.getId_category())) {
									%>
									<li id="mmm"><a
										href="index.jsp?ID_Category=<%=cate_child.getId_category()%>&index=1"><%=cate_child.getName_category()%></a></li>
									<%
										}
									%>
								</ul></li>
							<%
								}
							%>
							<li class="baohanh-header"><a href="BaoHanh.jsp"><i
									class="fas fa-toolbox"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									B???o H??nh </a></li>
							<li><a href="checkout.jsp"><i class="fa fa-crosshairs"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									Thanh To??n</a></li>

							<li><a href="cart.jsp"><i class="fa fa-shopping-cart"
									style="height: 20px; padding: 1px 6px; border: 2px solid black; border-radius: 10px"></i>
									Gi??? H??ng <span
									style="color: red; height: 20px; padding: 1px 6px; background: white; border-radius: 10px; boder: 2px solid red">
										<%=SizeCart%></span></a></li>



							<%-- <li class="dn"><a href="account.jsp" <%if(user!=null){%> style="display:none; " <%}
                        else{ %> style="display:block"<%} %>><i class="fa fa-lock"></i>
									????ng Nh???p </a></li>
							<li class="dk"><a href="register.jsp" <%if(user!=null){%> style="display:none; " <%}
                        else{ %> style="display:block"<%} %>><i class="fa fa-lock"></i>
									????ng K??</a></li> --%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only"> Chuy???n ?????i ??i???u h?????ng</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>

					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="index.jsp" class="active">Trang ch???</a></li>

							<%
								for (Category cate_parent : catedao.Getlist_ParentCategory()) {
							%>

							<li class="dropdown"><a href="#"> C??c lo???i ????? gia d???ng <i
									class="fa fa-angle-down"></i></a>

								<ul role="menu" class="sub-menu">
									<%
										for (Category cate_child : catedao.GetList_ChildCategory(cate_parent.getId_category())) {
									%>
									<li><a
										href="index.jsp?id_category=<%=cate_child.getId_category()%>&index=1"><%=cate_child.getName_category()%></a></li>
									<%
										}
									%>
								</ul></li>

							<%
								}
							%>
							<li><a href="contact.jsp">Li??n h???</a></li>
						</ul>
					</div>


				</div>

			</div>
		</div>
	</div>

	</header>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
	<script>
		clock();
	</script>
</body>
</html>