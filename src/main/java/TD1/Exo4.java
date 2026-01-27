import static TD1.Outils.genererChaineToutesLettres;

void main() {
    exo4();
}

private void exo4() {
    final String chaineOrigine = genererChaineToutesLettres(23);
    StringBuilder chaineChifree = new StringBuilder();

    for (int i = 0; i < chaineOrigine.length(); i++) {
        chaineChifree.append(chiffrer(chaineOrigine.charAt(i)));
    }

    System.out.println("origine = " + chaineOrigine);
    System.out.println("résultat = " + chaineChifree);
    System.out.println("Fin exercice 4");
}

private char chiffrer(final char lettre) {
    return switch (Character.toUpperCase(lettre)) {
        case 'A' -> '4';
        case 'E' -> '3';
        case 'G' -> '6';
        case 'I' -> '1';
        case 'O' -> '0';
        case 'S' -> '5';
        case 'Z' -> '2';
        default -> lettre;
    };
}
