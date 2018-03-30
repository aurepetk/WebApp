import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class MyFirstServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = "Andrius";
        String surname = "Baltrunas";

        req.setAttribute("name", name);
        req.setAttribute("surname", surname);

        req.getRequestDispatcher("myFirstJSP.jsp").forward(req, resp);
    }
}
