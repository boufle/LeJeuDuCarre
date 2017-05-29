package com.Object;

/**
 * Created by theobeaudenon on 29/05/2017.
 */

public class Carre {

    Cote haut;
    Cote bas;
    Cote droite;
    Cote gauche;
    int x;
    int y;

    Integer playerTaken;

    public Carre(Cote haut, Cote bas, Cote droite, Cote gauche) {
        this.haut = haut;
        this.bas = bas;
        this.droite = droite;
        this.gauche = gauche;
    }


    public Boolean gotTaken(){
        return haut.getPlayer() != null && haut.getPlayer() != null && haut.getPlayer() != null && haut.getPlayer() != null;
    }


    public Cote getHaut() {
        return haut;
    }

    public void setHaut(Cote haut) {
        this.haut = haut;
    }

    public Cote getBas() {
        return bas;
    }

    public void setBas(Cote bas) {
        this.bas = bas;
    }

    public Cote getDroite() {
        return droite;
    }

    public void setDroite(Cote droite) {
        this.droite = droite;
    }

    public Cote getGauche() {
        return gauche;
    }

    public void setGauche(Cote gauche) {
        this.gauche = gauche;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
