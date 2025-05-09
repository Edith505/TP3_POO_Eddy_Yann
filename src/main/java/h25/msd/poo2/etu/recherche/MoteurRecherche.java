package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.CritereTri;
import h25.msd.poo2.echange.MoteurRechercheI;
import h25.msd.poo2.echange.ResultatI;

import java.util.*;

public class MoteurRecherche implements MoteurRechercheI {



    private final List<ResultatI> resultats = new ArrayList<>();


    @Override
    public void ajouteResultat(ResultatI resultat) {
        resultats.add(resultat);
    }

    @Override
    public Set<ResultatI> recherche(String motRecherche) {
        Set<ResultatI> result = new HashSet<>();
        for (ResultatI res : resultats) {
            if (res.getTexteOriginal().contains(motRecherche)) {
                result.add(res);
            }
        }

        return result;

    }

    @Override
    public Collection<ResultatI> getResultats() {
        return resultats;
    }

    //Eddy Manoa Randrianarison: 2433177
    @Override
    public void triResultat(CritereTri critereTri, List<ResultatI> resultats) {
        if (!(resultats == null || resultats.isEmpty())) {
            switch (critereTri) {
                case ALGO_PUIS_TAILLE_TEXTE_ORIGINAL:
                    resultats.sort(new ComparateurAlgoPuisTaille());
                    break;
                case ALGO_PUIS_DATE:
                    resultats.sort(new ComparateurAlgoPuisDate());
                    break;
                case NOMBRE_UTILISATION_PUIS_DATE:
                    resultats.sort(new ComparateurUsagesPuisDate());
                    break;
                default:
                    Collections.sort(resultats);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MoteurRecherche moteur = new MoteurRecherche();
        ResultatI resultatI;
//        moteur.ajouteResultat();
    }


}
