package Modele;

import java.util.Arrays;
import java.util.LinkedList;

public class Gaufre {
	final int TAILLE_MAX=60;
	public int[][] tableau;
	public int largeur;
	public int hauteur;
	static Position poison;
	public final int POISON=2;
	public final int VIDE=1;
	public final int CROQUE=0;
	int nbCasesCroquees;
	LinkedList<Coup> historique = new LinkedList<Coup>();
	
	public Gaufre(int i, int j){
		tableau = new int[i][j];
		largeur=i;
		hauteur=j;
		poison = new Position(0,0);
		for(int l=0 ; l<largeur ; l++) {//largeur
			for(int h=0 ; h<hauteur ; h++) {//hauteur
				tableau[l][h]=VIDE;
			}
		}
		changePoison(0,0);
	}
	
	public boolean verif(int i, int j) {//v�rifie si une case d'indice i, j est bien situ�e dans le tableau et pas hors du tableau.
		if(i<=hauteur && j<=largeur && i>=0 && j>=0){
			return true;
		}
		return false;
	}
	
	public boolean verifNonCroque(int i, int j) {//renvoie true si la case d'indice i,j n'a pas �t� croqu�e.
		if(tableau[i][j]==CROQUE){
			return false;
		}
		return true;
	}
	
	public void changePoison(int i, int j) {
		if(i>hauteur || j>largeur) {
			System.err.println("Erreur : la nouvelle position de la cases empoisonn�e n'est pas valide.");
		}
		tableau[poison.x][poison.y]=VIDE;
		poison.x=i;
		poison.y=j;
		tableau[poison.x][poison.y]=POISON;
	}
	
	public boolean estMangePoison() {//renvoie true si le poison a �t� mang�.
		int i=poison.x;
		int j=poison.y;
		if(tableau[i][j]==CROQUE) {
			return true;
		}else {
			return false;
		}
	}
	
	public int changeDimensions(int i, int j) {
		if(i<=TAILLE_MAX && i>=2 && j<=TAILLE_MAX && j>=2){
			largeur=i;
			hauteur=j;
			return 0;
		}
		return 1;
	}
	
	public void redimensionne(int i, int j) {
		// ATTENTION : on ne PEUT PAS agrandir le tableau en lignes mais le r�tr�cir en colonnes, ou l'inverse.
		// On doit OBLIGATOIREMENT [agrandir une ligne et/ou une colonne] ou bien [r�tr�cir une ligne et/ou une colonne]
		int oldHauteur=hauteur;
		int oldLargeur=largeur;
		if(changeDimensions(i,j)==0) {
			if(i>oldLargeur || j > oldHauteur) {
				agrandir(i, j, oldLargeur, oldHauteur);
			}else {
				retrecir(i, j);
			}
		}else {
			System.err.println("Erreur : la nouvelle dimension de la gaufre n'est pas valide.");
		}
	}
	
	public void agrandir(int newL, int newH, int oldHauteur, int oldLargeur) {
		int [][] tab = new int[newL][newH];
		for(int i=0 ; i<newL ; i++) {//largeur
			for(int j=0 ; j<newH ; j++) {//hauteur
				if(i>oldLargeur-1 || j > oldHauteur-1) {//si on ne peut pas boucler dans l'ancien tableau, alors on cr�er des nouvelles cellules ayant pour valeur 1
					tab[i][j]=VIDE;
				}else {//sinon, on copie les valeurs de l'ancien tableau dans le nouveau tableau
					tab[i][j]=tableau[i][j];
				}
			}
		}
		tableau=Arrays.copyOf(tab, newL);//on attribue la valeur de tableau au nouveau tableau ainsi cr�er enn faisant une copie du tableau
	}
	
	public void retrecir(int newL, int newH) {
		int [][] tab = new int[newL][newH];
		for(int l=0 ; l<newL ; l++) {//largeur
			for(int h=0 ; h<newH ; h++) {//hauteur
				tab[l][h]=tableau[l][h];
			}
		}
		if(poison.x>newL || poison.y>newH) {//le poison est r�initialis� par d�faut � la case (0,0) si la nouvelle dimension supprime la cellule empoisonn�e.
			changePoison(0,0);
			System.out.println("Le poison est maintenant en (0,0) car le r�tr�cissement de la gaufre a supprim� l'ancienne position du poison.");
		}
		tableau=Arrays.copyOf(tab, newL);//on attribue la valeur de tableau au nouveau tableau ainsi cr�er en faisant une copie du tableau
	}
	
	public void croquer(int i, int j) {// � partir d'une case, d�finit la valeur de toutes les cases � droite et en bas de cette case � CROQUE.
		if(verif(i,j) && verifNonCroque(i,j)) {
			for(int l=i ; l<largeur ; l++) {//largeur
				for(int h=j ; h<hauteur ; h++) {//hauteur
					if(tableau[l][h]!=CROQUE) {
						nbCasesCroquees++;
						tableau[l][h]=CROQUE;
					}
					if(poison.x==l && poison.y==h) {
						System.out.println("Le poison a �t� mang� !");
					}
				}
			}
		}else {
			System.out.println("Impossible de croquer dans cette case.");
		}
	}
	
	public void remplir(int i, int j) {// � partir d'une case, remplit toutes les cases � droite et en bas de cette case � VIDE.
		for(int l=i ; l<largeur ; l++) {//largeur
			for(int h=j ; h<hauteur ; h++) {//hauteur
				if(tableau[l][h]!=VIDE) {
					nbCasesCroquees--;
					tableau[l][h]=VIDE;
				}
			}
		}
	}

	public void afficherHistorique() {//affiche l'historique
        for(Coup c : historique) {
            System.out.println( "joueurs : "+ c.numero_joueur +" -> ["+ c.x + "," + c.y+ "]");
        }
    }
	    
	public void ajouterCoupHistorique(int i, int j, int numero) {
        historique.add(new Coup(i,j,numero)); //ajoute un nouveau coup dans l'historique
    }
	    
	public void retirerCoupHistorique() {
        historique.removeLast(); //supprime le dernier coup dans l'historique
    }
	
	public void reinitialiser() {//r�initialise les valeurs des cases de la gaufre.
		nbCasesCroquees=0;
		for(int l=0 ; l<largeur ; l++) {//largeur
			for(int h=0 ; h<hauteur ; h++) {//hauteur
				tableau[l][h]=VIDE;
			}
		}
		changePoison(0,0);
	}
	
	public float progression() {//renvoie la progression dee la partie en %. Si toutes les cases ont �t� croqu�es, renvoie 100.0%, en d�but de partie, renvoie 0.0%.
		float p=0;
		int nbCases=hauteur*largeur;
		p=nbCasesCroquees/(float)nbCases*100;
		return p;
	}
	
	public void afficher() {//affiche la gaufre dans la console.
		for(int l=0 ; l<largeur ; l++) {//lignes
			for(int h=0 ; h<hauteur ; h++) {//colonnes
				int v=tableau[l][h];
				System.out.print("|"+v);
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
}
