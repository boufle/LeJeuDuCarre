package com.Windows;

import com.Game.GameInstance;
import com.Object.Carre;
import com.Utils.Enums;
import com.Windows.Component.LigneButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 29/05/2017.
 */
public class MainFrame extends JFrame {

    Carre[][] plateau;

    public MainFrame(int x, int y, GameInstance gameInstance) {

        this.plateau = gameInstance.getPlateau();

        GridLayout gridLayout = new GridLayout(x,y);
        setSize(new Dimension(500,500));
        setLayout(gridLayout);
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                JPanel carre = new JPanel();
                carre.setLayout(new BorderLayout());
                if (j == 0){
                    //on met un trait à gauche
                    LigneButton ligneButtonVerticaleLeft = new LigneButton(Enums.LigneType.VERTICAL, gameInstance);
                    ligneButtonVerticaleLeft.setLigneStat(Enums.LigneStat.LEFT);
                    ligneButtonVerticaleLeft.setCote(plateau[i][j].getGauche());
                    carre.add(ligneButtonVerticaleLeft, BorderLayout.WEST);
                }
                if (i == 0){
                    //on met un trait en haut
                    LigneButton ligneButtonHorrizontaleTop = new LigneButton(Enums.LigneType.HORIZONTAL, gameInstance);
                    ligneButtonHorrizontaleTop.setCote(plateau[i][j].getHaut());
                    ligneButtonHorrizontaleTop.setLigneStat(Enums.LigneStat.TOP);
                    carre.add(ligneButtonHorrizontaleTop, BorderLayout.NORTH);
                }

                LigneButton ligneButtonVerticaleRight = new LigneButton(Enums.LigneType.VERTICAL, gameInstance);
                ligneButtonVerticaleRight.setCote(plateau[i][j].getDroite());
                ligneButtonVerticaleRight.setLigneStat(Enums.LigneStat.RIGHT);
                carre.add(ligneButtonVerticaleRight, BorderLayout.EAST);

                LigneButton ligneButtonHorrizontaleBot = new LigneButton(Enums.LigneType.HORIZONTAL, gameInstance);
                ligneButtonHorrizontaleBot.setCote(plateau[i][j].getBas());
                ligneButtonHorrizontaleBot.setLigneStat(Enums.LigneStat.BOT);
                carre.add(ligneButtonHorrizontaleBot, BorderLayout.SOUTH);

                JPanel jPanel = new JPanel();
                jPanel.setBackground(Color.BLACK);
                carre.add(jPanel, BorderLayout.CENTER);

                add(carre);
            }
        }
        setVisible(true);
    }
}
