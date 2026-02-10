package TD3v3;

import TD3v3.modele.Etudiant;
import TD3v3.modele.Promotion;
import TD3v3.service.EtudiantService;
import TD3v3.service.PromotionService;

public class ExerciceBDDv3 {

    static void main() {
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
