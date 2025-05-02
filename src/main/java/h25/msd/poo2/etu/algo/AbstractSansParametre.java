package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.AlgorithmeI;

/**
 * Classe abstraite pour les algorithmes de cryptage/décryptage sans paramètres.
 * Étend AbstractAlgoBase et implémente AlgorithmeI, fournissant des implémentations par défaut vides
 * pour les méthodes de cryptage et de décryptage.
 */
public abstract class AbstractSansParametre extends AbstractAlgoBase implements AlgorithmeI {
    public AbstractSansParametre(String nom) {
        super(nom);
    }

    @Override
    public abstract String encrypte(String texteLisible);

    @Override
    public abstract String decrypte(String texteEncrypte);
}

