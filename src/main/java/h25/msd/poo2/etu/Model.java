package h25.msd.poo2.etu;

//**********************************************************
//   Remplacer cette classe par la vôtre (celle du tp2)    *
//**********************************************************

import h25.msd.poo2.echange.ApplicationModelI;
import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.etu.io.GestionnaireFichiers;
import h25.msd.poo2.echange.MoteurRechercheI;
import h25.msd.poo2.etu.recherche.MoteurRecherche;

public class Model implements ApplicationModelI {

    @Override
    public void initialise(ApplicationUI ui) {
        // Initialisation du moteur de recherche
        MoteurRechercheI moteurRecherche = new MoteurRecherche();
        ui.setMoteurRecherche(moteurRecherche);

        // Initialisation du gestionnaire de fichiers
        GestionnaireFichiers gestionnaire = new GestionnaireFichiers();
        ui.setGestionnaireFichiers(gestionnaire);

    }

    @Override
    public String getNomsAuteurs() {
        return "Eddy & Yann";
    }


}
