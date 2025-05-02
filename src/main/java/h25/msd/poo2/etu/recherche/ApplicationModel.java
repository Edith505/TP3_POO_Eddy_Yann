package h25.msd.poo2.etu.recherche;

import h25.msd.poo2.echange.ApplicationModelI;
import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.echange.MoteurRechercheI;

public class ApplicationModel implements ApplicationModelI {

    @Override
    public void initialise(ApplicationUI ui) {
        MoteurRechercheI moteurRecherche = new MoteurRecherche();
        ui.setMoteurRecherche(moteurRecherche);
    }


    @Override
    public String getNomsAuteurs() {
        return "Yann & Eddy";
    }
}
