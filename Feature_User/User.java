package Feature_User;

public class User {
    private String username;
    private Role role;

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void performAction() {
        role.performRoleAction();
    }

    public boolean isAdmin() {
        return role instanceof AdminRole;
    }
}