package src;

import java.util.Random;

abstract public class Joueur {
    private String nom;
    private Paquet paquet;

    public Joueur(String nom, Paquet paquet){
        this.nom = nom;
        this.paquet = paquet;
    }

    public void nouveauJeu(){  }

    public Carte jouer(){ return choisirCarte(); }

    abstract public Carte choisirCarte();


    public void recupererCarte(Carte carte){ paquet.ajouter(carte);}
    public boolean aPerdu(){ return paquet.estVide();}
    
    @Override
    public String toString(){
        return nom + " :" + paquet.toString();
    }
    
    public Paquet getPaquet(){ return paquet;}
} 





class Ordinateur extends Joueur{
    //private Random rand;

    public Ordinateur(String nom, Paquet paquet){
        super(nom, paquet);
    }
    public Carte choisirCarte(){
        int taille = getPaquet().taille();
        int index = new Random().nextInt(taille);

        while(index < 0 || index > getPaquet().taille()){
            index = new Random().nextInt(taille);
        }
        return getPaquet().get(index);
    }
}



class Humain extends Joueur{
    //private Console console;

    public Humain(String nom, Paquet paquet){
        super(nom, paquet);
    }

    public Carte choisirCarte(){
        int index;
        index = -1;
        while(index < 0 || index > getPaquet().taille()){
            System.out.println("========");
            System.out.println(getPaquet());
            System.out.println("Prendre la carte: ");
            System.out.println("========");
            index = Integer.parseInt(System.console().readLine());
        }
        return getPaquet().get(index-1);
    }

}
