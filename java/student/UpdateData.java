package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-data")
public class UpdateData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String rollNo = req.getParameter("roll_no");
        String gender = req.getParameter("gender");
        String fatherName = req.getParameter("father_name");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE STUDENT SET Name=?, roll_no=?, gender=?, Father_name=? WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, rollNo);
            stmt.setString(3, gender);
            stmt.setString(4, fatherName);
            stmt.setInt(5, id);
            stmt.executeUpdate();


            res.sendRedirect("view-data");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

