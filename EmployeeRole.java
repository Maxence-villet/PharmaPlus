public class EmployeeRole implements Role {

    @Override
    public String getRoleName() {
        return "Employé";
    }

    @Override
    public void performRoleAction() {
        System.out.println("Employé : Gestion quotidienne de la pharmacie.");
    }
}
