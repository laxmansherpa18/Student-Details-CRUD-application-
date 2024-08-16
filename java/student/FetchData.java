package student;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/submit-data")
@MultipartConfig(maxFileSize = 5055375)
public class FetchData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("studentName");
        String rollno = req.getParameter("rollNo");
        String gender = req.getParameter("gender");
        String fatherName = req.getParameter("fn");
        Part imagePart = req.getPart("image");


        InputStream inputStream = null;
        if (imagePart != null) {
            inputStream = imagePart.getInputStream();
        }

        Data data = new Data();
        data.setName(name);
        data.setRollno(rollno);
        data.setGender(gender);
        data.setFather_name(fatherName);
        data.setImage(inputStream);

        Query qu = new Query();
        qu.insertData(data);
        
        res.sendRedirect("view.html");
        
    }
}
