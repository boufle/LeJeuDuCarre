package com.Singleton;

import com.Utils.Enums;

/**
 * Created by Boufle on 29/05/2017.
 */
public class SingletonGameData {

    private static SingletonGameData ourInstance = new SingletonGameData();

    public static SingletonGameData getInstance() {
        return ourInstance;
    }

    private int compteurTour = 0;
    private Enums.GameType gameType = Enums.GameType.HUMAINVSHUMAIN;

    private SingletonGameData() {

    }

    public int getCompteurTour() {
        return compteurTour;
    }

    public void setCompteurTourIncrement() {
        this.compteurTour ++;
    }

    public void setCompteurTour(int compteurTour) {
        this.compteurTour = compteurTour;
    }

    public Enums.GameType getGameType() {
        return gameType;
    }

    public void setGameType(Enums.GameType gameType) {
        this.gameType = gameType;
    }
}
