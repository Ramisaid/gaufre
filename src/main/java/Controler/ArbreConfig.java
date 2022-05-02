package Controler;

import Structures.*;
import Modele.Gaufre;

public class Config {
    int[][] tableau;
    int Njoueurcourant;
    int Njoueurgagnant;

    Config(int[][] tableau){
        this.tableau=tableau;
    }
}


public class ArbreConfig {
    Config e;
    Sequence<ArbreConfig> fils = new SequenceTableau<>();
    int numJ;
    int[][] tableau;



    ArbreConfig(Gaufre g, int numJcommence){
        numJ = numJcommence;
        tableau = g.tableau;
        e = new Config(tableau);
    }

    void MajJoueurGagnant(){
        
    }
}