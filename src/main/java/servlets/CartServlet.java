package servlets;

import beans.UserBean;
import dao.CartDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        System.out.println("CartServlet doPost action=" + action);
        
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if ("add".equals(action)) {
            CartDAO.addToCart(user.getUserID(), bookID, quantity);
            response.sendRedirect("cart.jsp");
        }
    }
}
