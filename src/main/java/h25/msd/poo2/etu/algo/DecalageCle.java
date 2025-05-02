package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.etu.recherche.ResultatCryptage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DecalageCle extends AbstractAvecParametre {

    private final String CLE = "cle";
    ApplicationUI applicationUI;


    public DecalageCle() {
        super("DecalageCle");
        setParametre("decalage", String.valueOf(CLE));
    }


    @Override
    public void appliquerParametre(String nom, String valeur) {

    }

    @Override
    public String valideParametre(String nom, String valeur) {
        String resultat = valeur;
        if (!"cle".equals(nom)) {
            resultat = "resultat invalide";
        }
        return resultat;
    }

    private List<Integer> getCleCodes() {
        String cle = getParametres().getOrDefault(CLE, "abc");
        List<Integer> codes = new ArrayList<>();
        for (char c : cle.toCharArray()) {
            codes.add(getCaractereEnNombre().getOrDefault(c, getCaractereEnNombre().get('#')));
        }
        return codes;
    }

    @Override
    public String encrypte(String texteLisible) {
        double debut = System.nanoTime();

        List<Integer> contenuCodes = traduitTexteEnListe(texteLisible);
        List<Integer> modifiee = getCleCodes();
        int max = produitCaractereSet().size();
        List<Integer> result = new ArrayList<>();
        int decalage = 0;
        for (int i = 0; i < contenuCodes.size(); i++) {
            decalage = modifiee.get(i % modifiee.size());
            result.add(modulo(contenuCodes.get(i) + decalage, max));
        }

        double fin = System.nanoTime();
        double duree = fin - debut;
        ResultatCryptage resultat = new ResultatCryptage(this,  texteLisible, true);
        this.applicationUI.ajouteResultat(resultat);
        return traduitListeEnTexte(result);
    }

    @Override
    public String decrypte(String texteEncrypte) {
        double debut = System.nanoTime();

        List<Integer> contenuCodes = traduitTexteEnListe(texteEncrypte);
        List<Integer> cleCodes = getCleCodes();
        int max = produitCaractereSet().size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < contenuCodes.size(); i++) {
            int decalage = cleCodes.get(i % cleCodes.size());
            result.add(modulo(contenuCodes.get(i) - decalage, max));
        }
        double fin = System.nanoTime();
        double duree = fin - debut;
        ResultatCryptage resultat = new ResultatCryptage(this, texteEncrypte, false);
        this.applicationUI.ajouteResultat(resultat);
        return traduitListeEnTexte(result);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {
        this.applicationUI = tp2Controller;
    }

    @Override
    public String toString() {
        return "Décalage cle";
    }


}
