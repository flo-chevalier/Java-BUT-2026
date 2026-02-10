package TD3v2;

import TD3v2.modele.Etudiant;
import TD3v2.modele.Promotion;
import TD3v2.outils.DatabaseConnection;
import TD3v2.service.EtudiantService;
import TD3v2.service.PromotionService;

public class ExerciceBDDv2 {

    static void main() {
        DatabaseConnection.initialiser();

        final PromotionService promotionService = new PromotionService();
        final var promo1 = promotionService.ajouterPromotion(new Promotion("Info"));
        final var promo2 = promotionService.ajouterPromotion(new Promotion("Magie"));

        final EtudiantService etudiantService = new EtudiantService();
        etudiantService.ajouter(new Etudiant("Bessac", "Bilbo", promo1));
        etudiantService.ajouter(new Etudiant("Bessac", "Frodo", promo1));
        etudiantService.ajouter(new Etudiant("Le Gris", "Gandalf", promo2));

        etudiantService.getEtudiants().forEach(System.out::println);
    }
}
