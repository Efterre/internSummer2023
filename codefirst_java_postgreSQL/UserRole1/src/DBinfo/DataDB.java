import java.sql.*;
import java.util.ArrayList;

public class DataDB {

    protected final String url = "url";
    protected final String username = "username";
    protected final String password = "password";
    private String commandLine ;
    private String columnName;
    private int size = 0;

    public Connection connectionDB() throws SQLException {
        return DriverManager.getConnection(getUrl(),getUsername(),getPassword());
    }

    public void createDB(){
        try (Connection connection = connectionDB()) {
            String tableName = "users"; // Replace with the name of your table
            // Check if the table is empty
            String countQuery = "SELECT COUNT(*) AS record_count FROM " + tableName;

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(countQuery);
                if (resultSet.next()) {
                    int recordCount = resultSet.getInt("record_count");

                    if (recordCount == 0) {
                        // Drop the table if it is empty
                        String dropQuery = "DROP TABLE users";
                        statement.executeUpdate(dropQuery);
                        System.out.println("Table 'users' dropped successfully!");

                    } else {
                        System.out.println("Table users is not empty. Cannot drop.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = connectionDB()) {
            String createTable = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, username VARCHAR(50), password VARCHAR(50))";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTable);
                System.out.println("Table created successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() throws SQLException {
        String sqlCommand = "SELECT COUNT(*) FROM users";
        try (PreparedStatement preparedStatement = this.connectionDB().prepareStatement(sqlCommand);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    public ArrayList<Integer> DBtoAL() throws SQLException {
        ArrayList<Integer> DBarrayList = new ArrayList<>();
        String sqlCommand = "SELECT id from users";
        Connection connection = connectionDB();
        Statement state = connection.createStatement();

        ResultSet resultSet = state.executeQuery(sqlCommand);
        while (resultSet.next()) {
            DBarrayList.add(resultSet.getInt("id"));
        }
        return DBarrayList;
    }
    public void printDBtoAL() throws SQLException {
        int round = 0;
        while (round < DBtoAL().size()){
            System.out.println(DBtoAL().get(round));
            round++;
        }
//        if (getRowCount() == 0){
//            System.out.println("Empty DB");
//        }
    }

    public ArrayList<Object> generalDBtoAL(String sqlCommand, String columnName) throws SQLException {
        ArrayList<Object> DBarrayList = new ArrayList<>();
        if (sqlCommand == null || columnName == null){
            return null;
        }
        Connection connection = connectionDB();
        Statement state = connection.createStatement();
        setCommandLine(sqlCommand);
        setColumnName(columnName);

        ResultSet resultSet = state.executeQuery(sqlCommand);

        if (columnName.equals("id")){
            while (resultSet.next()) {
                DBarrayList.add(resultSet.getInt(columnName));
            }
        }
        else {
            while (resultSet.next()) {
                DBarrayList.add(resultSet.getString(columnName));
            }
        }
        return DBarrayList;
    }
    public void printGeneralDBtoAL() throws SQLException {
        int round = 0;
        while (round < generalDBtoAL(getCommandLine(), getColumnName()).size()){
            System.out.println(generalDBtoAL(getCommandLine(), getColumnName()).get(round));
            round++;
        }
//        if (getRowCount() == 0){
//            System.out.println("Empty DB");
//        }
    }

    public String getCommandLine() {
        return commandLine;
    }
    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

//    public int getSize() throws SQLException {
//        return this.size;
//    }
//    public void setSize() throws SQLException {
//        this.size++;
//    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }



}
