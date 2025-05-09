package h25.msd.poo2.etu.io;

import h25.msd.poo2.echange.AlgorithmeI;
import h25.msd.poo2.echange.Dossiers;
import h25.msd.poo2.echange.GestionnaireFichierI;
import h25.msd.poo2.etu.exception.TP3Exception;
import h25.msd.poo2.etu.exception.TP3FichierException;
import h25.msd.poo2.etu.utilisateur.AbstractUtilisateur;

import java.io.File;
import java.util.Map;


public class GestionnaireFichiers implements GestionnaireFichierI {
    private final TexteIO texteIO;
    private final UtilisateurIO utilisateurIO;
    private final String DOSSIER_BASE = "fichiers";
    private final Map<Dossiers, String> dossiers = Map.of(
            Dossiers.TEXTES_ORIGINAUX, "originaux",
            Dossiers.ENCRYPTIONS, "encryptions",
            Dossiers.PARAMETRES, "parametres",
            Dossiers.UTILISATEURS, "utilisateurs"
    );

    public GestionnaireFichiers() {
        this.texteIO = new TexteIO();
        this.utilisateurIO = new UtilisateurIO();
    }

    @Override
    public void prepareDossiersRequis() {
        // Création du dossier racine
        File dossierRacine = new File(DOSSIER_BASE);
        if (!dossierRacine.exists()) {
            dossierRacine.mkdir();
        }

        // Création des sous-dossiers
        for (Map.Entry<Dossiers, String> entry : dossiers.entrySet()) {
            File sousDossier = new File(dossierRacine, entry.getValue());
            if (!sousDossier.exists()) {
                sousDossier.mkdir();
            }
        }
    }

    @Override
    public void viderDossiersFichiers() {
        for (Map.Entry<Dossiers, String> entry : dossiers.entrySet()) {
            File dossier = getDossier(entry.getKey());
            if (dossier.exists()) {
                File[] fichiers = dossier.listFiles();
                if (fichiers != null) {
                    for (File fichier : fichiers) {
                        if (fichier.isFile()) {
                            fichier.delete();
                        }
                    }
                }
            }
        }
    }

    @Override
    public String chargeTexte(File fichier) throws TP3Exception {
        try {
            return texteIO.chargeText(fichier);
        } catch (TP3FichierException e) {
            String message = "Cher(e) " + e.getUtilisateur().getNom() + ", " + e.getMessage() + "avec le fichier " + e.getFichier().getName();
            throw new TP3Exception(message, e.getUtilisateur());
        }
    }


    @Override
    public void enregistreTexte(File fichier, String texte) throws TP3Exception {
        try {
            texteIO.enregistreTexte(fichier, texte);
        } catch (TP3FichierException e) {
            String message = "Cher(e) " + e.getUtilisateur().getNom() + ", " + e.getMessage() + "avec le fichier " + e.getFichier().getName();
            throw new TP3Exception(message, e.getUtilisateur());
        }
    }

    @Override
    public File getDossier(Dossiers dossier) {
        return new File(DOSSIER_BASE, dossiers.get(dossier));
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
