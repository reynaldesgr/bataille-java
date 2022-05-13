package src;

class Carte implements Comparable<Carte>{
    public enum VALEUR{
        AS,
        ROI,
        DAME,
        VALET,
        DIX, 
        NEUF,
        HUIT,
        SEPT,
        SIX,
        CINQ, 
        QUATRE, 
        TROIS,
        DEUX
    }
    private final VALEUR Valeur;
    public enum COULEUR{
        PIQUE,
        COEUR, 
        CARREAU, 
        TREFLE
    }
    private final COULEUR Couleur;

    public Carte(int V, int C){
        this.Valeur = VALEUR.values()[V];
        this.Couleur = COULEUR.values()[C];
    }
    
    public COULEUR getCouleur() {
        return Couleur;
    }

    @Override
    public String toString(){
        return "Carte : " + Valeur + "-" + Couleur;
    }

    @Override
    public int compareTo(Carte c){
        if(getValue(getValeur()) < ((Carte) c).getValue(((Carte) c).getValeur())){
            return -1;
        }else if(getValue(getValeur()) > ((Carte) c).getValue(((Carte) c).getValeur())){
            return 0;
        }else{
            return 1;
        }
    }

    private int getValue(VALEUR valeur) {
        switch(valeur){
            case AS:
                return 14;
            case ROI:
                return 13;
            case DAME:
                return 12;
            case VALET:
                return 11;
            case DIX:
                return 10;
            case NEUF:
                return 9;   
            case HUIT:
                return 8;
            case SEPT:
                return 7;
            case SIX:
                return 6;
            case CINQ:
                return 5;
            case TROIS:
                return 3;
            case DEUX:
                return 2;
            default:
                return 0;
        }
    }

    public VALEUR getValeur() { return Valeur; }  
}
