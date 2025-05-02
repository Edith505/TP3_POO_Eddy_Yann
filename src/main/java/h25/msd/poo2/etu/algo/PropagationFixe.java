package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.etu.recherche.ResultatCryptage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * */
public class PropagationFixe extends AbstractSansParametre {

    public PropagationFixe() {
        super("PropagationFixe");
    }
    ApplicationUI applicationUI;

    @Override
    public String encrypte(String texteLisible) {
        List<Integer> codes = traduitTexteEnListe(texteLisible);
        int max = produitCaractereSet().size();
        List<Integer> result = new ArrayList<>();

        if (codes.isEmpty()) {
            return "";
        }
        result.add(codes.get(0));
        for (int i = 1; i < codes.size(); i++) {
            int somme = codes.get(i - 1) + codes.get(i);
            result.add(modulo(somme, max));
        }
        return traduitListeEnTexte(result);
    }

    @Override
    public String decrypte(String texteLisible) {

        double debut = System.nanoTime();


        List<Integer> codes = traduitTexteEnListe(texteLisible);
        int max = produitCaractereSet().size();
        List<Integer> result = new ArrayList<>();

        if (codes.isEmpty()) {
            return "";
        }

        result.add(codes.get(0));
        for (int i = 1; i < codes.size(); i++) {
            int precedent = result.get(i - 1);
            int courant = codes.get(i);
            int original = modulo(courant - precedent, max);
            result.add(original);
        }

        double fin = System.nanoTime();
        double duree = fin - debut;
        ResultatCryptage resultat = new ResultatCryptage(this, LocalDateTime.now(), duree, texteLisible, traduitListeEnTexte(result));
        this.applicationUI.ajouteResultat(resultat);
        return traduitListeEnTexte(result);
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {

    }

    @Override
    public String toString() {
        return "Propagation Fixe";
    }
}













