import TD2.modele.Livre;
import TD2.modele.Roman;

void main() {
    Livre livre = new Livre("1984", "George Orwell", 1949);
    System.out.println(livre);

    Roman roman = new Roman("1984", "George Orwell", 1949, "Anticipation");
    System.out.println(roman);

    livre.emprunter();
    roman.emprunter();

    // exo 4
    Livre livre1 = new Livre("Dune", "Frank Herbert", 1965);
    Livre livre2 = new Livre("Dune", "Frank Herbert", 1965);
    System.out.println(livre1.equals(livre2));

    // exo 5
    List<Livre> bibliotheque = new ArrayList<>();
    bibliotheque.add(livre1);
    bibliotheque.add(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
    bibliotheque.add(livre);
    bibliotheque.add(roman);

    System.out.println(bibliotheque.indexOf(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943)));

    // exo 6
    Map<Livre, Integer> exemplaires = new HashMap<>();
    exemplaires.put(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1952), 5);
    exemplaires.put(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1952), 8);
    for (Livre l : exemplaires.keySet()) {
        System.out.println(l + " : " + exemplaires.get(l) + " exemplaires");
    }

    // exo 7
    Collections.sort(bibliotheque);
    bibliotheque.forEach(System.out::println);

    System.out.println("Fin exercices");
}
