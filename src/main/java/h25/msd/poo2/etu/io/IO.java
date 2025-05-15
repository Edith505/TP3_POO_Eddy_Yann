package h25.msd.poo2.etu.io;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import h25.msd.poo2.echange.AlgorithmeI;
import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.echange.Dossiers;
import h25.msd.poo2.echange.GestionnaireFichierI;
import h25.msd.poo2.etu.algo.DecalageCle;
import h25.msd.poo2.etu.exception.TP3Exception;
import h25.msd.poo2.etu.exception.TP3FichierException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.XMLFormatter;


public class IO {

//    private TexteIO texteIO = new TexteIO();
//    private Map<String, String> config = texteIO.chargeRessource();
//    private File dossierParametres = new File("fichiers/parametres");
//
//    public IO() throws TP3FichierException {
//    }
//
//    private final String dossier = "fichiers/parametres/";
//    private final String extention = "xml";

    private GestionnaireFichierI gestionnaire;
    private String format;
    private ApplicationUI ui ;

    public IO(GestionnaireFichierI gestionnaire ,String format) {
        this.gestionnaire = gestionnaire;
        this.format = format;
    }

    public void sauvegardeAlgo(AlgorithmeI algo) {

        File dossier = gestionnaire.getDossier(Dossiers.PARAMETRES);
        File fichier = new File(dossier, algo.getNom() + "." + format);

        try {
            if (format.equals("json")) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(fichier, algo);
            } else if (format.equals("xml")) {
                XmlMapper mapper = new XmlMapper();
                mapper.writeValue(fichier, algo);
            } else {
                throw new TP3FichierException("Format d'écriture" + format, gestionnaire.chargeUtilisateur(), fichier);
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TP3FichierException e) {
            throw new RuntimeException(e);
        } catch (TP3Exception e) {
            throw new RuntimeException(e);
        }
//        String format = config.getOrDefault("format-fichiers-parametres","json");
//        String nomFichier = algo.getNom() + "." + format;
//        File fichier = new File(dossierParametres, nomFichier);
//
//
//        try {
//            if (format.equalsIgnoreCase("json")) {
//                ObjectMapper objectMapper = new ObjectMapper();
//                objectMapper.writerWithDefaultPrettyPrinter().writeValue(fichier,algo);
//            } else if (format.equalsIgnoreCase("xml")) {
//                XmlMapper xmlMapper = new XmlMapper();
//                xmlMapper.writerWithDefaultPrettyPrinter().writeValue(fichier,algo);
//            }else {
//                throw new IllegalArgumentException("Format de fichier invalide" + format);
//            }
//        }catch (IOException e){
//            throw new RuntimeException("Erreur de sauvegardeAlgo" + algo.getNom(),e);
//        }




//        Creer loe dossier s'il n'existe pas déjà
//        try {
//            Files.createDirectories(Paths.get(dossier));
//
//
//            XmlMapper xmlmapper =  new XmlMapper();
//
//
//            String nomFichier = dossier + algo.getNom() + ":" + extention ;
//
//                xmlmapper.writeValue(new File(nomFichier), algo);
//
//
//            System.out.println("fichier sauvegarder dans " + nomFichier);
//
//        } catch (IOException e) {
//          throw new RuntimeException(e);
//        }
//
//
    }
//
    public AlgorithmeI chargeAlgo(String nomAlgoRecherche){
//
//
//            String nomFichier = dossier + nomAlgoRecherche + ":" + extention;
//            File fichier = new File(nomFichier);
//
//            if (!fichier.exists()){
//                System.out.println("Fichier introuvable : " + nomFichier);
//            }
//
//            XmlMapper xmlMapper = new XmlMapper();
//
//            return null;
//

return null;

    }

    public static void main(String[] args) throws TP3FichierException {
//        IO i = new IO();
//        AlgorithmeI a = new DecalageCle();
//        i.sauvegardeAlgo(a);
//        System.out.println(i);
    }
}
