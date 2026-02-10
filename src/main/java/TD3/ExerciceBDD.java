package TD3;

import TD3.modele.Etudiant;
import TD3.outils.DatabaseConnection;
import TD3.service.EtudiantService;

public class ExerciceBDD {

    static void main() {
        DatabaseConnection.initialiser();

        final EtudiantService etudiantService = new EtudiantService();
        etudiantService.ajouter(new Etudiant("Bessac", "Bilbo", "Info"));
        etudiantService.ajouter(new Etudiant("Bessac", "Frodo", "Info"));
        etudiantService.ajouter(new Etudiant("Le Gris", "Gandalf", "Magie"));

        etudiantService.getEtudiants().forEach(System.out::println);
    }
}
