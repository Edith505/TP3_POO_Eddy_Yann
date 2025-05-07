package h25.msd.poo2.etu.io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import h25.msd.poo2.echange.AlgorithmeI;
import h25.msd.poo2.etu.algo.DecalageCle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class IO {

    private final String dossier = "fichiers/parametres/";
    private final String extention = "xml";


    public void sauvegardeAlgo(AlgorithmeI algo) {

        //Creer loe dossier s'il n'existe pas déjà
        try {
            Files.createDirectories(Paths.get(dossier));


            XmlMapper xmlmapper =  new XmlMapper();


            String nomFichier = dossier + algo.getNom() + ":" + extention ;

                xmlmapper.writeValue(new File(nomFichier), algo);


            System.out.println("fichier sauvegarder dans " + nomFichier);

        } catch (IOException e) {
          throw new RuntimeException(e);
        }


    }

    public AlgorithmeI chargeAlgo(String nomAlgoRecherche) {


            String nomFichier = dossier + nomAlgoRecherche + "parametre" + extention;
            File fichier = new File(nomFichier);

            if (!fichier.exists()){
                System.out.println("Fichier introuvable : " + nomFichier);
            }

            XmlMapper xmlMapper = new XmlMapper();



        return null;
    }

    public static void main(String[] args) {
        IO i = new IO();
        AlgorithmeI a = new DecalageCle();
        i.sauvegardeAlgo(a);
        System.out.println(i);
    }
}
