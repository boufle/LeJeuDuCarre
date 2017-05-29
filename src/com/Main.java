package com;

import com.Game.GameInstance;
import com.Singleton.SingletonGameData;
import com.Windows.MainFrame;

/**
 * Created by Boufle on 29/05/2017.
 */
public class Main {
    public static void main(String[] args) {

        SingletonGameData.getInstance();

        GameInstance gameInstance = new GameInstance();
        new MainFrame(5,5, gameInstance);
    }
}
