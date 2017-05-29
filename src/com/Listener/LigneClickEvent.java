package com.Listener;

import com.Game.GameInstance;
import com.Object.Carre;
import com.Object.Cote;
import com.Singleton.SingletonGameData;
import com.Utils.GameRules;
import com.Windows.Component.LigneButtonHorrizontale;
import com.Windows.Component.LigneButtonVerticale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Boufle on 29/05/2017.
 */
public class LigneClickEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ligne = e.getSource();



        if (ligne instanceof LigneButtonHorrizontale){
            if (((LigneButtonHorrizontale) ligne).getCote().getPlayer() == null){
                if (SingletonGameData.getInstance().getCompteurTour() % 2 == 0){
                    ((LigneButtonHorrizontale) ligne).getCote().setPlayer(1);
                    ((LigneButtonHorrizontale) ligne).setPlayer1();
                    for (Carre carre : ((LigneButtonHorrizontale) ligne).gameInstance.getCarreFromCote(((LigneButtonHorrizontale) ligne).getCote()))
                    {
                        if (GameRules.getCarreWin(carre) != null){
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButtonHorrizontale) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButtonHorrizontale) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount()-1).setBackground(Color.RED);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                        }
                    }

                }
                else {

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

                SingletonGameData.getInstance().setCompteurTourIncrement();
                Cote botPlayed = ((LigneButtonHorrizontale) ligne).gameInstance.playBot();


                JPanel component = (JPanel) ((LigneButtonHorrizontale) ligne).getParent().getParent().getParent().getComponents()[0];
                for (Component component1 : component.getComponents()) {
                    JPanel componentin = (JPanel) component1;
                    for (Component component2 : componentin.getComponents()) {
                        System.out.println(component2);
                        if (component2 instanceof LigneButtonHorrizontale) {
                            LigneButtonHorrizontale ligneh = (LigneButtonHorrizontale) component2;

                            if (ligneh.getCote().equals(botPlayed)) {
                                ligneh.getCote().setPlayer(2);
                                ligneh.setPlayer2();
                            }

                        } else if (component2 instanceof LigneButtonVerticale) {
                            LigneButtonVerticale ligneh = (LigneButtonVerticale) component2;

                            if (ligneh.getCote().equals(botPlayed)) {
                                ligneh.getCote().setPlayer(2);
                                ligneh.setPlayer2();
                            }
                        }

                    }
                }

            }
        }


        else if (ligne instanceof LigneButtonVerticale){
            if (((LigneButtonVerticale) ligne).getCote().getPlayer() == null){
                if (SingletonGameData.getInstance().getCompteurTour() % 2 == 0){
                    ((LigneButtonVerticale) ligne).getCote().setPlayer(1);
                    ((LigneButtonVerticale) ligne).setPlayer1();
                    for (Carre carre : ((LigneButtonVerticale) ligne).gameInstance.getCarreFromCote(((LigneButtonVerticale) ligne).getCote()))
                    {
                        if (GameRules.getCarreWin(carre) != null){
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButtonVerticale) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButtonVerticale) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount()-1).setBackground(Color.RED);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                        }
                    }
                }
                else {

                    /* Joueur */

                   /* ((LigneButtonVerticale) ligne).getCote().setPlayer(2);
                    ((LigneButtonVerticale) ligne).setPlayer2();
                    for (Carre carre : ((LigneButtonVerticale) ligne).gameInstance.getCarreFromCote(((LigneButtonVerticale) ligne).getCote()))
                    {
                        if (GameRules.getCarreWin(carre) != null){
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButtonVerticale) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButtonVerticale) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount()-1).setBackground(Color.YELLOW);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                        }
                    }*/

                    /* Fin joueur */

                    /* Bot */


                    /* Fin Bot */
                }
                SingletonGameData.getInstance().setCompteurTourIncrement();

                Cote botPlayed = ((LigneButtonVerticale) ligne).gameInstance.playBot();

                JPanel component = (JPanel) ((LigneButtonVerticale) ligne).getParent().getParent().getParent().getComponents()[0];
                for (Component component1 : component.getComponents()) {
                    JPanel componentin = (JPanel) component1;
                    for (Component component2 : componentin.getComponents()) {
                        System.out.println(component2);
                        if (component2 instanceof LigneButtonHorrizontale){
                            LigneButtonHorrizontale ligneh = (LigneButtonHorrizontale) component2;

                            if(ligneh.getCote().equals(botPlayed)){
                                ligneh.getCote().setPlayer(2);
                                ligneh.setPlayer2();
                            }

                        }else if (component2 instanceof LigneButtonVerticale){
                            LigneButtonVerticale ligneh = (LigneButtonVerticale) component2;

                            if(ligneh.getCote().equals(botPlayed)){
                                ligneh.getCote().setPlayer(2);
                                ligneh.setPlayer2();
                            }
                        }

                    }
                }

                int i = 4;

            }
        }





    }
}
