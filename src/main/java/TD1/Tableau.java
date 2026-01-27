void main() {
    final int[] tableau = creerTableau(10);
    afficherTableau(tableau);

    System.out.println("somme = " + getSomme(tableau));
    System.out.println("nombre éléments pairs = " + getNombreElementsPairs(tableau));
    System.out.println("plus grand pair = " + getPlusGrandPair(tableau));

    final int[] tableau2 = creerTableau(10);
    afficherTableau(tableau2);
    afficherTableau(trier(tableau, tableau2));
}

private int[] creerTableau(final int taille) {
    final int[] entiers = new int[taille];

    for (int i = 0; i < taille; i++) {
        entiers[i] = new Random().nextInt(200);
    }
    return entiers;
}

private void afficherTableau(final int[] tableau) {
    StringBuilder chaine = new StringBuilder();
    for (int i : tableau) {
        chaine.append(i).append(" ");
    }
    System.out.println(chaine);
}

private int getSomme(final int[] tableau) {
    return Arrays.stream(tableau).sum();
}

private long getNombreElementsPairs(final int[] tableau) {
    return Arrays.stream(tableau)
                 .filter(i -> i % 2 == 0)
                 .count();
}

private int getPlusGrandPair(final int... entiers) {
    return Arrays.stream(entiers)
                 .filter(i -> i % 2 == 0)
                 .max()
                 .orElse(0);
}

private int[] trier(final int[] tableau1, final int[] tableau2) {
    return IntStream.concat(Arrays.stream(tableau1), Arrays.stream(tableau2))
                    .sorted()
                    .toArray();
}
