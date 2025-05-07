//Eddy Manoa Randrianarison: 2433177
package h25.msd.poo2.etu.io;


import h25.msd.poo2.etu.utilisateur.AbstractUtilisateur;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

/*
 * S'occupe des fichiers textes.
 */
public class TexteIO {

    //Enregistre un fichier texte ligne par ligne en respectant le format de ligne utilsé par le système d'exploitation.'
    public void enregistreTexte(File fichier, String texte) {
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

            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'écriture du fichier : " + fichier.getName(), e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la fermeture du fichier : " + fichier.getName(), e);
            }
        }
    }

    //Change un fichier texte standard complet dans une chaîne de caractères.
    public String chargeText(File fichier) {
        if (!fichier.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas : " + fichier.getAbsolutePath());
        }

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            br = new BufferedReader(new FileReader(fichier));
            String ligne;
            while ((ligne = br.readLine()) != null) {
                sb.append(ligne).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier : " + fichier.getName(), e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la fermeture du fichier : " + fichier.getName(), e);
            }
        }
        return sb.toString();
    }

    //Charge le fichier de ressource de l'application.
    public Map<String, String> chargeRessource() {
        File fichier = new File("configuration.txt");
        BufferedReader reader = null;
        Map<String, String> proprietes = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(fichier));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parties = ligne.split(":", 2);
                if (parties.length == 2) {
                    proprietes.put(parties[0].trim(), parties[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement de configuration.txt", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la fermeture de configuration.txt", e);
            }
        }

        return proprietes;
    }

}
