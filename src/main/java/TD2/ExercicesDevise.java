void main() {
    Portefeuille portefeuille = new Portefeuille();
    portefeuille.ajouter(Devise.EURO, 235.78);
    portefeuille.ajouter(Devise.DOLLAR, 76.23);
    portefeuille.ajouter(Devise.ROUBLE, 894.12);
    portefeuille.ajouter(Devise.YEN, 23500.0);

    portefeuille.afficher();

    portefeuille.retirer(Devise.EURO, 120.0);

    portefeuille.afficher();

    portefeuille.supprimer(Devise.YEN);

    portefeuille.afficher();

    portefeuille.retirer(Devise.DOLLAR, 1000.0);

    portefeuille.ajouter(Devise.ROUBLE, 56.18);

    portefeuille.afficher();
}

private enum Devise {
    EURO("Euro"),
    DOLLAR("Dollar"),
    ROUBLE("Rouble"),
    YEN("Yen");

    private final String nom;

    Devise(final String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

private static class Ligne {
    private final Devise devise;
    private double solde;

    Ligne(final Devise devise, final double solde) {
        this.devise = devise;
        this.solde = solde;
    }

    Devise getDevise() {
        return devise;
    }

    double getSolde() {
        return solde;
    }

    void ajouter(final double montant) {
        solde += montant;
    }

    void retirer(final double montant) {
        if (solde < montant) {
            System.out.println("Pas assez de " + devise.nom + " dans le portefeuille");
            return;
        }
        solde -= montant;
        System.out.println("Retrait effectué");
    }

    @Override
    public String toString() {
        return devise + " : " + solde;
    }
}

private static class Portefeuille {
    private final List<Ligne> lignes = new ArrayList<>();

    boolean contient(final Devise devise) {
        return lignes.stream().anyMatch(ligne -> ligne.getDevise() == devise);
    }

    void ajouter(final Devise devise, final double montant) {
        if (contient(devise)) {
            lignes.stream()
                  .filter(ligne -> ligne.getDevise() == devise)
                  .findFirst()
                  .ifPresent(ligne -> ligne.ajouter(montant));

            System.out.println("\nAjout de " + montant + " " + devise.nom);
            return;
        }
        lignes.add(new Ligne(devise, montant));
        System.out.println("\nAjout de " + montant + " " + devise.nom);
    }

    void retirer(final Devise devise, final double montant) {
        System.out.println("\nDemande retrait de " + montant + " " + devise.nom);
        if (contient(devise)) {
            lignes.stream()
                  .filter(ligne -> ligne.getDevise() == devise)
                  .findFirst()
                  .ifPresent(ligne -> ligne.retirer(montant));
            return;
        }
        System.out.println("Devise non présente dans le portefeuille");
    }

    void supprimer(final Devise devise) {
        final boolean suppression = lignes.removeIf(e -> e.devise == devise);
        if (suppression) {
            System.out.println("\nDevise " + devise.nom + " supprimée du portefeuille");
        }
    }

    void afficher() {
        System.out.println("\nPortefeuille :");
        lignes.forEach(System.out::println);
    }
}
