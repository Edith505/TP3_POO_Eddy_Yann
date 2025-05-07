package h25.msd.poo2.etu.exception;

import h25.msd.poo2.etu.utilisateur.AbstractUtilisateur;

import java.io.File;

/**
 * Exception contrôlée pour les erreurs de fichier dans l'application.
 * Cette exception étend TP3Exception et ajoute le fichier impliqué.
 */
public class TP3FichierException extends TP3Exception {
    private final File fichier;

    public TP3FichierException(String message, AbstractUtilisateur utilisateur, File fichier) {
        super(message, utilisateur);
        this.fichier = fichier;
    }

    public File getFichier() {
        return fichier;
    }
}