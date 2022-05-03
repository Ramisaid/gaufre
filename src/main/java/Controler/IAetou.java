package Controler;

import java.util.Hashtable;
import java.util.Random;

import Modele.*;
import Structures.*;

public class IAetou implements IA {
    Sequence<Coup> s;
    int jC;
    int largeur, hauteur;
    Hashtable<String, Boolean> hash;

    IAetou() {
        hash = new Hashtable<>();
    }

    public Coup coupIA(Gaufre g, int numero_joueur) { // renvoie un random de la sequence de coup
        s = new SequenceTableau<Coup>();
        jC = numero_joueur;
        this.largeur = g.largeur;
        this.hauteur = g.hauteur;
        Configuration c = new Configuration(g.tableau, jC);
        Random r = new Random();
        if (calcul_joueur_A(c, 0)) {
            System.out.println("jeux gagnant");
            int k1 = r.nextInt(s.length());
            Iterateur<Coup> it1 = s.iterateur();
            int compt1 = 0;
            while (it1.aProchain()) {
                if (compt1 == k1) {
                    return it1.prochain();
                } else {
                    it1.prochain();
                }
                compt1++;
            }
        } else {
            System.out.println("Jeux perdant");
            Sequence<Coup> possibles = chercheCoups(c);
            int k2 = r.nextInt(possibles.length());
            Iterateur<Coup> it2 = possibles.iterateur();
            int compt2 = 0;
            while (it2.aProchain()) {
                if (compt2 == k2) {
                    return it2.prochain();
                } else {
                    it2.prochain();
                }
                compt2++;
            }
            System.out.println("k2 = " + k2 + "et compt2 = " + compt2);
        }
        System.out.println("Pas de coups trouvés");
        return null;
    }

    Boolean calcul_joueur_A(Configuration c, int compt) {
        if (c.tableau[0][0] != 2) {
            return true;
        } else {
            Sequence<Coup> possibles = chercheCoups(c);
            Boolean flag = false;
            Boolean temp;
            Iterateur<Coup> it = possibles.iterateur();
            while (it.aProchain()) {
                Coup p = it.prochain();
                Configuration nouv = nextConf(c, p);
                if (hash.containsKey(hashcode(nouv))) {
                    temp = hash.get(hashcode(nouv));
                } else {
                    temp = calcul_joueur_B(nouv, compt + 1);
                    hash.put(hashcode(nouv), temp);
                }
                if (compt == 0 && temp) {
                    s.insereQueue(p);
                }
                flag = flag | temp;
            }
            return flag;
        }
    }

    Boolean calcul_joueur_B(Configuration c, int compt) {
        if (c.tableau[0][0] != 2) {
            return false;
        } else {
            Sequence<Coup> possibles = chercheCoups(c);
            Boolean flag = true;
            Boolean temp;
            Iterateur<Coup> it = possibles.iterateur();
            while (it.aProchain()) {
                Coup p = it.prochain();
                Configuration nouv = nextConf(c, p);
                if (hash.containsKey(hashcode(nouv))) {
                    temp = hash.get(hashcode(nouv));
                } else {
                    temp = calcul_joueur_A(nouv, compt + 1);
                    hash.put(hashcode(nouv), temp);
                }
                flag = flag & temp;
            }
            return flag;
        }
    }

    Configuration nextConf(Configuration cf, Coup cp) {// methode qui calcule une Configuration a partir d un coup et de
                                                       // la precedente
        // Configuration
        int nouvJoueur;
        if (cf.joueurCourant != cp.numero_joueur) {
            return null;
        }
        int[][] t = new int[largeur][hauteur];
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                if (i >= cp.x && j >= cp.y) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = cf.tableau[i][j];
                }
            }
        }
        if (cp.numero_joueur == 1) {
            nouvJoueur = 2;
        } else {
            nouvJoueur = 1;
        }
        return new Configuration(t, nouvJoueur);

    }

    Sequence<Coup> chercheCoups(Configuration c) {
        Sequence<Coup> res = new SequenceTableau<Coup>();
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                if (c.tableau[i][j] == 1) {
                    res.insereQueue(new Coup(i, j, c.joueurCourant));
                }
            }
        }
        if (res.estVide()) {
            res.insereQueue(new Coup(0, 0, c.joueurCourant));
        }
        return res;
    }

    void afficheConfiguration(Configuration c) {
        System.out.println("Configuration :");
        System.out.println("C'est au joueur numero " + c.joueurCourant + " de jouer");
        for (int i = 0; i < largeur; i++) {// lignes
            for (int j = 0; j < hauteur; j++) {// colonnes
                int v = c.tableau[i][j];
                System.out.print("|" + v);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    String transformeConfiguration(Configuration c) {
        String res = "";
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                res += c.tableau[i][j];
            }
        }
        res += c.joueurCourant;
        return res;
    }

    String hashcode(Configuration c) {
        return transformeConfiguration(c) + jC;
    }
}