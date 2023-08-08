import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class insertData {

    DataDB myDB;
    Connection connection;
    User user;

    public insertData(Connection connection, User user) {
        this.connection = connection;
        this.user = user;
    }

    public DataDB getMyDB() {
        return myDB;
    }

    public void setMyDB(DataDB myDB) {
        this.myDB = myDB;
    }

    public void addDataToDB() {
        String sqlCommand = "INSERT INTO users(username, password) VALUES( ?,?)";
//        String sqlCommand = "INSERT INTO users(id, username, password) VALUES(?,?,?)";
        try (PreparedStatement preState = getMyDB().connectionDB().prepareStatement(sqlCommand)) {
            preState.setString(1, getUser().getUsername());
            preState.setString(2, getUser().getPassword());
            int rowsInserted = preState.executeUpdate();
            System.out.println(rowsInserted+" row created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUserInDB(){
        String sqlCommand = "SELECT username, password FROM USERS WHERE username = ? AND password = ? ";
        try (PreparedStatement preState = this.connection.prepareStatement(sqlCommand)) {
            preState.setString(1, this.user.getUsername());
            preState.setString(2, this.user.getPassword());
            try (ResultSet resultSet = preState.executeQuery()) {
                return resultSet.next(); // Return true if the result set has at least one row (user exists)
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean controlUserName() throws SQLException {
        String sqlCommand = "SELECT username FROM USERS" ;
        ArrayList<Object> DBarray = getMyDB().generalDBtoAL(sqlCommand, "username");
        return DBarray.contains(getUser().getUsername());
    }


//    public Connection getConnection() {
//        return connection;
//    }

//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
