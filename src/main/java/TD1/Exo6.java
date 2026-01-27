
void main() {
    exo6();
}

private void exo6() {
    int nombre = nombreAleatoire();
    String resultat;

    if (nombre % 3 == 0 && nombre % 5 == 0) {
        resultat = "Jazz Bundle";
    } else if (nombre % 3 == 0) {
        resultat = "Jazz";
    } else if (nombre % 5 == 0) {
        resultat = "Bundle";
    } else {
        resultat = "" + nombre;
    }

    System.out.println("Nombre = " + nombre + " => " + resultat);
    System.out.println("Fin exercice 6");
}


private int nombreAleatoire() {
    return (int) (Math.random() * 200);
}
