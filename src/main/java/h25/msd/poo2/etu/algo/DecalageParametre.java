//Eddy Manoa Randrianarison 2433177
package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;

import java.util.ArrayList;
import java.util.List;


/**
 * Effectue la même chose que DecalageFixe, mais en utilisant un paramètre reçu du UI au lieu d’une constante pour effectuer le décalage
 */
public class DecalageParametre extends AbstractAvecParametre {
    private static final int DECALAGE_PAR_DEFAUT = 5;
    private int decalage;

    public DecalageParametre() {
        super("DecalageParametre");
        this.decalage = DECALAGE_PAR_DEFAUT;
        setParametre("decalage", String.valueOf(DECALAGE_PAR_DEFAUT));
    }


    public int getDecalage() {
        return decalage;
    }

    @Override
    public String encrypte(String texteLisible) {
        List<Integer> valeurs = traduitTexteEnListe(texteLisible);
        List<Integer> modifiees = new ArrayList<>();
        int taille = getCaractereEnNombre().size();
        for (int v : valeurs) {
            modifiees.add((v + getDecalage()) % taille);
        }
        setNombreUsages(getNombreUsages() + 1);
        return traduitListeEnTexte(modifiees);
    }

    @Override
    public String decrypte(String texteEncrypte) {
        List<Integer> valeurs = traduitTexteEnListe(texteEncrypte);
        List<Integer> modifiees = new ArrayList<>();
        int taille = getCaractereEnNombre().size();
        for (int v : valeurs) {
            modifiees.add((v - getDecalage() + taille) % taille);
        }
        setNombreUsages(getNombreUsages() + 1);
        return traduitListeEnTexte(modifiees);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {

    }

    @Override
    public void appliquerParametre(String nom, String valeur) {
        if ("decalage".equals(nom)) {
            this.decalage = Integer.parseInt(valeur);
        }
    }

    @Override
    public String valideParametre(String nom, String valeur) {
        String erreur = "";
        if (!"decalage".equals(nom)) {
            erreur = "Nom invalide!";
        }
        try {
            Integer.parseInt(valeur);
        } catch (NumberFormatException e) {
            erreur = "Attention! Un entier svp";
        }
        return erreur;
    }

    @Override
    public String toString() {
        return "Décalage Paramètre";
    }


    public static void main(String[] args) {
        DecalageParametre test = new DecalageParametre();
        String texte = "DecalageParametre";

        System.out.println(texte);
        String encrypte = test.encrypte(texte);
        System.out.println(encrypte);
        String decrypte = test.decrypte(encrypte);
        System.out.println(decrypte);

    }
}