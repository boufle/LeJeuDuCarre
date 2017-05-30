package com.Windows.Component;

import com.Game.GameInstance;
import com.Listener.LigneClickEvent;
import com.Object.Cote;
import com.Utils.Enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boufle on 29/05/2017.
 */
public class LigneButton extends JButton {

    public Enums.LigneStat ligneStat;
    public Enums.LigneType ligneType;
    public GameInstance gameInstance;
    public Cote cote;

    public LigneButton(Enums.LigneType ligneType, GameInstance gameInstance) {
        this.gameInstance = gameInstance;
        this.ligneType = ligneType;

        if (ligneType.equals(Enums.LigneType.HORIZONTAL)){
            ImageIcon icon = new ImageIcon("resources/Horizontale.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 85, 20,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);

            setSize(new Dimension(100,20));
            setPreferredSize(new Dimension(100,20));
        }
        else if(ligneType.equals(Enums.LigneType.VERTICAL)) {
            ImageIcon icon = new ImageIcon("resources/Verticale.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 20, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);

            setSize(new Dimension(20,100));
            setPreferredSize(new Dimension(20,100));
        }

        addActionListener(new LigneClickEvent());

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public Enums.LigneStat getLigneStat() {
        return ligneStat;
    }

    public void setLigneStat(Enums.LigneStat ligneStat) {
        this.ligneStat = ligneStat;
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }

    public void setPlayer1(){

        if (ligneType.equals(Enums.LigneType.HORIZONTAL)){
            ImageIcon icon = new ImageIcon("resources/HorizontalePlayer1.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 85, 20,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);
        }
        else {
            ImageIcon icon = new ImageIcon("resources/VerticalePlayer1.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 20, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);
        }

    }

    public void setPlayer2(){
        if (ligneType.equals(Enums.LigneType.HORIZONTAL)){
            ImageIcon icon = new ImageIcon("resources/HorizontalePlayer2.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 85, 20,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);
        }
        else {
            ImageIcon icon = new ImageIcon("resources/VerticalePlayer2.png");
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance( 20, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            setIcon(icon);
        }

    }


}
