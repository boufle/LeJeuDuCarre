package com.Game;
import com.Bot.BotUtils;
import com.Object.Carre;
import com.Object.Cote;

import java.util.ArrayList;


/**
 * Created by theobeaudenon on 29/05/2017.
 */

public class GameInstance {

    int carreX = 5;
    int carreY = 5;

    Carre[][] plateau= new Carre[carreX][carreY];

    public GameInstance() {

        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
               Cote gauche =  new Cote();
               Cote haut =  new Cote();
                if(z != 0){
                   gauche= plateau[i][z-1].getDroite(); // Renvoi le coté de gauche
                }
                if(i != 0){
                    haut= plateau[i-1][z].getBas(); // Renvoi le coté du haut
                }
               Carre carre = new Carre(haut,new Cote(),new Cote(),gauche);
                carre.setX(z);
                carre.setY(i);
                plateau[i][z] = carre;
            }
        }


        int i = 0;

    }


    public ArrayList<Carre> getCarreFromCote(Cote cote){
        ArrayList<Carre> carreArrayList = new ArrayList<>();
        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){

                if(plateau[i][z].getHaut().equals(cote) ||plateau[i][z].getBas().equals(cote) ||plateau[i][z].getGauche().equals(cote) ||plateau[i][z].getDroite().equals(cote) ){
                    carreArrayList.add(plateau[i][z]) ;
                }

            }
        }
        return carreArrayList;
    }

    public Carre[][] getPlateau() {
        return plateau;
    }

    public Cote playBot() {


        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
                Cote ligne = BotUtils.isNearCompleted(plateau,i,z);
                if(ligne!=null){
                    return ligne;
                }
            }
        }

        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
                Carre carre =   plateau[i][z];
                if(!carre.gotTaken()){

                    if(BotUtils.countCoteCarre(carre) == 2){ // Si le carré a 2 coté pris ne touche pas aux arretes de celui-ci. car sinon l'adversaire termine le carré
                        continue;
                    }
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
            }
        }




        //Solution de dernier secours remplis ce qui est disponible
        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
                Carre carre =   plateau[i][z];
                if(!carre.gotTaken()){

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
            }
        }

        return null;
    }
}
