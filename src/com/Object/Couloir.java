package com.Object;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by theobeaudenon on 13/06/2017.
 */
public class Couloir {
    ArrayList<Carre> carres = new ArrayList<>();
    Color color = Color.blue;

    public Couloir(ArrayList<Carre> carres, Color color) {
        this.carres = carres;
        this.color = color;
    }

    public Couloir(Color color) {
        this.color = color;

    }

    public ArrayList<Carre> getCarres() {
        return carres;
    }

    public void setCarres(ArrayList<Carre> carres) {
        this.carres = carres;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean conainCote (Cote cote){
        for (Carre carre : carres) {
           if(carre.getAllCote().contains(cote)){
               return true;
           }
        }
        return false;

    }


}
