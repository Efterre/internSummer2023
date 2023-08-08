//import java.sql.*;
//
//public class test {
//
//    public static void main(String[] args) throws SQLException {
//
//
//
//    }
//
//    private static void insertData(Connection connection,User u) throws SQLException {
//        String sql = "INSERT INTO users (id,username, password) VALUES (?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            //u.setUserID(randomID());
//            statement.setInt(1,u.getUserID());
//            statement.setString(2, u.getUsername());
//            statement.setString(3, u.getPassword());
//            int rowsInserted = statement.executeUpdate();
//            System.out.println(rowsInserted + " row(s) inserted.");
//        }
//    }
//
//    private static void retrieveData(Connection connection) throws SQLException {
//        String sql = "SELECT * FROM users";
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                System.out.println("id: " + id + ", username: " + name + ", password: " + password);
//            }
//        }
//    }
//}
