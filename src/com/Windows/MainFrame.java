package com.Windows;

import com.Bot.BotUtils;
import com.Game.GameInstance;
import com.Object.Carre;
import com.Singleton.SingletonGameData;
import com.Utils.Enums;
import com.Windows.Component.LigneButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Boufle on 29/05/2017.
 */
public class MainFrame extends JFrame {

    Carre[][] plateau;
    JPanel body = new JPanel();
    JPanel top = new JPanel();
    JComboBox type = new JComboBox();
    JButton reset = new JButton("Play");

    public MainFrame(int x, int y, GameInstance gameInstance) {

        this.plateau = gameInstance.getPlateau();

        GridLayout gridLayout = new GridLayout(x,y);
        setSize(new Dimension(500,500));
        setLayout(new BorderLayout());
        body.setLayout(gridLayout);
        top.setBackground(new Color(140, 140, 140));
        top.add(type);
        top.add(reset);
        type.addItem("Humain vs Humain");
        type.addItem("Bot vs Bot");
        type.addItem("Humain vs Bot");

        if (SingletonGameData.getInstance().getGameType().equals(Enums.GameType.HUMAINVSHUMAIN)){
            type.setSelectedIndex(0);
        }
        else if(SingletonGameData.getInstance().getGameType().equals(Enums.GameType.BOTVSBOT)){
            type.setSelectedIndex(1);
        }
        else if(SingletonGameData.getInstance().getGameType().equals(Enums.GameType.BOTVSHUMAIN)){
            type.setSelectedIndex(2);
        }

        add(body, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);


        play(x,y,gameInstance);

        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (type.getSelectedItem().equals("Humain vs Humain")){
                    SingletonGameData.getInstance().setGameType(Enums.GameType.HUMAINVSHUMAIN);
                    SingletonGameData.getInstance().setCompteurTour(0);
                    GameInstance gameInstance2 = new GameInstance();
                    dispose();
                    MainFrame mainFrame = new MainFrame(5, 5, gameInstance2);
                }
                else if(type.getSelectedItem().equals("Bot vs Bot")){
                    SingletonGameData.getInstance().setGameType(Enums.GameType.BOTVSBOT);
                    SingletonGameData.getInstance().setCompteurTour(0);
                    GameInstance gameInstance2 = new GameInstance();
                    dispose();
                    MainFrame mainFrame = new MainFrame(5, 5, gameInstance2);
                }
                else if(type.getSelectedItem().equals("Humain vs Bot")){
                    SingletonGameData.getInstance().setGameType(Enums.GameType.BOTVSHUMAIN);
                    SingletonGameData.getInstance().setCompteurTour(0);
                    GameInstance gameInstance2 = new GameInstance();
                    dispose();
                    MainFrame mainFrame = new MainFrame(5, 5, gameInstance2);
                }
            }
        });

        setVisible(true);

    }

    public void play(int x, int y, GameInstance gameInstance){
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
                    ligneButtonVerticaleLeft.getCote().setPlayer(null);
                }
                if (i == 0){
                    //on met un trait en haut
                    LigneButton ligneButtonHorrizontaleTop = new LigneButton(Enums.LigneType.HORIZONTAL, gameInstance);
                    ligneButtonHorrizontaleTop.setCote(plateau[i][j].getHaut());
                    ligneButtonHorrizontaleTop.setLigneStat(Enums.LigneStat.TOP);
                    carre.add(ligneButtonHorrizontaleTop, BorderLayout.NORTH);
                    ligneButtonHorrizontaleTop.getCote().setPlayer(null);
                }

                LigneButton ligneButtonVerticaleRight = new LigneButton(Enums.LigneType.VERTICAL, gameInstance);
                ligneButtonVerticaleRight.setCote(plateau[i][j].getDroite());
                ligneButtonVerticaleRight.setLigneStat(Enums.LigneStat.RIGHT);
                carre.add(ligneButtonVerticaleRight, BorderLayout.EAST);
                ligneButtonVerticaleRight.getCote().setPlayer(null);

                LigneButton ligneButtonHorrizontaleBot = new LigneButton(Enums.LigneType.HORIZONTAL, gameInstance);
                ligneButtonHorrizontaleBot.setCote(plateau[i][j].getBas());
                ligneButtonHorrizontaleBot.setLigneStat(Enums.LigneStat.BOT);
                carre.add(ligneButtonHorrizontaleBot, BorderLayout.SOUTH);
                ligneButtonHorrizontaleBot.getCote().setPlayer(null);

                JPanel jPanel = new JPanel();
                // jPanel.setBackground(Color.BLACK);

                carre.add(jPanel, BorderLayout.CENTER);

                body.add(carre);
            }
        }
    }
}
