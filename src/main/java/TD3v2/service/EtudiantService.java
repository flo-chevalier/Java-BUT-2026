package TD3v2.service;

import TD3v2.dao.EtudiantDAO;
import TD3v2.modele.Etudiant;

import java.util.List;

public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    public EtudiantService() {
        this(new EtudiantDAO());
    }

    EtudiantService(final EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public List<Etudiant> getEtudiants() {
        return etudiantDAO.getAllEtudiants();
    }

    public Etudiant getEtudiant(final int id) {
        return etudiantDAO.getEtudiantById(id);
    }

    public Etudiant ajouter(final Etudiant etudiant) {
        return etudiantDAO.ajouterEtudiant(etudiant);
    }
}
