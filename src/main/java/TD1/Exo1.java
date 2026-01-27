import static TD1.Outils.saisirChaine;

void main() {
    exo1();
}

private void exo1() {
    String saisie;

    do {
        saisie = saisirChaine();
        System.out.println("valeur = " + saisie);
    } while (saisie == null || saisie.isEmpty() || !saisie.toUpperCase().equals(saisie));

    System.out.println("OK ! Fin exercice 1");
}
