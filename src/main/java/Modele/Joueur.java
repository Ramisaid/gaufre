package Modele;

import Structures.Sequence;
import Structures.SequenceListe;

public class Joueur {
    public int numeroJoueur;
    Sequence<Coup> historique;
    public int typeJ;

    public Joueur(int numeroJoueur){
        this.numeroJoueur=numeroJoueur;
        historique = new SequenceListe<Coup>();
    }

    int numeroJoueur(){
        return numeroJoueur;
    }

    Sequence<Coup> historique(){ //Renvoie l historique du joueur
        return historique;
    }

    public void ajoute_nouveau_coup(Coup c){ //Ajouter un nouveau coup jou� par le joueur a son historique
        historique.insereTete(c);
    }

    public Coup supprime_dernier_coup(){ //Supprime le dernier coup jou� par le joueur et le renvoie;
        if (!historique.estVide()){
            return historique.extraitTete();
        }
        return null;
    }

    void typeJ(int typeJ){
        this.typeJ=typeJ;
    }

    public String toString() {
        String res = "Numero du joueur: "+ numeroJoueur;
        
        return res + " -> " + historique.toString();
    } 
}