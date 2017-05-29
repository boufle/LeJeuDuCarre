package com.Bot;

import com.Object.Carre;
import com.Object.Cote;

/**
 * Created by theobeaudenon on 29/05/2017.
 */
public class BotUtils {


    public static Cote isNearCompleted(Carre[][] plateau, int i, int z) {


        Carre carre = plateau[i][z];
        int count = 0;
        if (carre.getHaut().getPlayer() != null){
            count++;
        }
        if (carre.getBas().getPlayer() != null){
            count++;
        }
        if (carre.getDroite().getPlayer() != null){
            count++;
        }
        if (carre.getGauche().getPlayer() != null){
            count++;
        }

        if(count == 3){
            if (carre.getHaut().getPlayer() == null){
                return carre.getHaut();
            }
            if (carre.getBas().getPlayer() == null){
                return carre.getBas();
            }
            if (carre.getDroite().getPlayer() == null){
                return carre.getDroite();
            }
            if (carre.getGauche().getPlayer() == null){
                return carre.getGauche();
            }
        }

        return null;
    }
}
