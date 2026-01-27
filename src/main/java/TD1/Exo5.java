import static TD1.Outils.genererChaineToutesLettres;

void main() {
    exo5();
}

private void exo5() {
    boolean valide = false;
    String chaine;
    int tentatives = 0;

    do {
        tentatives++;
        chaine = genererChaineToutesLettres(5);
        valide = chaine.equals(chaine.toUpperCase());
    } while (!valide);

    System.out.println("Tentatives = " + tentatives);
    System.out.println("Chaine = " + chaine);
    System.out.println("Fin exercice 5");
}
