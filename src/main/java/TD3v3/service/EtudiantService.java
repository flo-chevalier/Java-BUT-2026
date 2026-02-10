package TD3v3.service;

import TD3v3.dao.EtudiantDAO;
import TD3v3.modele.Etudiant;

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
        return etudiantDAO.findAll();
    }

    public Etudiant getEtudiant(final Integer id) {
        return etudiantDAO.findById(id);
    }

    public Etudiant ajouter(final Etudiant etudiant) {
        return etudiantDAO.create(etudiant);
    }
}
