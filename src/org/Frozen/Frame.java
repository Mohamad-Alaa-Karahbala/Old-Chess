package org.Frozen;

import javax.swing.*;

public class Frame extends JFrame {

       public Frame(){
            this.setTitle("Chess");
            this.setSize(Patches.ScreenWidth,Patches.ScreenHeight);
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(true);
       }

}
