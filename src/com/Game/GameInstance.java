package com.Game;
import com.Bot.BotUtils;
import com.Object.Carre;
import com.Object.Cote;
import com.Object.Couloir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


/**
 * Created by theobeaudenon on 29/05/2017.
 */

public class GameInstance {

    public int carreX = 5;
    public int carreY = 5;

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

        ArrayList<Cote> randomlist = new ArrayList<>();
        for (int i=0 ; i< carreX; i++) {
            for (int z = 0; z < carreY; z++) {
                Carre carre = plateau[i][z];
                if (!carre.gotTaken()) {
                    if (carre.getHaut().getPlayer() == null) {
                        randomlist.add(carre.getHaut());
                        //return carre.getHaut();
                    }
                    if (carre.getBas().getPlayer() == null) {
                        randomlist.add(carre.getBas());

                        //return carre.getBas();
                    }
                    if (carre.getDroite().getPlayer() == null) {
                        randomlist.add(carre.getDroite());
                        // return carre.getDroite();
                    }
                    if (carre.getGauche().getPlayer() == null) {
                        randomlist.add(carre.getGauche());

                        //return carre.getGauche();
                    }
                }
            }

        }
        ArrayList<Cote> blackList = new ArrayList<>();
        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
                Carre carre =   plateau[i][z];

                    if(BotUtils.countCoteCarre(carre) >= 2){ // Si le carré a 2 coté pris ne touche pas aux arretes de celui-ci. car sinon l'adversaire termine le carré
                        blackList.addAll(carre.getAllCoteNotTaken());

                    }else {

                    }


            }
        }
        //System.out.println("blacklist size : "+ blackList.size());

        randomlist.removeAll(blackList);
        //System.out.println("random size : "+ randomlist.size());

        if(randomlist.size()>0){
            return randomlist.get((new Random()).nextInt(randomlist.size()));
        }


        ArrayList<Couloir> couloirArrayList = BotUtils.getCouloirs(plateau,carreX,carreY);

        System.out.println("couloir size : "+ couloirArrayList.size());

        Collections.sort(couloirArrayList, new Comparator<Couloir>() {
            @Override
            public int compare(Couloir o1, Couloir o2) {
                return Integer.compare(o2.getCarres().size(),o1.getCarres().size());
            }
        });

        if(couloirArrayList.size()>0){
            Couloir couloir = couloirArrayList.get(0);
            if(couloir.getCarres().size()>0){
               return couloir.getCarres().get(0).getCoteNotTaken();
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

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
