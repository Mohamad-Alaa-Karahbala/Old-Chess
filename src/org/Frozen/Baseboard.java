package org.Frozen;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Baseboard {
    public static int ScreenWidth = 800;
    public static int ScreenHeight = 800;
    public static int BlockSizeH = ScreenHeight / 8;
    public static int BlockSizeW = ScreenWidth / 8;
    public JLabel jLabel;

    public Baseboard(){
        drawfigures();

    }



    public void drawfigures(){

        for (int i = 1;i <= 64;i++){
            switch (i) {
                case 1, 8 -> setfigures(i, "figures/RookB.png");
                case 2, 7 -> setfigures(i, "figures/KnightB.png");
                case 3, 6 -> setfigures(i, "figures/BishopB.png");
                case 5 -> setfigures(i, "figures/KingB.png");
                case 4 -> setfigures(i, "figures/QweenB.png");
                case 49, 50, 51, 52, 53, 54, 55, 56 -> setfigures(i, "figures/PawnW.png");
                case 57, 64 -> setfigures(i, "figures/RookW.png");
                case 58, 63 -> setfigures(i, "figures/KnightW.png");
                case 59, 62 -> setfigures(i, "figures/BishopW.png");
                case 61 -> setfigures(i, "figures/KingW.png");
                case 60 -> setfigures(i, "figures/QweenW.png");
                case 9, 10, 11, 12, 13, 14, 15, 16 -> setfigures(i, "figures/PawnB.png");
            }
        }
    }



    public void setfigures( int i, String figure){
        jLabel = new JLabel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(figure));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(BlockSizeW-BlockSizeW/10, BlockSizeH-BlockSizeH/10, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        jLabel.setIcon(imageIcon);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        Patches.allPatch.get(i-1).add(jLabel);
        Patches.patches.get(i-1).setBusy(true);



    }

    public void move(int firstPatch, int secondPatch){
        Patch firstPlayer = Patches.patches.get(firstPatch);
        Patch secondPlayer = Patches.patches.get(secondPatch);

        if (Patches.patches.get(firstPatch).isBusy()) {
            Component component = null;
            if (Patches.allPatch.get(firstPatch).getComponent(0) instanceof JLabel) {
                component = Patches.allPatch.get(firstPatch).getComponent(0);
                Patches.allPatch.get(firstPatch).remove(component);
                if (Patches.patches.get(secondPatch).isBusy()) {
                    Patches.allPatch.get(secondPatch).remove(0);
                }
                Patches.allPatch.get(secondPatch).add(component);

            }
            Main.frame.setVisible(true);
            firstPlayer.setBusy(false);
            secondPlayer.setBusy(true);
            firstPlayer.setBusy(false);
            SwingUtilities.updateComponentTreeUI(Main.frame);
        }

    }

    class ResizeListener implements ComponentListener {
        int h;
        int w;

        public void componentHidden(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentShown(ComponentEvent e) {
        }

        public void componentResized(ComponentEvent e) {

            Dimension newSize = e.getComponent().getBounds().getSize();
            h = newSize.height;
            w = newSize.width;
            ScreenWidth = w;
            ScreenHeight = h;
            BlockSizeH = ScreenHeight / 8;
            BlockSizeW = ScreenWidth / 8;



        }

    }
}
