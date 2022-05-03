package Controler;

public class Configuration {
    public int[][] tableau;
    public int joueurCourant;

    Configuration(int[][] tableau, int joueurCourant) {
        this.joueurCourant = joueurCourant;
        this.tableau = tableau;
    }

}
