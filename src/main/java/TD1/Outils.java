package TD1;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe d'outils pour TD1.
 */
public  final class Outils {

    private static final char[] VOYELLES = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    private static final char[] TOUTES = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private Outils() {
    }

    public static String saisirChaine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("saisir une chaine de caractères");
        return sc.nextLine();
    }

    public static String genererChaineVoyelles(final int longueur) {
        return genererChaine(longueur, VOYELLES);
    }

    public static String genererChaineToutesLettres(final int longueur) {
        return genererChaine(longueur, TOUTES);
    }

    private static String genererChaine(final int longueur, final char[] lettres) {
        StringBuilder chaine = new StringBuilder();

        for (int i = 0; i < longueur; i++) {
            int index = new Random().nextInt(lettres.length);
            chaine.append(lettres[index]);
        }

        return chaine.toString();
    }
}
