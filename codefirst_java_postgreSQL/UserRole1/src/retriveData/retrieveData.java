import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class retrieveData {

    public DataDB myDB;

    public void DBprinter(){
        String displaySQL = "SELECT * FROM users";
        try (Statement state = getMyDB().connectionDB().createStatement();
             ResultSet rs = state.executeQuery(displaySQL)){
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("id: "+id+", username: "+username+", password: "+ password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public DataDB getMyDB() {
        return myDB;
    }

    public void setMyDB(DataDB myDB) {
        this.myDB = myDB;
    }
}
