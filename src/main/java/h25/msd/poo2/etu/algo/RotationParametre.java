//Eddy Manoa Randrianarison 2433177
package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;

/**
 *  Utilise une matrice 2D pour mélanger les lettres du texte lisible. Les paramètres reçus serviront à établir les dimensions de la matrice 2D utilisée pour mélanger
 * les lettres de façon réversible.
 * */
public class RotationParametre extends AbstractAvecParametre {
    private static final int LIGNES_PAR_DEFAUT = 2;
    private static final int COLONNES_PAR_DEFAUT = 4;

    public RotationParametre() {
        super("RotationParametre");
        setParametre("lignes", String.valueOf(LIGNES_PAR_DEFAUT));
        setParametre("colonnes", String.valueOf(COLONNES_PAR_DEFAUT));
    }

    public int getLignes() {
        return Integer.parseInt(getParametre("lignes"));
    }

    public int getColonnes() {
        return Integer.parseInt(getParametre("colonnes"));
    }


    @Override
    public String encrypte(String texteLisible) {
        String resultat = traiterTexte(texteLisible, true);
        setNombreUsages(getNombreUsages() + 1);
        return resultat;
    }

    @Override
    public String decrypte(String texteEncrypte) {
        String resultat = traiterTexte(texteEncrypte, false);
        setNombreUsages(getNombreUsages() + 1);
        return retirerCaracteresParDefaut(resultat);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {

    }

    private String retirerCaracteresParDefaut(String texte) {
        char defaut = getCaractereParDefaut();
        int index = texte.length();
        while (index > 0 && texte.charAt(index - 1) == defaut) {
            index--;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(texte.charAt(i));
        }
        return result.toString();
    }

    public String traiterTexte(String texte, boolean estEncryption) {
        StringBuilder texteTraiter = new StringBuilder();
        int index = 0;
        int lignes = getLignes();
        int colonnes = getColonnes();

        while (index < texte.length()) {
            char[][] matrice = new char[lignes][colonnes];

            if (estEncryption) {
                for (int i = 0; i < lignes; i++) {
                    for (int j = 0; j < colonnes; j++) {
                        if (index < texte.length()) {
                            matrice[i][j] = texte.charAt(index++);
                        } else {
                            matrice[i][j] = getCaractereParDefaut();
                        }
                    }
                }
                for (int j = 0; j < colonnes; j++) {
                    for (int i = 0; i < lignes; i++) {
                        texteTraiter.append(matrice[i][j]);
                    }
                }
            } else {
                for (int j = 0; j < colonnes; j++) {
                    for (int i = 0; i < lignes; i++) {
                        if (index < texte.length()) {
                            matrice[i][j] = texte.charAt(index++);
                        } else {
                            matrice[i][j] = getCaractereParDefaut();
                        }
                    }
                }
                for (int i = 0; i < lignes; i++) {
                    for (int j = 0; j < colonnes; j++) {
                        texteTraiter.append(matrice[i][j]);
                    }
                }
            }
        }

        return texteTraiter.toString();
    }

    @Override
    public void appliquerParametre(String nom, String valeur) {

    }

    @Override
    public String valideParametre(String nom, String valeur) {
        String erreur ="";
        if (!nom.equals("lignes") && !nom.equals("colonnes")) {
            erreur = "Nom du paramètre invalide";
        }
        try {
            int val = Integer.parseInt(valeur);
            if (val <= 0) {
                erreur = "Votre valeur est negatif";
            }
        } catch (NumberFormatException e) {
            erreur = "La valeur doit être un entier";
        }
        return erreur;
    }

    @Override
    public String toString() {
        return "Rotation Paramètre";
    }


    public static void main(String[] args) {
        RotationParametre test = new RotationParametre();
        String texte = "j'encrypte avec un matrice 2D";

        System.out.println(texte);
        String encrypte = test.encrypte(texte);
        System.out.println(encrypte);
        String decrypte = test.decrypte(encrypte);
        System.out.println(decrypte);

    }
}

