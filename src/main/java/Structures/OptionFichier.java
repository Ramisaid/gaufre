package Structures;

import java.io.File;

public class OptionFichier {
	
	static File dossierSauvegarde = new File("./Sauvegarde");
	static File dossierStat = new File("./Statistiques");
	
	static public void initialisation() {
		if(!dossierSauvegarde.exists()) {
			dossierSauvegarde.mkdir();
		}
		if(!dossierStat.exists()) {
			dossierStat.mkdir();
		}
	}
	
	static public String[] listeSauvegarde() {
		String[] list = dossierSauvegarde.list();
		return list;
	}
	
	static public String[] listeStat() {
		String[] list = dossierStat.list();
		return list;
	}
	
}
