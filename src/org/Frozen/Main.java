package org.Frozen;


import javax.swing.*;
import java.awt.*;

public class Main{

     public static Frame frame;
     public static Patches patches;
     public static Baseboard baseboard;
     public static boolean logedin = false;


    public static void main(String[] args) {


            frame = new Frame();
            patches = new Patches();
            for (int i = 0;i <= 63;i++){
                frame.add(Patches.allPatch.get(i));
            }
            baseboard = new Baseboard();

            frame.setVisible(true);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public static void start(){


    }
}
