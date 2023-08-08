
public class User {


    private int userID;
    private String username;
    private String password;
    public DataDB myDB;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public DataDB getMyDB() {
        return myDB;
    }

    public void setMyDB(DataDB myDB) {
        this.myDB = myDB;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
///////////





}
