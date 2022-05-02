package Tests;

import java.util.Random;

import Modele.Joueur;
import Modele.Coup;

public class TestJoueur{ //Test premier jour class Joueur

    public static void main(String[] args) {
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        int nbcoups=10;
        int taille_grille = 20;
        Random r = new Random();
        int joueur_actu=1;

        System.out.println("Creation de deux joeurs et insertion de coops aléatoires dans leurs historiques");


        for (int i=0; i<nbcoups;i++){
            int x = r.nextInt(taille_grille);
            int y = r.nextInt(taille_grille);
            if (joueur_actu==1){
                Coup c = new Coup(x,y,j1.numeroJoueur);
                System.out.println("J1 -> Coup " + (((int)i/2)+1)+"  : " + c.toString());
                j1.ajoute_nouveau_coup(c);
                joueur_actu=2;
            } else{
                Coup c = new Coup(x,y,j2.numeroJoueur);
                System.out.println("J2 -> Coup " + (((int)i/2)+1) + " : " + c.toString());
                j2.ajoute_nouveau_coup(c);
                joueur_actu=1;
            }
        }  

        System.out.println(j1.toString());
        System.out.println(j2.toString()); 

        String dercoupJ1 = "Dernier coup jouer par j1: ";
        String dercoupJ2 = "Dernier coup jouer par j2: ";
        dercoupJ1 += j1.supprime_dernier_coup().toString();
        dercoupJ2 += j2.supprime_dernier_coup().toString();

        System.out.println(dercoupJ1);
        System.out.println(dercoupJ2); 
    }
}