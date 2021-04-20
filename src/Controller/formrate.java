package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formrate
 */
@WebServlet("/formrate")
public class formrate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formrate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
;
        String b = "aloo";
        String a = "    <form action=\"StarRating\" method=\"post\">\r\n" + 
        		"													\r\n" + 
        		"\r\n" + 
        		"												<div class=\" rate\" id=\"Star_rating\"\r\n" + 
        		"													style=\"width: 500px; height: 400px \">\r\n" + 
        		"													<div>\r\n" + 
        		"\r\n" + 
        		"														<div class=\"stars\"\r\n" + 
        		"															style=\"padding-right: 120px; margin-top: 25px\">\r\n" + 
        		"															<input type=\"hidden\" name=\"idpr\"\r\n" + 
        		"																value=\"<%=i.getProduct().getId_product()%>\"> \r\n" + 
        		"															<input type=\"hidden\" name=\"idinv\"\r\n" + 
        		"																value=\"<%=ID_Invoice%>\">	\r\n" + 
        		"																<input type=\"hidden\" name=\"idinvoicedetail\"\r\n" + 
        		"																value=\"<%=i.getID_InvoiceDetail()%>\">	\r\n" + 
        		"																<input\r\n" + 
        		"																type=\"radio\" id=\"five\" name=\"rate\" value=\"5\"> <label\r\n" + 
        		"																for=\"five\"></label> <input type=\"radio\" id=\"four\"\r\n" + 
        		"																name=\"rate\" value=\"4\"> <label for=\"four\"></label>\r\n" + 
        		"															<input type=\"radio\" id=\"three\" name=\"rate\" value=\"3\">\r\n" + 
        		"															<label for=\"three\"></label> <input type=\"radio\" id=\"two\"\r\n" + 
        		"																name=\"rate\" value=\"2\"> <label for=\"two\"></label>\r\n" + 
        		"															<input type=\"radio\" id=\"one\" name=\"rate\" value=\"1\">\r\n" + 
        		"															<label for=\"one\"></label> <span class=\"result\"></span>\r\n" + 
        		"														</div>\r\n" + 
        		"													</div>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"													<div>\r\n" + 
        		"\r\n" + 
        		"														<textarea\r\n" + 
        		"															placeholder=\"Hãy chia sẻ cảm nhận của bạn về sản phẩm !  \"\r\n" + 
        		"															style=\"margin-left: 50px; margin-bottom: 20px; margin-top: 90px; width: 400px; height: 135px;\"\r\n" + 
        		"															name=\"comment\" id=\"\" cols=\"30\" rows=\"10\"></textarea>\r\n" + 
        		"\r\n" + 
        		"													</div>\r\n" + 
        		"													<div style=\"padding: 0px 200px\">\r\n" + 
        		"														<button type=\"submit\"\r\n" + 
        		"															style=\"padding: 10px; background: #905757; color: white;\">Đánh\r\n" + 
        		"															giá</button>\r\n" + 
        		"													</div>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"												</div>\r\n" + 
        		"											</form>    ";
        
        request.setAttribute("a", b);
        
    	RequestDispatcher rq = request.getRequestDispatcher("historyDetail.jsp");
		rq.forward(request, response);
			
        
        
 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
