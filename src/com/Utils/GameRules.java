package com.Utils;

import com.Object.Carre;
import com.Object.Cote;

/**
 * Created by Boufle on 29/05/2017.
 */
public class GameRules {

    public static Carre getCarreWin(Carre carre){
        if (carre.getDroite().getPlayer() != null && carre.getGauche().getPlayer() != null && carre.getBas().getPlayer() != null && carre.getHaut().getPlayer() != null){
            return carre;
        }
        return null;
    }
}
