package com.Object;

import java.util.ArrayList;
import java.util.Collection;

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
        return haut.getPlayer() != null && bas.getPlayer() != null && droite.getPlayer() != null && gauche.getPlayer() != null;
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

    public ArrayList<Cote> getAllCote() {
        ArrayList<Cote> list = new ArrayList<>();
        list.add(getBas());
        list.add(getDroite());
        list.add(getHaut());
        list.add(getGauche());
        return list;
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

    public Collection<? extends Cote> getAllCoteNotTaken() {
        ArrayList<Cote> list = new ArrayList<>();
        if(getBas().getPlayer() == null){
            list.add(getBas());

        }
        if(getDroite().getPlayer() == null){
            list.add(getDroite());

        }
        if(getHaut().getPlayer() == null){
            list.add(getHaut());

        }
        if(getGauche().getPlayer() == null){
            list.add(getGauche());

        }
        return list;

    }

    public Cote getCoteNotTaken() {
        if(getBas().getPlayer() == null){
            return getBas();

        }
        if(getDroite().getPlayer() == null){
            return getDroite();

        }
        if(getHaut().getPlayer() == null){
            return getHaut();

        }
        if(getGauche().getPlayer() == null){
            return getGauche();

        }
        return null;
    }
}
