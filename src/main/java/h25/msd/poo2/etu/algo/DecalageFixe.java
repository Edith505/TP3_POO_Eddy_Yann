package h25.msd.poo2.etu.algo;


import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.echange.ResultatI;
import h25.msd.poo2.etu.recherche.ResultatCryptage;

import java.util.ArrayList;
import java.util.List;

public class DecalageFixe extends AbstractSansParametre {
    private static final int VALEUR_FIXE = 5;
    ApplicationUI applicationUI;

    public DecalageFixe() {
        super("DecalageFixe");
    }

    @Override
    public String encrypte(String texteLisible) {
        double debut = System.nanoTime();

        List<Integer> valeurs = traduitTexteEnListe(texteLisible);
        List<Integer> modifiees = new ArrayList<>();
        int taille = getCaractereEnNombre().size();
        for (int v : valeurs) {
            modifiees.add((v + VALEUR_FIXE) % taille);
        }

        setNombreUsages(getNombreUsages() + 1);

        double fin = System.nanoTime();
        double duree = fin - debut;
        /*ResultatI resultat = new ResultatCryptage(this, texteLisible, true);
        setApplicationUI(this.applicationUI.ajouteResultat(resultat));*/

        return traduitListeEnTexte(modifiees);
    }

    @Override
    public String decrypte(String texteEncrypte) {
        List<Integer> valeurs = traduitTexteEnListe(texteEncrypte);
        List<Integer> valeursModifiees = new ArrayList<>();
        int taille = getCaractereEnNombre().size();
        for (Integer val : valeurs) {
            int nouveauVal = (val - VALEUR_FIXE) % taille;
            if (nouveauVal < 0) {
                nouveauVal += taille;
            }
            valeursModifiees.add(nouveauVal);
        }

        setNombreUsages(getNombreUsages() + 1);
        return traduitListeEnTexte(valeursModifiees);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {
        this.applicationUI = tp2Controller;

    }

    @Override
    public String toString() {
        return "Décalage Fixe";
    }

    public static void main(String[] args) {
        DecalageFixe test = new DecalageFixe();
        String texte = "DecalageFixe";

        System.out.println(texte);
        String encrypte = test.encrypte(texte);
        System.out.println(encrypte);
        String decrypte = test.decrypte(encrypte);
        System.out.println(decrypte);
    }
}