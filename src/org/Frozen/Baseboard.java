package org.Frozen;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class Baseboard extends JPanel implements ActionListener {
    public static int ScreenWidth = 800;
    public static int ScreenHeight = 800;
    public int BlockSizeH = ScreenHeight/8;
    public int BlockSizeW = ScreenWidth/8;



    Baseboard(){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        Timer timer = new Timer(1000,this);
        timer.start();
        this.setBackground(Color.BLACK);
        this.addComponentListener(new ResizeListener());

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintboard(g);
    }

    public void paintboard (Graphics g){
     BlockSizeH = ScreenHeight/8;
     BlockSizeW = ScreenWidth/8;
        int x = 0;
        int y = 0;
        boolean i = false;
        while (y/BlockSizeH < 8){
            g.fillRect(x, y, BlockSizeW, BlockSizeH);
            x += 2 * BlockSizeW;
            if(x/BlockSizeW >= 8){
                y = y + BlockSizeH;
                if (i){
                    x = 0;
                    i = false;
                }
                else {
                    x = BlockSizeW;
                    i = true;
                }
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class ResizeListener implements ComponentListener {
        int h;
        int w;


        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentShown(ComponentEvent e) {}
        public void componentResized(ComponentEvent e) {
            Dimension newSize = e.getComponent().getBounds().getSize();
            h = newSize.height;
            w = newSize.width;
            System.out.println("Resized");
            Baseboard.ScreenWidth = w;
            Baseboard.ScreenHeight = h;
            repaint();

        }

    }


}
