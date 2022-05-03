package Tests;

import Controler.Jeu;

public class TestJeu {

    public static void main(String[] args) {
        Jeu j = new Jeu(6, 9, 2, 3);
        j.demarrer();
    }
}