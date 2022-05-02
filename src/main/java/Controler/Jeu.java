package Controler;

import java.util.Scanner;

import Modele.Joueur;
import Modele.Coup;
import Modele.Gaufre;

public class Jeu {
	public Gaufre g;
	Joueur j1, j2;//joueurs : 0 : joueur humain, 1 : ordinateur
	int joueur_courant;

	int numero_global=0;
	IAAleatoire IAal;
	boolean debut;
	
	
	public Jeu(int hauteur , int largeur, int joueur1 , int joueur2) {
		j1 = new Joueur(1);
		j2 = new Joueur(2);
		g = new Gaufre(hauteur,largeur);
		debut=true;
	}
	
	public void demander() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Types de joueurs :");
			System.out.println("Humain (vous-meme) : 1");
			System.out.println("Ordinateur aleatoire : 2");
			System.out.println("Ordinateur avance : 3");
			System.out.println("Veuillez indiquer de quel type est le joueur 1 : ");
			String s1 = s.nextLine();  // Read user input
			Integer typeJ1 = Integer.valueOf(s1);
			while(typeJ1!=1 && typeJ1!=2 && typeJ1!=3) {
				System.out.println("Erreur ! Veuillez entrer un nombre entre 1 et 3 :");
				s1 = s.nextLine();  // Read user input
				typeJ1 = Integer.valueOf(s1);
			}
			System.out.println("Veuillez indiquer de quel type est le joueur 2 : ");
			String s2 = s.nextLine();  // Read user input
			Integer typeJ2 = Integer.valueOf(s2);
			while(typeJ2!=1 && typeJ2!=2 && typeJ2!=3) {
				System.out.println("Erreur ! Veuillez entrer un nombre entre 1 et 3 :");
				s2 = s.nextLine();  // Read user input
				typeJ2 = Integer.valueOf(s2);
			}
			if (typeJ1 == 2 || typeJ2 == 2){
				IAal = new IAAleatoire(); // à revoir
			}
			if (typeJ1 == 3 || typeJ2 == 3){
				//Cr�ation de l IA expert
			}
			j1.typeJ=typeJ1;
			j2.typeJ=typeJ2;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		demarrer();
	}

	public void demarrer() {
		while(!g.estMangePoison()) {
			jouer();
			g.afficher();
			System.out.println("Progression du jeu : "+g.progression()+"%");
			if (joueur_courant==1){
				joueur_courant=2;
			}else{
				joueur_courant=1;
			}
		}
		System.out.println("Le joueur "+joueur_courant+" a gagn�!");
	}
	
	public void jouer() {
		if(debut) {
			joueur_courant=1; //demander a l 'utilisateur par la suite
			debut = false;
		}
		switch (joueur_courant){
			case 1:
				joue(j1);
				break;
			case 2:
				joue(j2);
				break;
		}
	}
	
	public void joue(Joueur j){
		switch (j.typeJ){
			case 1: //Humain
				//attend clic souris
				break;
			case 2: //IA Random
				Coup c = IAal.coupIA(g,j.numeroJoueur);
				System.out.println(c.toString());
				j.ajoute_nouveau_coup(c);
				g.croquer(c.x,c.y);
				break;
			case 3: //IA Expert
				break;
		}
	}
}
