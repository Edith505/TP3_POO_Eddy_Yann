package h25.msd.poo2.etu.algo;

import h25.msd.poo2.echange.ApplicationUI;

public class InversionPartielle extends AbstractSansParametre{


    public InversionPartielle(String nom) {
        super(nom);
    }

    @Override
    public String encrypte(String texteLisible) {

        char[] chars = texteLisible.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 4) {
            if (i + 3 < chars.length) {
                char tmp = chars[i];
                chars[i] = chars[i + 3];
                chars[i + 3] = tmp;
            }
        }
        return chars.toString();
    }

    @Override
    public String decrypte(String texteEncrypte) {
        return "";
    }

    @Override
    public void setApplicationUI(ApplicationUI tp2Controller) {

    }

    @Override
    public String toString() {
        return "InversionPartielle" ;
    }
}
