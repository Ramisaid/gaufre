package Controler;

import java.util.Random;

import Modele.Coup;
import Modele.Gaufre;

public class IAAleatoire{
    int x;
    int y;
    Random r = new Random();
    int[][] tableau;

    Coup coupIA(Gaufre g,int numero_joueur){
        tableau = g.tableau;

        if (tableau[0][1]== 0 && tableau[1][0]== 0){//S'il ne reste que la case empoisonne dans le tableau
            return new Coup(0,0,numero_joueur);
        }

        int x = r.nextInt(g.largeur);
        int y = r.nextInt(g.hauteur);
        while (tableau[x][y] != 1){//Tant que la case n'est pas croquable
            x = r.nextInt(g.largeur);
            y = r.nextInt(g.hauteur);
        }
        return new Coup(x,y,numero_joueur);
    }
}
