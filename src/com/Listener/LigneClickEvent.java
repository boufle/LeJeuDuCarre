package com.Listener;

import com.Bot.BotUtils;
import com.Object.Carre;
import com.Object.Cote;
import com.Object.Couloir;
import com.Singleton.SingletonGameData;
import com.Utils.GameRules;
import com.Windows.Component.LigneButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Boufle on 29/05/2017.
 */
public class LigneClickEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ligne = e.getSource();

        boolean isiwin = false;


        if (ligne instanceof LigneButton) {
            if (((LigneButton) ligne).getCote().getPlayer() == null || true) {
                if (SingletonGameData.getInstance().getCompteurTour() % 2 == 569) {
                    ((LigneButton) ligne).getCote().setPlayer(1);
                    ((LigneButton) ligne).setPlayer(1);
                    for (Carre carre : ((LigneButton) ligne).gameInstance.getCarreFromCote(((LigneButton) ligne).getCote())) {
                        if (GameRules.getCarreWin(carre) != null) {
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButton) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButton) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.RED);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                              isiwin = true;

                        }
                    }
                    displaydebug((LigneButton) ligne);

                } else {

                    /* Joueur */

                    /*((LigneButtonHorrizontale) ligne).getCote().setPlayer(2);
                    ((LigneButtonHorrizontale) ligne).setPlayer2();
                    for (Carre carre : ((LigneButtonHorrizontale) ligne).gameInstance.getCarreFromCote(((LigneButtonHorrizontale) ligne).getCote()))
                    {
                        if (GameRules.getCarreWin(carre) != null){
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButtonHorrizontale) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButtonHorrizontale) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount()-1).setBackground(Color.YELLOW);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                        }
                    }*/

                    /* Fin joueur */


                    /* Bot */


                    /* Fin Bot */
                }

                //SingletonGameData.getInstance().setCompteurTourIncrement();

                if(!isiwin){
                    Thread thread = new Thread(){
                        public void run(){
                            boolean b = playBot((LigneButton) ligne, 1);
                            /*boolean b1 = playBot((LigneButton) ligne, 2);
                            if(b || b1){
                                actionPerformed(e);

                            }*/

                        }
                    };

                    thread.start();


                }









            }
        }

    }


    public boolean playBot(LigneButton ligne,int playernumber){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cote botPlayed = ligne.gameInstance.playBot();
        if(botPlayed == null){
            return false;
        }


            JPanel component = (JPanel) ligne.getParent().getParent().getParent().getComponents()[0];
        boolean isiwin = false;
        for (Component component1 : component.getComponents()) {
            JPanel componentin = (JPanel) component1;



            for (Component component2 : componentin.getComponents()) {
                if (component2 instanceof LigneButton) {
                    LigneButton ligneh = (LigneButton) component2;

                    if (ligneh.getCote().equals(botPlayed)) {
                        ligneh.getCote().setPlayer(playernumber);
                        ligneh.setPlayer(playernumber);
                    }
                    for (Carre carre : ligne.gameInstance.getCarreFromCote(botPlayed)) {
                        if (GameRules.getCarreWin(carre) != null) {
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) (ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ligne.gameInstance.getPlateau().length));
                            if(playernumber==2){
                                pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.magenta);

                            }else {
                                pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.red);

                            }

                            isiwin = true;
                            break;
                         }
                    }

                }
            }
        }


      displaydebug(ligne);


        if (isiwin){

            playBot(ligne,playernumber);
        }else {
            SingletonGameData.getInstance().setCompteurTourIncrement();

        }
        return true;

    }

    public void displaydebug(LigneButton ligne){
        //DEBUG
        ArrayList<Couloir> couloirArrayList = BotUtils.getCouloirs(((LigneButton)ligne).gameInstance.getPlateau(),ligne.gameInstance.carreX,ligne.gameInstance.carreY);



        JPanel componentaz = (JPanel) ligne.getParent().getParent().getParent().getComponents()[0];
        for (Component component1 : componentaz.getComponents()) {
            JPanel componentin = (JPanel) component1;


            for (Component component2 : componentin.getComponents()) {
                if (component2 instanceof LigneButton) {
                    LigneButton ligneh = (LigneButton) component2;
                    //  JPanel pane = (JPanel) ligneh.getParent().getParent();
                    //  pane.getComponent(pane.getComponentCount() - 1).setBackground(Color.magenta);

                    for (Carre carre : ((LigneButton)ligne).gameInstance.getCarreFromCote(ligneh.getCote())) {

                        JPanel panev = (JPanel) ((LigneButton)ligne).getParent().getParent();
                        JPanel pane1 = (JPanel) panev.getComponent(carre.getX() + (carre.getY() * ((LigneButton)ligne).gameInstance.getPlateau().length));
                        // playBot(ligne);

                        for (Couloir couloir : couloirArrayList) {
                           if(couloir.getCarres().contains(carre)){
                               pane1.getComponent(pane1.getComponentCount() - 1).setBackground(couloir.getColor());

                           }

                        }



                        if(BotUtils.countCoteCarre(carre) == 2){ // Si le carré a 2 coté pris ne touche pas aux arretes de celui-ci. car sinon l'adversaire termine le carré
                        //    pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.lightGray);

                        }
                        if(BotUtils.countCoteCarre(carre) == 3){ // Si le carré a 2 coté pris ne touche pas aux arretes de celui-ci. car sinon l'adversaire termine le carré
                          //  pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.GRAY);

                        }

                    }



                }
            }
        }
    }
}
