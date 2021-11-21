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

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintboard(g);
    }

    public void paintboard (Graphics g){
        for (int i = 0; i < 8; i++) {
            g.drawLine(i*ScreenHeight/8,0,i*ScreenHeight/8, ScreenHeight);
            g.drawLine(0,i*ScreenWidth/8,ScreenWidth, i*ScreenWidth/8);
        }
        for (int i = 0; i < 8; i = i + 1) {
            g.fillRect(i*ScreenHeight/8 ,i*ScreenWidth/8,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 6; i = i + 1) {
            g.fillRect(i*ScreenHeight/8+200 ,i*ScreenWidth/8,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 4; i = i + 1) {
            g.fillRect(i*ScreenHeight/8+400 ,i*ScreenWidth/8,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 2; i = i + 1) {
            g.fillRect(i*ScreenHeight/8+600 ,i*ScreenWidth/8,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 6; i = i + 1) {
            g.fillRect(i*ScreenHeight/8,i*ScreenWidth/8+200 ,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 4; i = i + 1) {
            g.fillRect(i*ScreenHeight/8 ,i*ScreenWidth/8+400,ScreenHeight/8 ,ScreenWidth/8);
        }
        for (int i = 0; i < 2; i = i + 1) {
            g.fillRect(i*ScreenHeight/8 ,i*ScreenWidth/8+600,ScreenHeight/8 ,ScreenWidth/8);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        System.out.println("the high is" + this.getSize().height);
//        System.out.println("the width is" + this.getSize().width);

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
            Baseboard.ScreenWidth = w;
            Baseboard.ScreenHeight = h;

        }

    }


}
