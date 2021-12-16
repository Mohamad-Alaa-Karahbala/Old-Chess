package org.Frozen;

import javax.swing.*;

public class Frame extends JFrame {

       public Frame(){
            this.setTitle("Chess");
            this.setSize(Patches.ScreenWidth+16,Patches.ScreenHeight+39);
            this.setLayout(null);
            this.setLocationRelativeTo(this);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
       }

}
