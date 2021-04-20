 
<%@page import="java.text.NumberFormat"%>
<%@page import="Dao.InvoiceDao_Impl"%>
<%@page import="Dao.InvoiceDao"%>
<%@page import="Model.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Account"%>
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
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>

</head>
<body>

<%

Account acc = new Account();
if (session.getAttribute("SessionUsername") != null)
	acc = (Account) session.getAttribute("SessionUsername");

InvoiceDao invoicedao = new InvoiceDao_Impl();
ArrayList<Invoice> arr = new ArrayList<Invoice>();
arr = invoicedao.GetListInvoice1(acc.getId_account());
NumberFormat nf = NumberFormat.getInstance();


%>

<div class="hidden-profile">
<jsp:include page="header.jsp"></jsp:include>
</div>
	
	
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2 style="text-align:center;text-transform: uppercase">Xem Chi tiết đơn hàng</h2>
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
							<div class="panel-heading" style="background:rgb(195, 157, 90); text-align:center; color:#000; font-weight:bold">LỊCH SỬ ĐƠN HÀNG</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr style="text-align: center;">
												<th style="text-align: center">Mã Hóa Đơn</th>
												<!-- <th>Khách Hàng</th>
												<th>Số điện thoại</th> -->
												<th style="text-align: center">Địa Chỉ Giao Hàng</th>
												<th style="text-align: center">Phương Thức Thanh Toán</th>
												<th style="text-align: center">Tổng tiền hóa đơn</th>
												<th style="text-align: center">Ngày Mua Hàng</th>
												<th style="text-align: center">Giao Hàng Dự Kiến</th>
												<th style="text-align: center">Trạng Thái</th>
												<th style="text-align: center">Chức năng</th>
												<!-- <th>Chức Năng</th> -->
												<th>Chi Tiết</th>
												
											</tr>
										</thead>

									
										<tbody>
										<%for(Invoice i: arr){ %>
										
											<tr class="odd gradeX">
												<td style="text-align: center"><%=i.getID_Invoice() %></td>
												<td style="text-align: center"><%=i.getShipping_Address() %></td>
												<td style="text-align: center"><%=i.getPayment_Method() %></td>
												<td style="text-align: center"><%=nf.format(i.getTotal()) %> VNĐ</td>
												<td style="text-align: center"><%=i.getTime_Dathang() %></td>
												<td style="text-align: center"><%=i.getTime_Giaohang_Dukien()%></td>
												
												
												
												<td class="center" style="text-align: center;">
												<%if(i.getStatus()==1){ %>
												<a class="btn btn-success btn-xs" style="background-color: #b85cad">Chờ Xử Lý</a>
												<%} %>		
												<%if(i.getStatus()==2){ %>
												<a class="btn btn-success btn-xs" style="background-color: #8a6d3b" >Đang Giao</a>
												<%} %>							
												</td>
												
											
												
												<%---------------------------------------------- --%>
												<td class="center" style="text-align: center;">
												
												<a href="InvoiceHistory?action=Cancel&ID_Invoice=<%=i.getID_Invoice() %>"  onclick="return confirm('Bạn có muốn hủy đơn hàng này không ?')"
												<%if(i.getStatus()==1){ %>											
											 style=" pointer-events: auto; margin-top: 0px"<%} else{ %>
											 style=" display: none; <%} %>
											 
												
													class="btn btn-primary  btn-xs" style="background:red; " >Hủy đơn hàng</a>
																				
												
												</td>
												
													</td>
												 <td class="center" style="text-align: center;">
												
												<a href="InvoiceHistory?action=View&ID_Invoice=<%=i.getID_Invoice() %>"
													class="btn btn-warning btn-xs">Xem</a></td>
											</tr>
											
										<%} %>
										</tbody>

									</table>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/dataTables/jquery.dataTables.js"></script>
	<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		/* 	$('#dataTables-example3_filter').css('display','none'); */
			
		});
	</script>
	<script src="assets/js/custom.js"></script>
</body>
</html>