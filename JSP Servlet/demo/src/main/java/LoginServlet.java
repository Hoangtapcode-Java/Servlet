import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String userName =req.getParameter("username");
        out.print("Welcome " + userName);

        HttpSession session=req.getSession();
        session.setAttribute("uname", userName);

        ServletContext ctx=getServletContext();
        int t=(Integer)ctx.getAttribute("totalusers");
        int c=(Integer)ctx.getAttribute("currentusers");
        out.print("<br>Total users= "+t);
        out.print("<br>Current users= "+c);

        out.print("<br><a href='logout'>logout</a>");

        out.close();
    }
}
