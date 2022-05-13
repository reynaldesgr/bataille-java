package src;

import java.util.ArrayList;
import java.util.Random;


public class Jeu {
    public static final int MAX_CARTES = 5;

    public static void jouerCoup(Joueur J1, Joueur J2){
        boolean isFinish = false;
        ArrayList<Carte> defausseCartes = new ArrayList<>();
        Carte C1game;
        Carte C2game;

        System.out.println(J1.getPaquet());
        System.out.println(J2.getPaquet());
        System.out.print("\n");
        J1.getPaquet().melanger();
        J2.getPaquet().melanger();
        System.out.println(J1.getPaquet());
        System.out.println(J2.getPaquet());

        System.out.println("== BATAILLE ==");

        while(!isFinish){
           C1game = J1.choisirCarte();
           C2game = J2.choisirCarte();
           J1.getPaquet().retirer(C1game);
           J2.getPaquet().retirer(C2game);

           System.out.println(C1game + " VS. " + C2game);
           if(C1game.compareTo(C2game) == -1){
               System.out.println("--> J2 remporte la carte");
               J2.recupererCarte(C1game);
               J2.recupererCarte(C2game);
           }else if(C1game.compareTo(C2game) == 0){
               System.out.println("--> J1 remporte la carte");
               J1.recupererCarte(C2game);
               J1.recupererCarte(C1game);
           }else{
               System.out.println("--> Egalite: Bataille !");
               boolean isBataille = true;
               J1.getPaquet().retirer(C1game);
               J2.getPaquet().retirer(C2game);

               defausseCartes.add(C1game);
               defausseCartes.add(C2game);

               C1game = J1.getPaquet().get(0);
               C2game = J2.getPaquet().get(0);

               J1.getPaquet().retirer(C1game);
               J2.getPaquet().retirer(C2game);

               defausseCartes.add(C1game);
               defausseCartes.add(C2game);

               while(isBataille && !J1.aPerdu() && !J2.aPerdu()){
                C1game = J1.choisirCarte();
                C2game = J2.choisirCarte();
                System.out.println(C1game + " VS. " + C2game);

                defausseCartes.add(C1game);
                defausseCartes.add(C2game);

                J1.getPaquet().retirer(C1game);
                J2.getPaquet().retirer(C2game);

                    if(C1game.compareTo(C2game) == -1){
                        System.out.println("    --> J2 remporte la bataille !");
                        for(Carte k: defausseCartes){
                            J2.recupererCarte(k);
                        }
                        defausseCartes.clear();
                        isBataille = false;
                    }else if(C1game.compareTo(C2game) == 0){
                        System.out.println("    --> J1 remporte la bataille !");
                        for(Carte k: defausseCartes){
                            J1.recupererCarte(k);
                        }
                        defausseCartes.clear();
                        isBataille = false;
                    }else{
                        continue;
                    }
               }
               
           }
           if(J1.aPerdu()){
               isFinish = true;
               System.out.println("J2 remporte la partie.");
           }else if(J2.aPerdu()){
               isFinish = true;
               System.out.println("J1 remporte la partie.");
           }else if(J1.aPerdu() && J2.aPerdu()){
               System.out.println("Egalite.");
           }
            System.out.println("J1 : " + J1.getPaquet());
            System.out.println("J2 : " + J2.getPaquet());
           
           System.out.print("\n");
        }
    }
    
    public static void distribuerPaquet(Joueur J1, Joueur J2){
        ArrayList<Carte> carteP1 = new ArrayList<>();
        ArrayList<Carte> carteP2 = new ArrayList<>();
        creerNouveauPaquet(carteP1, carteP2);

        Paquet P1 = new Paquet(carteP1);
        Paquet P2 = new Paquet(carteP2);
        System.out.println(P1);
        System.out.println(P2);
        J1 = new Humain("Joueur1", P1);
        J2 = new Ordinateur("Joueur2", P2);

        jouerCoup(J1, J2);
    }

    public static void creerNouveauPaquet(ArrayList<Carte> carteP1, ArrayList<Carte> carteP2){

        Random ran = new Random();

        int maxCartes = 12;
        int maxCouleur = 4;

        boolean isFull = false;
        int nbCartes = 0;

        while(!isFull && nbCartes != MAX_CARTES){
            Carte C1 = new Carte(ran.nextInt(maxCartes), ran.nextInt(maxCouleur));
            Carte C2 = new Carte(ran.nextInt(maxCartes), ran.nextInt(maxCouleur));
        
            if(!carteP1.contains(C1) && !carteP2.contains(C2) || (C1.getValeur() != C2.getValeur() && C1.getCouleur() != C2.getCouleur())) {
                carteP1.add(C1);
                carteP2.add(C2);
                nbCartes++;
            }
        
        }
    }

    public static void main(String args[]){
        Joueur J1 = null;
        Joueur J2 = null;
        distribuerPaquet(J1, J2);
    }
}
