import java.util.ArrayList;
import java.util.List;

public class PharmacyManagementSystem {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        
        User admin = new User("AdminPharma", new AdminRole());
        admin.performAction();
        
        User employee = new User("Employee1", new EmployeeRole());
        employee.performAction();
        
        if (admin.isAdmin()) {
            AdminRole adminRole = (AdminRole) admin.getRole();
            adminRole.addUser(employee, userList);
            adminRole.removeUser(employee, userList);
        } else {
            System.out.println("Accès refusé : Seuls les Admin peuvent gérer les utilisateurs.");
        }
    }
}
