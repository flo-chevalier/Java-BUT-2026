import static TD1.Outils.saisirChaine;

void main() {
    exo2();
}

private void exo2() {
    String saisie;
    boolean enErreur;

    do {
        enErreur = false;
        saisie = saisirChaine();
        System.out.println("valeur = " + saisie);

        if (saisie == null || saisie.isEmpty()) {
            enErreur = true;
            continue;
        }

        for (int i = 0; i < saisie.length(); i++) {
            if (!Character.isAlphabetic(saisie.charAt(i))) {
                enErreur = true;
                break;
            }
        }
    } while (enErreur);

    System.out.println("OK ! Fin exercice 2");
}
