package PharmaPlus.Feature_User;

import java.util.List;

public class AdminRole implements Role {

    @Override
    public String getRoleName() {
        return "Admin";
    }

    @Override
    public void performRoleAction() {
        System.out.println("Admin: Gestion des utilisateurs et des accès.");
    }

    public void addUser(User user, List<User> userList) {
        userList.add(user);
        System.out.println("Utilisateur ajouté : " + user.getUsername());
    }

    public void removeUser(User user, List<User> userList) {
        if (userList.remove(user)) {
            System.out.println("Utilisateur supprimé : " + user.getUsername());
        } else {
            System.out.println("Utilisateur introuvable.");
        }
    }
}