package Tests;
import Modele.Gaufre;

public class TestGaufre {
	public static void main(String[] args) {
		//String chemin="C:\\Users\\Killian\\Desktop\\images_test\\";
		Gaufre g = new Gaufre(12,11);
		float p;
		
		g.afficher();
		g.croquer(10,8);
		System.out.println();
		g.afficher();
		System.out.println();
		p=g.progression();
		System.out.println(p);
		g.croquer(1,1);
		System.out.println();
		g.afficher();
		p=g.progression();
		System.out.println(p);
		g.croquer(0,0);
		System.out.println();
		g.afficher();
		p=g.progression();
		System.out.println(g.estMangePoison());
		System.out.println(p);
		g.reinitialiser();
		g.afficher();
		System.out.println(g.estMangePoison());
	}
	
}
