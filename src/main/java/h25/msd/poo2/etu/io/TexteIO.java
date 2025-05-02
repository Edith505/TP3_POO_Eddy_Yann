//Eddy Manoa Randrianarison
package h25.msd.poo2.etu.io;

import java.io.*;
import java.util.Map;

/*
 * S'occupe des fichiers textes.
 */
public class TexteIO {

    //Enregistre un fichier texte ligne par ligneen respectant le format de ligne utilsé par le système d'exploitation.'
    public void enregistreTexte(File fichier, String texte) {
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(fichier.getAbsolutePath());
            fw = new FileWriter(file);
            fw.write(texte);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //Change un fichier texte standard complet dans une chaîne de caractères.
    public String chargeText(File fichier) {
        File file = new File(fichier.getAbsolutePath());

        return null;
    }


    //Charge le fichier de ressource de l'application.
    public Map<String, String> chargeRessource() {


        return null;
    }
}
