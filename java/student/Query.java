package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {
    private Connection conn;

    public Query() {
        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertData(Data data) {
        String query = "INSERT INTO STUDENT(Name, roll_no, gender, Father_name, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getRollno());
            preparedStatement.setString(3, data.getGender());
            preparedStatement.setString(4, data.getFather_name());

            if (data.getImage() != null) {
                preparedStatement.setBlob(5, data.getImage()); 
            } else {
                preparedStatement.setNull(5, java.sql.Types.BLOB); 
            }

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student record was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
