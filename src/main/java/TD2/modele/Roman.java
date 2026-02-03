package TD2.modele;

public final class Roman extends Livre {
    private String genre;

    public Roman(final String titre, final String auteur, final int annee, final String genre) {
        super(titre, auteur, annee);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

    public void emprunter() {
        System.out.println("J'emprunte un roman");
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1)
                + ", genre=" + genre
                + "}";
    }
}
