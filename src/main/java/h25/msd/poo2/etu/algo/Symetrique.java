// Eddy Manoa Randrianarison 2433177
package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Divise le texte en deux moitiés, inverse chaque moitié indépendamment.
 * Si la longueur est impaire, le caractère central reste au centre.
 * Ex : "abcdef" devient "cbafed", et l'opération est réversible. Ensuite, en avance vers les algorithmes de cryptage/Décriptage.
 */
public class Symetrique extends AbstractSansParametre {

    public Symetrique() {
        super("Symetrique");
    }


    //Transforme une liste d'entiers en divisant en deux moitiés et en inversant chacune. Si la taille est impaire, le caractère du milieu reste au centre.
    public List<Integer> transformeListe(List<Integer> valeurs) {
        int taille = valeurs.size();
        int milieu = taille / 2;

        List<Integer> blocGauche = new ArrayList<>(valeurs.subList(0, milieu));
        List<Integer> blocDroite;
        int central = -1;

        if (taille % 2 == 0) {
            blocDroite = new ArrayList<>(valeurs.subList(milieu, taille));
        } else {
            central = valeurs.get(milieu);
            blocDroite = new ArrayList<>(valeurs.subList(milieu + 1, taille));
        }

        Collections.reverse(blocGauche);
        Collections.reverse(blocDroite);

        List<Integer> liste = new ArrayList<>(blocGauche);
        if (taille % 2 != 0) {
            liste.add(central);
        }
        liste.addAll(blocDroite);
        return liste;
    }

    @Override
    public String encrypte(String texteLisible) {
        List<Integer> valeurs = traduitTexteEnListe(texteLisible);

        // décalage
        int taille = getCaractereEnNombre().size();
        int i = 0;
        while (i < valeurs.size()) {
            valeurs.set(i, modulo(valeurs.get(i) + getDecalage(), taille));
            i++;
        }

        // symétrie
        List<Integer> transformees = transformeListe(valeurs);

        setNombreUsages(getNombreUsages() + 1);
        return traduitListeEnTexte(transformees);
    }


    @Override
    public String decrypte(String texteEncrypte) {
        List<Integer> valeurs = traduitTexteEnListe(texteEncrypte);

        //symétrie inverse
        List<Integer> inverses = transformeListe(valeurs);

        //retrait du décalage
        int taille = getCaractereEnNombre().size();
        int i = 0;
        while (i < inverses.size()) {
            inverses.set(i, modulo(inverses.get(i) - getDecalage(), taille));
            i++;
        }

        setNombreUsages(getNombreUsages() + 1);
        return traduitListeEnTexte(inverses);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {
    }


    @Override
    public String toString() {
        return "Symétrique";
    }

    public static void main(String[] args) {
        Symetrique test = new Symetrique();
        String texte = "symetrique";

        System.out.println(texte);
        String encrypte = test.encrypte(texte);
        System.out.println(encrypte);
        String decrypte = test.decrypte(encrypte);
        System.out.println(decrypte);
    }
}
