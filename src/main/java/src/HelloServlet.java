package src;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h3> Servlet </h3><br/>");
        resp.getWriter().println("hi " + getServletContext().getAttribute("name") + "<br/>" + req.getAttribute("filterParam"));
        resp.getWriter().println("</body></html>");    }
}
