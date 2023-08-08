public class Role {

    private int roleID;
    private String rolename;

    public Role(int roleID) {
        this.roleID = roleID;
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Role(int roleID, String rolename) {
        this.roleID = roleID;
        this.rolename = rolename;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
