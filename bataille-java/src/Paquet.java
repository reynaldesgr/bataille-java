package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Paquet {
    private ArrayList<Carte> cartes;

    // Constructeur
    public Paquet(ArrayList<Carte> c){
        this.cartes = c;
    }

    @Override
    public String toString(){
        String str = "Paquet : ";
        for(Carte k : cartes){
            str+=k.getValeur() + "-" + k.getCouleur() + "/ ";
        }
        return str;
    }

    public void ajouter(Carte c){
        int taillePaquet = cartes.size();
        if(taillePaquet + 1 < 52){
            cartes.add(c);
        }
    }
    public void retirer(int index){
        cartes.remove(cartes.get(index));
    }
    public Carte retirer(Carte c){
        cartes.remove(c);
        return c;
    }

    public Carte get(int index){ return cartes.get(index);}
    public int taille(){return cartes.size();}
    public boolean estVide(){ return cartes.isEmpty();}

    public void melanger(){
        int taille = taille();
        int x = 2*taille;
        int index1;
        int index2;

        for(int k = 0; k < x; k++){
            index1 = new Random().nextInt(taille);
            index2 = new Random().nextInt(taille);
            if(index1 != index2){
                Collections.swap(cartes, index1, index2);
            }
        }
    } 
}

