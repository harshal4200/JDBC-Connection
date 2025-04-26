import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Demodb",
                    "postgres",
                    "Harshal12!@"
            );

            String query = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Ajay");
            pstmt.setInt(3, 21);
            pstmt.setString(4,"Artificial Intelligence");
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
