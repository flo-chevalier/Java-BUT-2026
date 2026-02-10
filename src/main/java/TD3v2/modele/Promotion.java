package TD3v2.modele;

public class Promotion {

    private int id;
    private String nom;

    public Promotion(final String nom) {
        this.nom = nom;
    }

    public Promotion(final int id, final String nom) {
        this.id = id;
        this.nom = nom;
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

    @Override
    public String toString() {
        return nom;
    }
}
