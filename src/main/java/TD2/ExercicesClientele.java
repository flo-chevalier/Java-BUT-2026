void main() {
    final Clientele clientele = new Clientele();
    final Client client1 = new Client("Frodo", "Bessac", 2300);
    final Client client2 = new Client("Bilbo", "Bessac", 700);
    final Client client3 = new Client("Gandalf", "Le Gris", 8000);
    clientele.ajouter(client1);
    clientele.ajouter(client2);
    clientele.ajouter(client3);

    clientele.afficher();

    clientele.modifier(client3, "Le Blanc");
    clientele.modifier(client3, 15000);

    System.out.println();
    clientele.afficher();
}

private static class Client {
    private String nom;
    private String prenom;
    private int chiffreAffaires;
    private Reduction reduction;

    public Client(final String prenom, final String nom, final int chiffreAffaires) {
        this.nom = nom;
        this.prenom = prenom;
        this.chiffreAffaires = chiffreAffaires;
        determineReduction();
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

    public int getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(final int chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
        determineReduction();
    }

    public Reduction getReduction() {
        return reduction;
    }

    private void determineReduction() {
        reduction = Reduction.of(chiffreAffaires);
    }

    @Override
    public String toString() {
        return nom + ", " + prenom + ", " + chiffreAffaires + "€, "  + reduction;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Client autre) {
            return autre.nom.equals(this.nom) && autre.prenom.equals(this.prenom);
        }
        return false;
    }
}

private enum Reduction {
    R0(0, "Régulier", 0, 1000),
    R10(10, "Bon Client", 1001, 3000),
    R15(15, "Client Exceptionnel", 3001, 10000),
    R30(30, "VIC", 10001, Integer.MAX_VALUE);

    private final int montant;
    private final String nom;
    private final int borneInferieure;
    private final int borneSuperieure;

    Reduction(final int montant, final String nom, final int borneInferieure, final int borneSuperieure) {
        this.montant = montant;
        this.nom = nom;
        this.borneInferieure = borneInferieure;
        this.borneSuperieure = borneSuperieure;
    }

    static Reduction of(final int chiffre) {
        return Arrays.stream(values())
                     .filter(r -> chiffre >= r.borneInferieure && chiffre <= r.borneSuperieure)
                     .findFirst()
                     .orElse(R0);
    }

    @Override
    public String toString() {
        return nom;
    }
}

private static class Clientele {
    private final Set<Client> clients;

    Clientele() {
        clients = new TreeSet<>(Comparator.comparing(Client::getChiffreAffaires).reversed());
    }

    void ajouter(final Client client) {
        clients.add(client);
    }

    void supprimer(final Client client) {
        clients.remove(client);
    }

    void modifier(final Client client, final int chiffreAffaires) {
        client.setChiffreAffaires(chiffreAffaires);
    }

    void modifier(final Client client, final String nom) {
        client.setNom(nom);
    }

    void afficher() {
        clients.forEach(System.out::println);
    }
}
