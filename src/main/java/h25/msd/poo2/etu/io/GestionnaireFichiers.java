package h25.msd.poo2.etu.io;

import h25.msd.poo2.echange.AlgorithmeI;
import h25.msd.poo2.echange.Dossiers;
import h25.msd.poo2.echange.GestionnaireFichierI;
import h25.msd.poo2.etu.exception.TP3Exception;
import h25.msd.poo2.etu.utilisateur.AbstractUtilisateur;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


public class GestionnaireFichiers implements GestionnaireFichierI {
    private final File dossierTravail = new File("fichiers");
    private final TexteIO texteIO;

    public GestionnaireFichiers() {
        this.texteIO = new TexteIO(); // pas besoin de ApplicationUI
    }

    @Override
    public void prepareDossiersRequis() {
        if (!dossierTravail.exists()) {
            dossierTravail.mkdirs();
        }

        for (Dossiers dossier : Dossiers.values()) {
            File sousDossier = new File(dossierTravail, dossier.name().toLowerCase());
            if (!sousDossier.exists()) {
                sousDossier.mkdirs();
            }
        }
    }

    @Override
    public void viderDossiersFichiers() {
        for (Dossiers dossier : Dossiers.values()) {
            File sousDossier = new File(dossierTravail, dossier.name().toLowerCase());
            File[] fichiers = sousDossier.listFiles();
            if (fichiers != null) {
                for (File fichier : fichiers) {
                    fichier.delete();
                }
            }
        }
    }

    @Override
    public void enregistreTexte(File fichier, String texte) throws TP3Exception {
        try {
            texteIO.enregistreTexte(fichier, texte);
        } catch (RuntimeException e) {
            throw new TP3Exception("Erreur lors de l'enregistrement du fichier texte : " + fichier.getName(), null);
        }
    }

    @Override
    public String chargeTexte(File fichier) throws TP3Exception {
        try {
            return texteIO.chargeText(fichier);
        } catch (RuntimeException e) {
            throw new TP3Exception("Erreur lors du chargement du fichier texte : " + fichier.getName(), null);
        }
    }

    @Override
    public File getDossier(Dossiers dossier) {
        return new File(dossierTravail, dossier.name().toLowerCase());
    }

    @Override
    public void sauvegarderParametreSelectionne(AlgorithmeI algo) throws TP3Exception {

    }

    @Override
    public void chargeParametresDansAlgo(AlgorithmeI algoRecherche) throws TP3Exception {

    }

    @Override
    public void sauvegardeUtilisateur(AbstractUtilisateur abstractUtilisateur) throws TP3Exception {

    }

    @Override
    public AbstractUtilisateur chargeUtilisateur() throws TP3Exception {
        return null;
    }
}
