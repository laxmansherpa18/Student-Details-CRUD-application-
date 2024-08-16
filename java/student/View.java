package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view-data")
public class View extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM STUDENT";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            out.println("<html>");
            out.println("<head><title>Student Data</title></head>");
            out.println("<body>");
            out.println("<h2>Student Data</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Photo</th><th>Student Name</th><th>RollNo</th><th>Gender</th><th>Father's Name</th><th>Action</th><th>Action</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                Blob imageBlob = rs.getBlob("image");

                if (imageBlob != null) {
                    byte[] image = imageBlob.getBytes(1, (int) imageBlob.length());
                    String storeImg = java.util.Base64.getEncoder().encodeToString(image);
                    out.println("<td><img src='data:image/jpeg;base64," + storeImg + "' alt='Student Photo' width='100' height='100'/></td>");
                } else {
                    out.println("<td>No Image</td>");
                }
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getString("roll_no") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("<td>" + rs.getString("Father_name") + "</td>");

                
                out.println("<td>");
                out.println("<form action=\"edit-data\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + rs.getInt("id") + "\" />");
                out.println("<input type=\"submit\" value=\"Edit\" />");
                out.println("</form>");
                out.println("</td>");


                
                out.println("<td>");
                out.println("<form action=\"delete-data\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + rs.getInt("id") + "\" />");
                out.println("<input type=\"submit\" value=\"Delete\" />");
                out.println("</form>");
                out.println("</td>");

                out.println("</tr>");
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
    }

}

