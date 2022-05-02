package Structures;
import Modele.Gaufre;
import Modele.Joueur;

public class Sauvegarde {
	Gaufre g;
	Joueur j1;
	Joueur j2;
	int j_courant;//joueur qui doit jouer
	
	public Sauvegarde(Gaufre g, Joueur j1, Joueur j2, int j_courant) {
		this.g=g;
		this.j1=j1;
		this.j2=j2;
		this.j_courant=j_courant;
	}
	
}
