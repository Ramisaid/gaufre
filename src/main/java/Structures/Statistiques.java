package Structures;

public class Statistiques {//statistiques de plusieurs parties pour un seul joueur
	public int nbPartiesJouees;
	public int nbVictoires;
	Joueur j;
	
	public Statistiques(Joueur j, int nbP, int nbV){
		nbPartiesJouees=nbP;
		nbVictoires=nbV;
		this.j=j;
	}
	
	public float result() {
		return nbVictoires/(float)nbPartiesJouees*100;
	}
}	

