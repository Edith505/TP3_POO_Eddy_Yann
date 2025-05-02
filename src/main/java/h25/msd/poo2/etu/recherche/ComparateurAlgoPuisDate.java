//Eddy Manoa Randrianarison 2433177
package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.ResultatI;

import java.util.Comparator;

/**
 * Comparateur pour trier les résultats par nom d'algorithme puis par date de cryptage.
 */
public class ComparateurAlgoPuisDate implements Comparator<ResultatI> {

    @Override
    public int compare(ResultatI r1, ResultatI r2) {
        int compareNom = r1.getAlgoUtilise().getNom().compareTo(r2.getAlgoUtilise().getNom());
        if (compareNom != 0) {
            return compareNom;
        }

        return r2.getQuand().compareTo(r1.getQuand());
    }
}