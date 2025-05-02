package h25.msd.poo2.etu.algo;

import java.util.*;

/**
 * Classe abstraite de base pour les algorithmes de cryptage et décryptage.
 * Fournit des fonctionnalités communes pour la gestion des caractères, la conversion texte-nombre, et le suivi des usages.
 */
public abstract class AbstractAlgoBase {

    private final char CARACTERE_PAR_DEFAUT = '#';
    private final Map<Character, Integer> caractereEnNombre = new HashMap<>();
    private final Map<Integer, Character> nombreEnCaractere = new HashMap<>();

    private String nom;
    private int decalage;
    private int nombreUsages;


    public AbstractAlgoBase(String nom) {
        this.nom = nom;
        this.nombreUsages = 0;
        this.decalage = 5;
        SortedSet<Character> caractereSet = produitCaractereSet();
        construitLettreChiffreTransposition(caractereSet);
    }


    public int getDecalage() {
        return decalage;
    }


    public char getCaractereParDefaut() {
        return CARACTERE_PAR_DEFAUT;
    }

    public Map<Character, Integer> getCaractereEnNombre() {
        return caractereEnNombre;
    }

    public int modulo(int valeur, int taille) {
        return ((valeur % taille) + taille) % taille;
    }

    public String getNom() {
        return nom;
    }

    public int getNombreUsages() {
        return nombreUsages;
    }

    public void setNombreUsages(int nombreUsages) {
        this.nombreUsages = nombreUsages;
    }


    public SortedSet<Character> produitCaractereSet() {
        SortedSet<Character> caractereSet = new TreeSet<>();
        // Ajout des lettres minuscules (a-z)
        for (char i = 'a'; i <= 'z'; i++) {
            caractereSet.add(i);
        }
        // Ajout des lettres majuscules (A-Z)
        for (char i = 'A'; i <= 'Z'; i++) {
            caractereSet.add(i);
        }

        // Ajout des chiffres (0-9)
        for (char i = '0'; i <= '9'; i++) {
            caractereSet.add(i);
        }

        // Ajout des autres caractères
        char[] ponctuation = {' ', ',', '.', ':', ';', '!', '?', '-', '\''};
        for (char c : ponctuation) {
            caractereSet.add(c);
        }
        caractereSet.add(CARACTERE_PAR_DEFAUT);
        return caractereSet;
    }


    /**
     * Construit les maps de conversion caractère-nombre et nombre-caractère. Associe chaque caractère à un indice unique et vice versa.
     *
     * @param tousCaracteres l'ensemble de caractères à associer
     */
    public void construitLettreChiffreTransposition(SortedSet<Character> tousCaracteres) {
        int index = 0;
        for (char c : tousCaracteres) {
            caractereEnNombre.put(c, index);
            nombreEnCaractere.put(index, c);
            index++;
        }
    }

    /**
     * Convertit un texte en une liste d'indices correspondant aux caractères. Les caractères non reconnus sont remplacés par l'indice du caractère par défaut.
     *
     * @param texteOriginal le texte à convertir
     * @return une liste d'indices représentant le texte
     */
    public List<Integer> traduitTexteEnListe(String texteOriginal) {
        List<Integer> list = new ArrayList<>();
        for (char c : texteOriginal.toCharArray()) {
            if (caractereEnNombre.containsKey(c)) {
                list.add(caractereEnNombre.get(c));
            } else {
                list.add(caractereEnNombre.get(CARACTERE_PAR_DEFAUT));
            }
        }
        return list;
    }

    /**
     * Convertit une liste d'indices en un texte en utilisant la map nombre-caractère. Les indices non reconnus sont remplacés par le caractère par défaut.
     *
     * @param caractereList la liste d'indices à convertir
     * @return le texte correspondant
     */
    public String traduitListeEnTexte(List<Integer> caractereList) {
        char[] mot = new char[caractereList.size()];
        int index = 0;
        for (int i : caractereList) {
            mot[index] = nombreEnCaractere.getOrDefault(i, CARACTERE_PAR_DEFAUT);
            index++;
        }
        return new String(mot);
    }
}