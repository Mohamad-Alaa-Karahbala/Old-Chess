package org.Frozen;

import javax.swing.*;

public class Frame extends JFrame {

       public Frame(){
        this.add(new Baseboard());
        this.setTitle("Chess");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);


    }

}
