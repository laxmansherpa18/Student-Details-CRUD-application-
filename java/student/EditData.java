package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-data")
public class EditData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM STUDENT WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            if (rs.next()) {
                out.println("<html>");
                out.println("<head><title>Edit Student Data</title></head>");
                out.println("<body>");
                out.println("<h2>Edit Student Data</h2>");
                out.println("<form method='POST' action='update-data'>");
                out.println("<input type='hidden' name='id' value='" + id + "' />");
                out.println("Name: <input type='text' name='name' value='" + rs.getString("Name") + "' /><br/>");
                out.println("Roll No: <input type='text' name='roll_no' value='" + rs.getString("roll_no") + "' /><br/>");
                out.println("Gender: <input type='text' name='gender' value='" + rs.getString("gender") + "' /><br/>");
                out.println("Father's Name: <input type='text' name='father_name' value='" + rs.getString("Father_name") + "' /><br/>");
                out.println("<input type='submit' value='Update' />");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
