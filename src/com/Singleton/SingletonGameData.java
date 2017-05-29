package com.Singleton;

/**
 * Created by Boufle on 29/05/2017.
 */
public class SingletonGameData {

    private static SingletonGameData ourInstance = new SingletonGameData();

    public static SingletonGameData getInstance() {
        return ourInstance;
    }

    private int compteurTour = 0;

    private SingletonGameData() {

    }

    public int getCompteurTour() {
        return compteurTour;
    }

    public void setCompteurTourIncrement() {
        this.compteurTour ++;
    }

}
