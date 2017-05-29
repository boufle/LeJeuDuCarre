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
public class LigneButtonHorrizontale extends JButton {

    public Enums.LigneStat ligneStat;
    public GameInstance gameInstance;
    public Cote cote;

    public LigneButtonHorrizontale() {
        ImageIcon icon = new ImageIcon("resources/Horizontale.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( 85, 10,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        setIcon(icon);

        setSize(new Dimension(100,10));
        setPreferredSize(new Dimension(100,10));

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
        ImageIcon icon = new ImageIcon("resources/HorizontalePlayer1.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( 85, 10,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        setIcon(icon);
    }

    public void setPlayer2(){
        ImageIcon icon = new ImageIcon("resources/HorizontalePlayer2.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( 85, 10,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        setIcon(icon);
    }

}
