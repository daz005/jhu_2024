package servlets;

import beans.UserBean;
import dao.UserDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("logout".equals(action)) {
            // Handle logout
        	handleLogout(request, response);
        } else {
            // Handle other GET actions if necessary, or redirect to a default page
            response.sendRedirect("index.jsp");
        }
    }
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("UserServlet doPost action=" + action);

        if ("register".equals(action)) {
            handleRegister(request, response);
        }else if ("login".equals(action)) {
            handleLogin(request, response);
        }else {
	    	System.out.println("TODO...");
	    }
    }
	
	
    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        UserBean newUser = new UserBean(0, name, email, password, address);
        boolean isRegistered = UserDAO.registerUser(newUser);

        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserBean user = UserDAO.validateUser(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    
    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//TODO
        HttpSession session = request.getSession(false); // Fetch session if it exists
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        response.sendRedirect("index.jsp"); // Redirect to homepage or login page
    	
    }


}
