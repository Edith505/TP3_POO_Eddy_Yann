package h25.msd.poo2.etu;



//**********************************************************
//   Remplacer cette classe par la votre (celle du tp2)    *
//**********************************************************


import h25.msd.poo2.echange.ApplicationModelI;
import h25.msd.poo2.echange.ApplicationUI;
import h25.msd.poo2.etu.io.GestionnaireFichiers;

public class Model implements ApplicationModelI {
    private GestionnaireFichiers gestionnaireDossiers;


    @Override
    public void initialise(ApplicationUI ui) {

    }

    @Override
    public String getNomsAuteurs() {
        return "Eddy & Yann";
    }


}
