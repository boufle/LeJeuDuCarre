package com.Listener;

import com.Object.Carre;
import com.Object.Cote;
import com.Singleton.SingletonGameData;
import com.Utils.GameRules;
import com.Windows.Component.LigneButton;

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



        if (ligne instanceof LigneButton) {
            if (((LigneButton) ligne).getCote().getPlayer() == null) {
                if (SingletonGameData.getInstance().getCompteurTour() % 2 == 0) {
                    ((LigneButton) ligne).getCote().setPlayer(1);
                    ((LigneButton) ligne).setPlayer1();
                    for (Carre carre : ((LigneButton) ligne).gameInstance.getCarreFromCote(((LigneButton) ligne).getCote())) {
                        if (GameRules.getCarreWin(carre) != null) {
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) ((LigneButton) ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ((LigneButton) ligne).gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.RED);
                            SingletonGameData.getInstance().setCompteurTourIncrement();
                        }
                    }

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

                SingletonGameData.getInstance().setCompteurTourIncrement();

                playBot((LigneButton) ligne);

            }
        }

    }


    public void playBot(LigneButton ligne){
        Cote botPlayed = ligne.gameInstance.playBot();
        JPanel component = (JPanel) ligne.getParent().getParent().getParent().getComponents()[0];
        for (Component component1 : component.getComponents()) {
            JPanel componentin = (JPanel) component1;
            for (Component component2 : componentin.getComponents()) {
                if (component2 instanceof LigneButton) {
                    LigneButton ligneh = (LigneButton) component2;

                    if (ligneh.getCote().equals(botPlayed)) {
                        ligneh.getCote().setPlayer(2);
                        ligneh.setPlayer2();
                    }
                    for (Carre carre : ligne.gameInstance.getCarreFromCote(botPlayed)) {
                        if (GameRules.getCarreWin(carre) != null) {
                            Carre carre1 = GameRules.getCarreWin(carre);
                            JPanel pane = (JPanel) (ligne).getParent().getParent();
                            JPanel pane1 = (JPanel) pane.getComponent(carre1.getX() + (carre1.getY() * ligne.gameInstance.getPlateau().length));
                            pane1.getComponent(pane1.getComponentCount() - 1).setBackground(Color.magenta);
                            playBot(ligne);
                        }
                    }

                }
            }
        }
        SingletonGameData.getInstance().setCompteurTourIncrement();
    }
}
