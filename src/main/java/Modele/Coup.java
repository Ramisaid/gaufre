package Modele;

public class Coup{
    public int x;
    public int y;
    int numero_joueur;

    public Coup(int x, int y, int numero_joueur){
        this.x=x;
        this.y=y;
        this.numero_joueur = numero_joueur;
    } 
    
    public String toString() {
        return "Coup jouer : [" + x + ", " + y + "] par "+numero_joueur;
    }
}
