
<%@page import="java.util.HashMap"%>
<%@page import="Dao.Star_RatingDao_Impl"%>
<%@page import="Dao.Star_RatingDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Model.Product"%>
<%@page import="Dao.ProductDao_Impl"%>
<%@page import="Dao.ProductDao"%>
<%@page import="Dao.InvoiceDetailDao_Impl"%>
<%@page import="Dao.InvoiceDetailDao"%>
<%@page import="Model.InvoiceDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem chi tiết đơn hàng | TS-Homeware</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">
<link href="css/Rating.css" rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>

</head>
<body>

	<script>
		$(document).ready(function() {
			$('a.login-window').click(function() {
				//lấy giá trị thuộc tính href - chính là phần tử "#login-box"
				var loginBox = $(this).attr('href');

				//cho hiện hộp đăng nhập trong 300ms
				$(loginBox).fadeIn(300);

				// thêm phần tử id="over" vào sau body
				$('body').append('<div id="over">');
				$('#over').fadeIn(300);

				return false;
			});

			// khi click đóng hộp thoại
			$(document).on('click', "a.close, #over", function() {
				$('#over, .rate').fadeOut(300, function() {
					$('#over').remove();
				});
				return false;
			});
		});
	</script>


	<%
		ProductDao prdao = new ProductDao_Impl();

		String ID_Invoice = "";
		if (request.getParameter("ID_Invoice") != null)
			ID_Invoice = request.getParameter("ID_Invoice");
		ArrayList<InvoiceDetail> arr = new ArrayList<InvoiceDetail>();
		InvoiceDetailDao dao = new InvoiceDetailDao_Impl();
		arr = dao.GetList_InvoiceDetail(ID_Invoice);

		NumberFormat nf = NumberFormat.getInstance();
		
		String success = "";
		if(request.getAttribute("success")!=null)
				success = (String) request.getAttribute("success");
		
		Star_RatingDao ratedao = new Star_RatingDao_Impl();
		
	%>


	<div class="hidden-profile">
		<jsp:include page="header.jsp"></jsp:include>
	</div>


	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2 style="text-align: center; text-transform: uppercase">Chi
							tiết lịch sử đơn hàng</h2>
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".sidebar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-md-12">

						<div class="panel panel-default">
							<div class="panel-heading"
								style="background: rgb(195, 157, 90); color: #000; text-align: center; font-weight: bold">THÔNG
								TIN CHI TIẾT ĐƠN HÀNG</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr style="text-align: left;">
												<th style="text-align: center;">Hóa Đơn Chi Tiết</th>
												<th style="text-align: center;">Mã Hóa Đơn</th>
												<th style="text-align: center;">Sản Phẩm</th>
												<th style="text-align: center;">Số Lượng</th>
												<th style="text-align: center;">Giá Sản Phẩm</th>
												<th style="text-align: center;">Giảm Giá</th>
												<th style="text-align: center;">Tổng Tiền</th>
												<th style="text-align: center;">Đánh giá</th>
												<!-- <th>Chức Năng</th> -->
											</tr>
										</thead>


										<tbody>
											<%
												for (InvoiceDetail i : arr) {
													int id = Integer.parseInt(i.getProduct().getId_product());
													Product pr = prdao.GetProduct(id);
													
													HashMap<String, String> map = new HashMap<>();
													
													
											%>
											<tr class="odd gradeX" style="text-align: center;">
												<td><%=i.getID_InvoiceDetail()%></td>
												<td><%=i.getInvoice().getID_Invoice()%></td>
												<td><a style="color: #000"
													href="detail.jsp?id_product=<%=i.getProduct().getId_product()%>"><%=pr.getName_product()%></a></td>
												<td><%=i.getQuantity()%></td>
												<td><%=nf.format(i.getPrice())%> VNĐ</td>
												<td><%=nf.format(i.getSale())%> VNĐ</td>
												<td><%=nf.format(i.getTotal())%> VNĐ</td>
												
												<td class="center" <%if(!ratedao.Checkrate(i.getID_InvoiceDetail())){ %> style=" display: block; text-align: center;"<%} else if(ratedao.Checkrate(i.getID_InvoiceDetail())){ %>style=" display: none;"<%} %>><a
													class="login-window button"
													class="btn btn-warning btn-xs"
													style="background-color: #9c5151" href="#Star_rating" >Đánh giá</a></td>											
													<form action="StarRating" method="post">
													

												<div class=" rate" id="Star_rating"
													style="width: 500px; height: 400px ">
													<div>

														<div class="stars"
															style="padding-right: 120px; margin-top: 25px">
															<input type="hidden" name="idpr"
																value="<%=i.getProduct().getId_product()%>"> 
															<input type="hidden" name="idinv"
																value="<%=ID_Invoice%>">	
																<input type="hidden" name="idinvoicedetail"
																value="<%=i.getID_InvoiceDetail()%>">	
																<input
																type="radio" id="five" name="rate" value="5"> <label
																for="five"></label> <input type="radio" id="four"
																name="rate" value="4"> <label for="four"></label>
															<input type="radio" id="three" name="rate" value="3">
															<label for="three"></label> <input type="radio" id="two"
																name="rate" value="2"> <label for="two"></label>
															<input type="radio" id="one" name="rate" value="1">
															<label for="one"></label> <span class="result"></span>
														</div>
													</div>


													<div>

														<textarea
															placeholder="Hãy chia sẻ cảm nhận của bạn về sản phẩm !  "
															style="margin-left: 50px; margin-bottom: 20px; margin-top: 90px; width: 400px; height: 135px;"
															name="comment" id="" cols="30" rows="10"></textarea>

													</div>
													<div style="padding: 0px 200px">
														<button type="submit"
															style="padding: 10px; background: #905757; color: white;">Đánh
															giá</button>
													</div>



												</div>
											</form>

											</tr>

											
											<%
												}
											%>
										</tbody>

									</table>
								</div>
							</div>
						</div>


					</div>
				</div>
				<p style="text-align: center; font-size: 20px; color: #a94442; padding-bottom: 25px;"><%=success %></p>
				<div
					style="text-align: center; margin-bottom: 10%; font-weight: bold">
					<a href="InvoiceHistory.jsp"
						style="background: #FE980F; padding: 10px 20px; color: white; font-weight: bold; border-radius: 10px">Quay
						lại</a>
				</div>
				
			</div>

		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function openFormEvaluate(i) {
		console.log('da goi vao day, ', i);
	}
</script>
</html>