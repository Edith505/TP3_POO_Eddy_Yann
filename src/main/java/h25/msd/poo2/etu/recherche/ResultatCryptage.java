package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.AlgorithmeI;
import h25.msd.poo2.echange.ResultatI;
import h25.msd.poo2.etu.algo.Symetrique;

import java.time.LocalDateTime;

/**
 * Sert à transmettre les différentes informations liées à chaque opération de cryptage
 * dans l’historique de l’application.
 */
public class ResultatCryptage implements ResultatI {
    private final AlgorithmeI algoUtilise;
    private final LocalDateTime quand;
    private final double dureeTraitement;
    private final String texteOriginal;
    private final String texteFinal;

    /**
     * Constructeur qui effectue l'encryptage ou décryptage directement et mesure la durée.
     *
     * @param algoUtilse l'algorithme à utiliser
     * @param texte le texte d'entrée
     * @param estEncryptage true si c'est un encryptage, false si c'est une décryption
     */
    public ResultatCryptage(AlgorithmeI algoUtilse, String texte, boolean estEncryptage) {
        this.algoUtilise = algoUtilse;
        this.quand = LocalDateTime.now();

        long debut = System.nanoTime();

        if (estEncryptage) {
            this.texteOriginal = texte;
            this.texteFinal = algoUtilse.encrypte(texte);
        } else {
            this.texteOriginal = texte;
            this.texteFinal = algoUtilse.decrypte(texte);
        }

        long fin = System.nanoTime();
        this.dureeTraitement = (fin - debut) ;
    }

    @Override
    public AlgorithmeI getAlgoUtilise() {
        return algoUtilise;
    }

    @Override
    public LocalDateTime getQuand() {
        return quand;
    }

    @Override
    public double getDureeTraitement() {
        return dureeTraitement;
    }

    @Override
    public String getTexteOriginal() {
        return texteOriginal;
    }

    @Override
    public String getTexteFinal() {
        return texteFinal;
    }

    @Override
    public int compareTo(ResultatI other) {
        return this.quand.compareTo(other.getQuand());
    }

    public static void main(String[] args) {
        AlgorithmeI algoUtilse = new Symetrique();
        String texte = "azert17";


        ResultatCryptage resultat = new ResultatCryptage(algoUtilse, texte, true);

        System.out.println("Algo : " + resultat.getAlgoUtilise().getNom() + ", Quand : " + resultat.getQuand() + ", Durée Traitement : " + resultat.getDureeTraitement() + ", Texte Original : " + resultat.getTexteOriginal() + ", Encrypté : " + resultat.getTexteFinal());
    }

}