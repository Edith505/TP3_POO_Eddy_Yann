package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.ApplicationModelI;
import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.echange.MoteurRechercheI;
import h25.msd.poo2.etu.io.GestionnaireFichiers;

public class ApplicationModel implements ApplicationModelI {

    @Override
    public void initialise(ApplicationUI ui) {
        MoteurRechercheI moteurRecherche = new MoteurRecherche();
        ui.setMoteurRecherche(moteurRecherche);

        GestionnaireFichiers gestionnaireFichiers = new GestionnaireFichiers();
        ui.setGestionnaireFichiers(gestionnaireFichiers);
    }


    @Override
    public String getNomsAuteurs() {
        return "Yann & Eddy";
    }
}
