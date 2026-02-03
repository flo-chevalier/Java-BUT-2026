package TD2.modele;

public class Livre implements Empruntable, Comparable<Livre> {
    private String titre;
    private String auteur;
    private int annee;

    public Livre(final String titre, final String auteur, final int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(final String titre) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("le titre est vide");
        }
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(final String auteur) {
        if (auteur == null || auteur.isBlank()) {
            throw new IllegalArgumentException("l'auteur est vide");
        }
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(final int annee) {
        this.annee = annee;
    }

    @Override
    public void emprunter() {
        System.out.println("J'emprunte un livre");
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", annee=" + annee +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Livre livre2)) {
            return false;
        }
        return this.titre.equals(livre2.titre) && this.auteur.equals(livre2.auteur);
    }

    @Override
    public int hashCode() {
        return titre.hashCode() + auteur.hashCode();
    }

    @Override
    public int compareTo(final Livre autreLivre) {
        // Comparer les auteurs
        int auteurComparison = auteur.compareTo(autreLivre.auteur);
        if (auteurComparison != 0) {
            return auteurComparison;
        }
        // Si les auteurs sont les mêmes, comparer les titres
        return titre.compareTo(autreLivre.titre);
    }
}
