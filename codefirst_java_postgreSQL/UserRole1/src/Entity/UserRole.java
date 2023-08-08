public class UserRole {

    private int userRoleID;
    private String userRoleName;

    public UserRole(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public UserRole(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public UserRole(int userRoleID, String userRoleName) {
        this.userRoleID = userRoleID;
        this.userRoleName = userRoleName;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
}
