void main() {
    final List<Integer> tableau = creerTableau(10);
    afficherTableau(tableau);

    System.out.println("somme = " + getSomme(tableau));
    System.out.println("nombre éléments pairs = " + getNombreElementsPairs(tableau));
    System.out.println("plus grand pair = " + getPlusGrandPair(tableau));

    final List<Integer> tableau2 = creerTableau(10);
    afficherTableau(tableau2);
    afficherTableau(trier(tableau, tableau2));
}

private List<Integer> creerTableau(final int taille) {
    final List<Integer> entiers = new ArrayList<>(taille);

    for (int i = 0; i < taille; i++) {
        entiers.add(new Random().nextInt(200));
    }
    return entiers;
}

private void afficherTableau(final List<Integer> tableau) {
    StringBuilder chaine = new StringBuilder();
    for (int i : tableau) {
        chaine.append(i).append(" ");
    }
    System.out.println(chaine);
}

private int getSomme(final List<Integer> tableau) {
    return tableau.stream().mapToInt(i -> i).sum();
}

private long getNombreElementsPairs(final List<Integer> tableau) {
    return tableau.stream()
                  .filter(i -> i % 2 == 0)
                  .count();
}

private int getPlusGrandPair(final List<Integer> entiers) {
    return entiers.stream()
                  .filter(i -> i % 2 == 0)
                  .mapToInt(i -> i)
                  .max()
                  .orElse(0);
}

private List<Integer> trier(final List<Integer> tableau1, final List<Integer> tableau2) {
    var nouvelleListe = new ArrayList<>(tableau1);
    nouvelleListe.addAll(tableau2);
    nouvelleListe.sort(Integer::compareTo);
    return nouvelleListe;
}
