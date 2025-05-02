//Eddy Manoa Randrianarison 2433177
package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.ResultatI;

import java.util.Comparator;

/**
 * Comparateur pour trier les résultats par nombre d'utilisations de l'algorithme puis par date de cryptage.
 */
public class ComparateurUsagesPuisDate implements Comparator<ResultatI> {

    @Override
    public int compare(ResultatI r1, ResultatI r2) {
        int compareUsages = r2.getAlgoUtilise().getNombreUsages() -  r1.getAlgoUtilise().getNombreUsages();
        if (compareUsages != 0) {
            return compareUsages;
        }
        return r2.getQuand().compareTo(r1.getQuand());
    }
}
