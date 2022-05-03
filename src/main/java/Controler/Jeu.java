package Controler;

import java.util.Random;

import Modele.Joueur;
import Modele.Coup;
import Modele.Gaufre;
import java.lang.Thread;

public class Jeu {
	public Gaufre g;
	Joueur j1, j2;// joueurs : 0 : joueur humain, 1 : ordinateur
	int joueur_courant;
	public boolean attenteclic;

	int numero_global = 0;
	IA IA1;
	IA IA2;

	public Jeu(int hauteur, int largeur, int joueur1, int joueur2) {
		j1 = new Joueur(1);
		j1.typeJ = joueur1;
		j2 = new Joueur(2);
		j2.typeJ = joueur2;
		g = new Gaufre(hauteur, largeur);
		attenteclic = true;
		if (j1.typeJ == 2 || j2.typeJ == 2) {
			IA1 = new IAAleatoire(); // Creation de l IA Aleatoire
		}
		if (j1.typeJ == 3 || j2.typeJ == 3) {
			IA2 = new IAetou();// Creation de l IA expert
		}
		Random r = new Random();
		joueur_courant = r.nextInt(2) + 1; // On choisis aleatoirement qui commence
		System.out.println("C'est au joueur numero " + joueur_courant + " de commencer cette partie");
	}

	public void demarrer() {
		while (!g.estMangePoison()) {
			jouer();
			g.afficher();
			System.out.println("Progression du jeu : " + g.progression() + "%");
			if (joueur_courant == 1) {
				joueur_courant = 2;
			} else {
				joueur_courant = 1;
			}
		}
		System.out.println("Le joueur " + joueur_courant + " a gagné!");
	}

	public void jouer() {
		switch (joueur_courant) {
			case 1:
				joue(j1);
				break;
			case 2:
				joue(j2);
				break;
		}
	}

	public void joue(Joueur j) {
		switch (j.typeJ) {
			case 1: // Humain
				while (attenteclic) {
				} // attend clic souris
				attenteclic = true;
				break;
			case 2: // IA Random
				System.out.println();
				System.out.println("Calcul du coup de l'IA facile!");
				Coup c1 = IA1.coupIA(g, j.numeroJoueur);
				System.out.println(c1.toString());
				// try {
				// Thread.sleep(5000);
				// } catch (InterruptedException e) {
				// System.out.println(e);
				// }
				j.ajoute_nouveau_coup(c1);
				g.croquer(c1.x, c1.y);
				break;
			case 3: // IA Expert
				System.out.println();
				System.out.println("Calcul du coup de l'IA expert!");
				Coup c2 = IA2.coupIA(g, j.numeroJoueur);
				System.out.println(c2.toString());
				// try {
				// Thread.sleep(5000);
				// } catch (InterruptedException e) {
				// System.out.println(e);
				// }
				j.ajoute_nouveau_coup(c2);
				g.croquer(c2.x, c2.y);
				break;
		}
	}
}
