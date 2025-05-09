//Eddy Manoa Randrianarison: 2433177
package h25.msd.poo2.etu.io;


import h25.msd.poo2.etu.exception.TP3FichierException;
import h25.msd.poo2.etu.utilisateur.AbstractUtilisateur;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/*
 * S'occupe des fichiers textes.
 */
public class TexteIO {

    AbstractUtilisateur utilisateur = null;

    //Enregistre un fichier texte ligne par ligne en respectant le format de ligne utilsé par le système d'exploitation.'
    public void enregistreTexte(File fichier, String texte) throws TP3FichierException {
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichier));
            br = new BufferedReader(new StringReader(texte));

            String ligne;
            while ((ligne = br.readLine()) != null) {
                bw.write(ligne);
                bw.write(System.lineSeparator());
            }

        } catch (IOException e) {
            throw new TP3FichierException("il s'est produit une erreur d'écriture avec le fichier : ", utilisateur, fichier);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new TP3FichierException("il s'est produit une erreur de la fermeture du fichier : ", utilisateur, fichier);
            }
        }
    }


    //Change un fichier texte standard complet dans une chaîne de caractères.
    public String chargeText(File fichier) throws TP3FichierException {
        if (!fichier.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas : " + fichier.getAbsolutePath());
        }

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            br = new BufferedReader(new FileReader(fichier));
            String ligne = br.readLine();
            while (ligne != null) {
                sb.append(ligne).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new TP3FichierException("il s'est produit une erreur d'écriture avec le fichier : ", utilisateur, fichier);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new TP3FichierException("il s'est produit une erreur de la fermeture du fichier : ", utilisateur, fichier);
            }
        }
        return sb.toString();
    }

    //Charge le fichier de ressource de l'application.
    public Map<String, String> chargeRessource() throws TP3FichierException {
        String ressource = "configuration.txt";
        BufferedReader br = null;
        Map<String, String> proprietes = new HashMap<>();
        File fichierReference = new File(ressource);

        try {
            InputStream is = TexteIO.class.getClassLoader().getResourceAsStream(ressource);
            if (is == null) {
                throw new FileNotFoundException("Ressource introuvable: " + ressource);
            }

            br = new BufferedReader(new InputStreamReader(is));
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parties = ligne.split(":", 2);
                if (parties.length == 2) {
                    proprietes.put(parties[0], parties[1]);
                }
            }
        } catch (IOException e) {
            throw new TP3FichierException("il s'est produit une erreur de lecture avec la ressource : ", utilisateur, fichierReference);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new TP3FichierException("il s'est produit une erreur de la fermeture de la ressource : ", utilisateur, fichierReference);
            }
        }

        return proprietes;
    }

}
