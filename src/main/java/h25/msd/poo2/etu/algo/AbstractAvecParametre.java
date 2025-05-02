
package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.AlgorithmeAvecParametreI;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe abstraite pour les algorithmes de cryptage/décryptage avec paramètres.
 * Etend AbstractAlgoBase et implémente AlgorithmeAvecParametreI pour gérer du paramètre.
 */
public abstract class AbstractAvecParametre extends AbstractAlgoBase implements AlgorithmeAvecParametreI {
    private final Map<String, String> parametres = new HashMap<>();

    public AbstractAvecParametre(String nom) {
        super(nom);
    }

    @Override
    public void setParametre(String nom, String valeur) {
        parametres.put(nom, valeur);
        appliquerParametre(nom, valeur);
    }

    @Override
    public String getParametre(String nom) {
        return parametres.getOrDefault(nom, "");
    }

    @Override
    public Map<String, String> getParametres() {
        return new HashMap<>(parametres);
    }

    public abstract void appliquerParametre(String nom, String valeur);

    @Override
    public abstract String valideParametre(String nom, String valeur);
}

