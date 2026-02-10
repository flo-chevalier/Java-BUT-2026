package TD3v3.modele;

import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToOne(optional = false)
    private Promotion promotion;

    public Etudiant() {
    }

    public Etudiant(final String nom, final String prenom, final Promotion promotion) {
        this.nom = nom;
        this.prenom = prenom;
        this.promotion = promotion;
    }

    public Etudiant(final int id, final String nom, final String prenom, final Promotion promotion) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(final Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " - " + promotion.getNom();
    }
}
