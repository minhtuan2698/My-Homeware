
<%@page import="Dao.AccountDao_Impl"%>
<%@page import="Dao.AccountDao"%>
<%@page import="Model.Account"%>
<%@page import="Model.Star_Rating"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Dao.Star_RatingDao_Impl"%>
<%@page import="Dao.Star_RatingDao"%>
<%@page import="Controller.StarRating"%>
<%@page import="Model.Brand"%>
<%@page import="Dao.BrandDao_Impl"%>
<%@page import="Dao.BrandDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Dao.ProductDao_Impl"%>
<%@page import="Dao.ProductDao"%>
<%@page import="Model.Product"%>
<%@page import="Model.Detail_Image"%>
<%@page import="Dao.Detail_ImageDao_Impl"%>
<%@page import="Dao.Detail_ImageDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Chi Tiết Sản Phẩm | TS-Homeware</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/rating2.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/imagezoom.js"></script>

</head>
<body>

	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.10&appId=327890844754184";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<% 
	
	
		NumberFormat nf = NumberFormat.getInstance();

		Detail_ImageDao imagedao = new Detail_ImageDao_Impl();
		ProductDao prdao = new ProductDao_Impl();
		BrandDao branddao = new BrandDao_Impl();
		

		int id_product = Integer.parseInt(request.getParameter("id_product"));

		Detail_Image image = imagedao.GetImage(id_product);

		Product pr = prdao.GetProduct(id_product);
		Brand brand = branddao.GetName_Brand(pr.getBrand().getId_brand());
		
		Star_RatingDao ratedao = new Star_RatingDao_Impl();
		
		AccountDao accdao = new AccountDao_Impl();
		
		ArrayList<Star_Rating> arr = ratedao.GetListRate(id_product);
		
		
		
		DecimalFormat df = new DecimalFormat("#.#");
		
		float avg = Float.parseFloat(df.format(ratedao.Avg_Full(id_product)));
		
		int sumfull = ratedao.Sum_Full(id_product);
		
		float rate5 = ratedao.Count_Star(5, id_product);
		float score5 = 0;
		if(sumfull!=0) {
		 	score5 = (rate5/sumfull)*100;
		}
		
		float rate4 = ratedao.Count_Star(4, id_product);
		float score4 = 0;
		if(sumfull!=0) {
		 	score4 = (rate4/sumfull)*100;
		}
		
		float rate3 = ratedao.Count_Star(3, id_product);
		float score3 = 0;
		if(sumfull!=0) {
		 	score3 = (rate3/sumfull)*100;
		}
		float rate2 = ratedao.Count_Star(2, id_product);
		float score2 = 0;
		if(sumfull!=0) {
		 	score2= (rate2/sumfull)*100;
		}
		float rate1 = ratedao.Count_Star(1, id_product);
		float score1 = 0;
		if(sumfull!=0) {
		 	score1 = (rate1/sumfull)*100;
		}
		
	
		
		
		
		System.out.println(score5);
		System.out.println(score4);
		System.out.println(score3);
		System.out.println(score2);
		System.out.println(score1);
		
		String length5 = score5 + "%"; 
		String length4 = score4 + "%";
		String length3 = score3 + "%";
		String length2 = score2 + "%";
		String length1 = score1 + "%";
		
		String a = "fa fa-star";
		
		if(0<=avg&&avg<=0.2) a = a+"-o";
		else if(0.2<avg&&avg<=0.7) a= a+"-half-o";
		
		String b = "fa fa-star";
		
		if(0.7<avg&&avg<=1.2||avg<1.2) b = b+"-o";
		else if(1.2<avg&&avg<=1.7) b= b+"-half-o";
		
		String c = "fa fa-star";
		
		if(1.7<avg&&avg<=2.2||avg<2.2) c = c+"-o";
		else if(2.2<avg&&avg<=2.7) c= c+"-half-o";
		
		String d = "fa fa-star";
		
		if(2.7<avg&&avg<=3.2||avg<3.2) d = d+"-o";
		else if(3.2<avg&&avg<=3.7) d= d+"-half-o";
		
		String e = "fa fa-star";
		
		if(3.7<avg&&avg<=4.2||avg<4.2) e = e+"-o";
		else if(4.2<avg&&avg<=4.7) e= e+"-half-o";
		
		
		
	%>


	<jsp:include page="header.jsp"></jsp:include>
	<section>
	<div class="container">
		<div class="row">
			<jsp:include page="category.jsp"></jsp:include>
			<div class="col-sm-9 padding-right">
				<div class="product-details">
					<div class="col-sm-5">
						<div class="view-product">
							<img src="<%=pr.getImage()%>" data-imagezoom="true" alt="" />
						</div>
						<br> <span class="view-product"> <img
							style="height: 30%; width: 30%" src=" <%=image.getImage1()%>"
							data-imagezoom="true" data-magnification="5" alt="" />
						</span> <span class="view-product"> <img
							style="height: 30%; width: 30%; margin-left: 3%"
							src=" <%=image.getImage3()%>" data-imagezoom="true"
							data-magnification="5" alt="" />
						</span> <span class="view-product"> <img
							style="height: 30%; width: 30%; margin-left: 3%"
							src=" <%=image.getImage2()%>" data-imagezoom="true"
							data-magnification="5" alt="" />
						</span>

					</div>

					<div class="col-sm-7">
						<div class="product-information">
							<img src="images/product-details/new.jpg" class="newarrival"
								alt="" /> <img <%if (pr.getQuantity() == 0) {%>
								style="display: block; position: absolute; top: 0; left: 0;"
								<%} else {%> style="display:none" <%}%> src="images/home/hf.jpg"
								class="proend" alt="" />

							<h2><%=pr.getName_product()%></h2>

							<p>
								Mã Sản Phẩm:
								<%=pr.getId_product()%>
							</p>

							<img src="images/product-details/rating.png" alt="" /> </br> <span>
								<span <%if (pr.getSale() == 0) {%> style="color: white;"
								<%} else {%>
								style="display: block;color: #FE980F; font-family: 'Roboto', sans-serif;font-size: 18px;font-weight: 700; text-decoration: line-through;"
								<%}%>><%=nf.format(pr.getPrice())%> VNĐ</span> <br> <span><%=nf.format(pr.getPrice() - pr.getSale())%>
									VNĐ</span> <!-- <label>Số Lượng:</label> <input type="text" value="Nhập" /> -->

							</span>


							<p>
								<a
									href="Cart_Controller?action=insert&ID_Product=<%=pr.getId_product()%>"
									type="button" <%if (pr.getQuantity() == 0) {%>
									style="pointer-events: none; background: #DDDDDD" <%} else {%>
									style=" pointer-events: auto;" <%}%>
									class="btn btn-fefault cart"> <i
									class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>
							</p>
							</br>

							<p></p>
							<p>
								<b>Số lượng</b>: còn
								<%=pr.getQuantity()%>
								sản phẩm
							</p>
							<%-- <p>
								<b>Giảm giá: </b><%=sp.getSale()%>
								VNĐ
							</p> --%>
							<p>
								<b>Nhãn Hiệu:</b>
								<%=brand.getName_brand()%>
							</p>
							<p>
								<b>Mô tả sản phẩm:</b>
								<%=pr.getDescribe()%>
							</p>
							<div class="fb-like"
								data-href="https://www.facebook.com/hop.spirit"
								data-layout="standard" data-action="like" data-size="small"
								data-show-faces="true" data-share="true"></div>
						</div>
					</div>
				</div>

				<div class="category-tab shop-details-tab"
					style="padding-left: 50px; padding-top: 30px" >
					<p style="font-size: 25px; font-weight: bold">Đánh giá sản phẩm</p>

					<div>


						<h3 class="heading">Reviews</h3>
						<div class="review-rating" style="padding-bottom: 50px">
							<div class="left-review">
								<div class="review-title"><%=df.format(ratedao.Avg_Full(id_product)) %></div>
								<div class="review-star">
									<span class="<%=a%>"></span> 
									<span class="<%=b%>"></span>
									<span class="<%=c%>"></span> 
									<span class="<%=d%>"></span> 
									<span class="<%=e%>"></span>
								</div>
								<div class="review-people">
									<i class="fa fa-user"></i> <%=ratedao.Count_Distinct(id_product) %> total
								</div>
							</div>
							<div class="right-review">
								<div class="row-bar">
									<div class="left-bar">5</div>
									<div class="right-bar">
										<div class="bar-container">
											<div class="bar-5" style="width: <%=score5%>% "></div>
										</div>
									</div>
								</div>
								<div class="row-bar">
									<div class="left-bar">4</div>
									<div class="right-bar">
										<div class="bar-container">
											<div class="bar-4" style="width: <%=score4%>% "></div>
										</div>
									</div>
								</div>
								<div class="row-bar">
									<div class="left-bar">3</div>
									<div class="right-bar">
										<div class="bar-container">
											<div class="bar-3" style="width: <%=score3%>% "></div>
										</div>
									</div>
								</div>
								<div class="row-bar">
									<div class="left-bar">2</div>
									<div class="right-bar">
										<div class="bar-container">
											<div class="bar-2" style="width: <%=score2%>% "></div>
										</div>
									</div>
								</div>
								<div class="row-bar">
									<div class="left-bar">1</div>
									<div class="right-bar">
										<div class="bar-container">
											<div class="bar-1" style="width: <%=score1%>% "></div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div>
						<%for(Star_Rating i : arr){ %>
					
						<%
						float ratex = i.getStar();
						String f = "fa fa-star";
						if(ratex<1) f+="-o";
						String g = "fa fa-star";
						if(ratex<2) g+="-o";
						String h = "fa fa-star";
						if(ratex<3) h+="-o";
						String j = "fa fa-star";
						if(ratex<4) j+="-o";
						String k = "fa fa-star";
						if(ratex<5) k+="-o";
						
						
						%>
							<div style="border-bottom:1px solid #b1422b ; padding: 5px 5px 3px">
								<p style="font-size: 20px; font-weight: bold"><%=accdao.GetAccount(i.getAccount().getId_account()).getUsername() %></p>
								<div class="review-star">
									<span class="<%=f%>"></span> 
									<span class="<%=g%>"></span>
									<span class="<%=h%>"></span> 
									<span class="<%=j%>"></span> 
									<span class="<%=k%>"></span>
								</div>
								<p><%=i.getComment() %></p>
							</div>
							<%} %>


						</div>


					</div>



				</div>

				<div class="tab-pane fade active in" id="reviews">
					<div class="col-sm-12">

						<div class="fb-comments"
							data-href="detail.jsp?msp<%=pr.getId_product()%>"
							data-width="800px" data-numposts="5"></div>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>