package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Users.User;

/**
 *
 * @author 734972
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("user");
            request.setAttribute("logout", "You have successfully logged out.");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       
       if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
           request.setAttribute("message", "You have to actually type something dude");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
       }
       
       UserService service = new UserService();
       User user = service.login(username, password);
       
       if (user == null) {
           request.setAttribute("message", "WRONG!");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
       }
       
       HttpSession session = request.getSession();
       session.setAttribute("user", user);
       response.sendRedirect("home");
    } 
}
