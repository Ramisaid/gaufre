package Structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Modele.Gaufre;
import Modele.Joueur;



public class Fichiers {
	public File f;
	int typeFichier;// 0 : sauvegarde ; 1 : autre fichier

	public Fichiers(String texte, int t) {//texte contient le chemin et le nom du fichier
		f=new File(texte);
		if(!f.exists()) {
			try {
				f.createNewFile();
				typeFichier=t;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				f.createNewFile();
				typeFichier=t;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ecrireSauvegarde(Gaufre g, Joueur j1, Joueur j2, int j_courant) {
		if(typeFichier==0) {
			try {
				FileWriter writer=new FileWriter(f,false);//écrire en mode remplacement
				BufferedWriter bw=new BufferedWriter(writer);
				bw.write("numJ1:"+j1.numeroJoueur);
				bw.newLine();
				bw.write("numJ2:"+j2.numeroJoueur);
				bw.newLine();
				bw.write("numJcourant:"+j_courant);
				bw.newLine();
				bw.write("largeur:"+g.largeur);
				bw.newLine();
				bw.write("hauteur:"+g.hauteur);
				bw.newLine();
				bw.write("posPoison:"+ g.poison.x +","+g.poison.y);
				bw.newLine();
				bw.write("listeCoups:");
				for(int k = 0 ; k < g.historique.size() ; k++) {
					bw.write(g.historique.get(k).x + "," + g.historique.get(k).y);
					if(k<g.historique.size()-1) {
						bw.write(":");
					}
				}
				bw.close();
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Erreur : le fichier n'est pas un fichier de sauvegarde.");
		}
	}
	
	public void ecrireSauvegarde(Sauvegarde s) {
		if(typeFichier==0) {
			try {
				FileWriter writer=new FileWriter(f,false);//écrire en mode remplacement
				BufferedWriter bw=new BufferedWriter(writer);
				bw.write("numJ1:"+s.j1.numeroJoueur);
				bw.newLine();
				bw.write("numJ2:"+s.j2.numeroJoueur);
				bw.newLine();
				bw.write("numJcourant:"+s.j_courant);
				bw.newLine();
				bw.write("largeur:"+s.g.largeur);
				bw.newLine();
				bw.write("hauteur:"+s.g.hauteur);
				bw.newLine();
				bw.write("posPoison:"+ s.g.poison.x +","+s.g.poison.y);
				bw.newLine();
				bw.write("listeCoups:");
				for(int k = 0 ; k < s.g.historique.size() ; k++) {
					bw.write(s.g.historique.get(k).x + "," + s.g.historique.get(k).y);
					if(k<s.g.historique.size()-1) {
						bw.write(":");
					}
				}
				bw.close();
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Erreur : le fichier n'est pas un fichier de sauvegarde.");
		}
	}
	
	public Sauvegarde lisSauvegarde() {
		if(typeFichier==0) {
			ArrayList<String> tab = new ArrayList<String>();
			try {
				FileReader reader=new FileReader(f);
				BufferedReader br=new BufferedReader(reader);
				String ligne_lue;
				while((ligne_lue=br.readLine()) != null) {
					tab.add(ligne_lue);
			    }
				if(tab.size()!=7) {//NB DE LIGNES DU FICHIER DE SAUVEGARDE = 7
					System.err.println("Erreur : le fichier de sauvegarde est corrompu."+tab.size());
					return null;
				}
				String[] ligne = tab.get(0).split(":");
				Joueur j1 = new Joueur(Integer.parseInt(ligne[1]));
				ligne = tab.get(1).split(":");
				Joueur j2 = new Joueur(Integer.parseInt(ligne[1]));
				ligne = tab.get(2).split(":");
				int j_courant = Integer.parseInt(ligne[1]);
				ligne = tab.get(3).split(":");
				int largeur = Integer.parseInt(ligne[1]);
				ligne = tab.get(4).split(":");
				int hauteur = Integer.parseInt(ligne[1]);
				ligne = tab.get(5).split(":");
				ligne = ligne[1].split(",");//x d'un côté et y de l'autre
				int poisonX=Integer.parseInt(ligne[0]);
				int poisonY=Integer.parseInt(ligne[1]);
				ligne = tab.get(6).split(":");//liste des coups
				Gaufre g = new Gaufre(largeur,hauteur);
				String[] decoupe;
				int h,l, numJ;
				for(int k=1; k < ligne.length; k++) {
					decoupe = ligne[k].split(",");//x d'un côté et y de l'autre
					h = Integer.parseInt(decoupe[0]); 
					l = Integer.parseInt(decoupe[1]);
					g.croquer(h, l);
					if(k%2 == 1) {
						numJ = j1.numeroJoueur;
					}
					else {
						numJ = j2.numeroJoueur;
					}
					g.ajouterCoupHistorique(h, l, numJ);
				}
			    br.close();
			    reader.close();
			    return new Sauvegarde(g, j1, j2, j_courant);
			}catch(IOException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			System.err.println("Erreur : le fichier n'est pas un fichier de sauvegarde.");
			return null;
		}
	}
	
	public void ecrireStats(Joueur j, int nbP, int nbV) {
		if(typeFichier==1) {
			try {
				FileWriter writer=new FileWriter(f,false);//écrire en mode remplacement
				BufferedWriter bw=new BufferedWriter(writer);
				bw.write("numJ:"+String.valueOf(j.numeroJoueur));
				bw.newLine();
				bw.write("typeJ:"+String.valueOf(j.typeJ));
				bw.newLine();
				bw.write("nombre de parties jouees:"+String.valueOf(nbP));
				bw.newLine();
				bw.write("nombre de victoires:"+String.valueOf(nbV));
				bw.newLine();
				bw.close();
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Erreur : le fichier à écrire n'est pas un fichier de statistiques.");
		}
	}
	
	public Statistiques lisStats() {
		if(typeFichier==1) {
			ArrayList<String> tab = new ArrayList<String>();
			try {
				FileReader reader=new FileReader(f);
				BufferedReader br=new BufferedReader(reader);
				String ligne_lue;
				while((ligne_lue=br.readLine()) != null) {
					tab.add(ligne_lue);
			    }
				if(tab.size()!=4) {//NB DE LIGNES DU FICHIER DE SAUVEGARDE = 4
					System.err.println("Erreur : le fichier de statistiques du joueur est corrompu.");
					return null;
				}
				String[] ligne = tab.get(0).split(":");
				Joueur j = new Joueur(Integer.parseInt(ligne[1]));
				ligne = tab.get(1).split(":");
				j.typeJ=Integer.parseInt(ligne[1]);
				ligne = tab.get(2).split(":");
				int nbP = Integer.parseInt(ligne[1]);
				ligne = tab.get(3).split(":");
				int nbV = Integer.parseInt(ligne[1]);
			    br.close();
			    reader.close();
			    return new Statistiques(j, nbP, nbV);
			}catch(IOException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			System.err.println("Erreur : le fichier n'est pas un fichier de statistiques.");
			return null;
		}
	}
	
	public static void ecrireRemplace(File fichier, String texte) {
		try {
			FileWriter writer=new FileWriter(fichier,false);//écrire en mode remplacement
			BufferedWriter bw=new BufferedWriter(writer);
			bw.write(texte);
			bw.close();
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ecrireAjout(File fichier, String texte) {
		try {
			FileWriter writer=new FileWriter(fichier,true);//écrire en mode ajout
			BufferedWriter bw=new BufferedWriter(writer);
			bw.write(texte);
			bw.newLine();// saut de ligne
			bw.close();
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File createFile(String chemin) throws IOException {
		File fichier=new File(chemin);
		if(!fichier.exists()) {
			try {
				fichier.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			FileWriter writer=new FileWriter(fichier);
			BufferedWriter bw=new BufferedWriter(writer);
			bw.write("");
			bw.close();
			writer.close();
		}
		return fichier;
	}
}