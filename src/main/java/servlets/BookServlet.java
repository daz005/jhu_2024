package servlets;

import beans.BookBean;
import dao.BookDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("BookServlet doGet action=" + action);
        
        if ("viewCatalog".equals(action)) {
            List<BookBean> books = BookDAO.getAllBooks();
            request.setAttribute("books", books);
            request.getRequestDispatcher("catalog.jsp").forward(request, response);
        } else if ("viewBook".equals(action)) {
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            BookBean book = BookDAO.getBookById(bookID);
            request.setAttribute("book", book);
            request.getRequestDispatcher("bookDetails.jsp").forward(request, response);
        }
    }
	
	
	
}
