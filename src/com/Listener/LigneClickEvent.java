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
            }
        }





    }
}
