import static TD1.Outils.genererChaineVoyelles;

void main() {
    exo3(12);
}

private void exo3(final int longueur) {
    if (longueur <= 0) {
        System.out.println("erreur longueur de chaine");
    }

    System.out.println("Génération d'une chaine de longueur " + longueur);
    String chaine = genererChaineVoyelles(longueur);

    System.out.println("résultat = " + chaine);
    System.out.println("OK ! Fin exercice 3");
}
