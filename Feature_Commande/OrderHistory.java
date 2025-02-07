package Feature_Commande;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory extends OrderService {
    private List<String> commandes;
    public OrderHistory() {
        this.commandes = new ArrayList<>();
    }

    public void afficherCommandes() {
        if (commandes.isEmpty()) {
            System.out.println("Aucune commande dans l'historique.");
        } else {
            System.out.println("Historique des commandes :");
            commandes.forEach(System.out::println);
        }
    }
}