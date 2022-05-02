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
import Modele.Coup;


public class Fichiers {
	File f;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Sauvegarde lisSauvegarde(File fichier) {
		if(typeFichier==0) {
			ArrayList<String> tab = new ArrayList<String>();
			try {
				FileReader reader=new FileReader(fichier);
				BufferedReader br=new BufferedReader(reader);
				String ligne_lue;
				while((ligne_lue=br.readLine()) != null) {
					tab.add(ligne_lue);
			    }
				Gaufre g;
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
				ArrayList<Coup> listeCoups = new ArrayList<Coup>();
			    br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return new Sauvegarde(g, j1, j2, j_courant);
		}else {
			System.err.println("Erreur : le fichier n'est pas un fichier de sauvegarde.");
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
	
	public void ecrireAjout(File fichier, String texte) {
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
