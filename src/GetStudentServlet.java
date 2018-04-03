import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/")

public class GetStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionToTheDataBase connectionToTheDataBase = new ConnectionToTheDataBase();
        Connection connection = connectionToTheDataBase.getConnection();
        List<Student> students = new ArrayList<>();
        if(connection != null){
            try {
                Statement st = connection.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM students");
                //while nieko nerasom, nes jis yra boolean - true/falls, jei falls - iseis is while!!!
                while (resultSet.next()){
                    students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("surname"), resultSet.getString("phone"),
                            resultSet.getString("email")));
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        req.setAttribute("students", students);
        req.getRequestDispatcher("students.jsp").forward(req,resp);
    }
}
