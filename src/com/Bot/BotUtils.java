package com.Bot;

import com.Object.Carre;
import com.Object.Cote;
import com.Object.Couloir;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by theobeaudenon on 29/05/2017.
 */
public class BotUtils {


    public static int countCoteCarre(Carre carre) {

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
        return count;
    }



        public static Cote isNearCompleted(Carre[][] plateau, int i, int z) {

            Carre carre = plateau[i][z];

            int count = countCoteCarre(carre);

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

    public static ArrayList<Couloir> getCouloirs(Carre[][] plateau, int carreX, int carreY) {
        ArrayList<Couloir> couloirArrayList = new ArrayList<>();

        for (int i=0 ; i< carreX; i++) {
            for (int z = 0; z < carreY; z++) {
                Carre carre = plateau[i][z];
                     if(BotUtils.countCoteCarre(carre) == 2){
                        boolean taken = false;
                        //On test si le carre a un coté en commun avec un couloir deja existant
                        for (Couloir couloir : couloirArrayList) {
                            for (Cote cote : carre.getAllCoteNotTaken()) {
                                if(couloir.conainCote(cote)){

                                    for (Couloir couloir1 : couloirArrayList) {
                                        if(couloir1.getCarres().contains(carre) && !couloir.equals(couloir1)){
                                            System.out.println("dejadans un carre");

                                            couloir.getCarres().addAll(couloir1.getCarres());
                                            couloir1.getCarres().clear();


                                        }
                                    }


                                    couloir.getCarres().add(carre);
                                    taken = true;
                                    continue;
                                }

                            }


                        }

                        if(!taken){
                            Couloir couloir = new Couloir(new Color((int)(Math.random() * 0x1000000)));
                            couloir.getCarres().add(carre);
                            couloirArrayList.add(couloir);

                        }





                    }

            }

        }


        return couloirArrayList;
    }
}
