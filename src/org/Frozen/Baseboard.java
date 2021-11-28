package org.Frozen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class Baseboard extends JPanel{
    public static int ScreenWidth = 800;
    public static int ScreenHeight = 800;
    public static int BlockSizeH = ScreenHeight / 8;
    public static int BlockSizeW = ScreenWidth / 8;
    public Patches patches;

    public Baseboard(){
        this.setPreferredSize(new Dimension(ScreenHeight , ScreenWidth));
        this.setBackground(Color.red);
        this.addComponentListener(new ResizeListener());
        patches = new Patches();
        this.add(patches);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawfigures(g);
    }

    public void drawfigures(Graphics g){

        for (int i = 1;i <= 64;i++){
            switch (i) {
                case 1,8:
                    setfigures(g,Patches.patch[i],"figures/RookB.png");
                    break;
                case 2,7:
                    setfigures(g,Patches.patch[i],"figures/KnightB.png");
                    break;
                case 3,6:
                    setfigures(g,Patches.patch[i],"figures/BishopB.png");
                    break;
                case 4:
                    setfigures(g,Patches.patch[i],"figures/KingB.png");
                    break;
                case 5:
                    setfigures(g,Patches.patch[i],"figures/QweenB.png");
                    break;
                case 49,50,51,52,53,54,55,56:
                    setfigures(g,Patches.patch[i],"figures/PawnW.png");
                    break;
                case 57,64:
                    setfigures(g,Patches.patch[i],"figures/RookW.png");
                    break;
                case 58,63:
                    setfigures(g,Patches.patch[i],"figures/KnightW.png");
                    break;
                case 59,62:
                    setfigures(g,Patches.patch[i],"figures/BishopW.png");
                    break;
                case 60:
                    setfigures(g,Patches.patch[i],"figures/KingW.png");
                    break;
                case 61:
                    setfigures(g,Patches.patch[i],"figures/QweenW.png");
                    break;
                case 9,10,11,12,13,14,15,16:
                    setfigures(g,Patches.patch[i],"figures/PawnB.png");
                    break;

            }
        }
    }


    public void setfigures(Graphics g, Dimension dimension, String figure){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(figure);
        g.drawImage(image, dimension.width+(Patches.BlockSizeW/10), dimension.height+(Patches.BlockSizeH/10), Patches.BlockSizeW-2*(Patches.BlockSizeW/10), Patches.BlockSizeH-2*(Patches.BlockSizeH/10), this);
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
            repaint();


        }

    }
}
