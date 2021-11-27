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
    public Dimension[] patch = new Dimension[65];

    public Baseboard(){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        Timer timer = new Timer(1000,this);
        timer.start();
        this.setBackground(Color.darkGray);
        this.addComponentListener(new ResizeListener());
        numPatch();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintboard(g);
        drawfigures(g);

    }

    public void numPatch(){
        int x = 0;
        int y = 0;
        int index = 0;
        boolean i = true;
        while (y/BlockSizeH < 8){
            index++;
            patch[index] = new Dimension(x,y);
            x += BlockSizeW;
            if(x/BlockSizeW >= 8){
                y = y + BlockSizeH;
                x = 0;

            }

        }
    }

    public void drawfigures(Graphics g){
        numPatch();
        for (int i = 1;i <= 64;i++){
            switch (i) {
                case 1,8:
                    drawPawns(g,patch[i],"figures/RookB.png");
                    break;
                case 2,7:
                    drawPawns(g,patch[i],"figures/KnightB.png");
                    break;
                case 3,6:
                    drawPawns(g,patch[i],"figures/BishopB.png");
                    break;
                case 4:
                    drawPawns(g,patch[i],"figures/KingB.png");
                    break;
                case 5:
                    drawPawns(g,patch[i],"figures/QweenB.png");
                    break;
                case 49,50,51,52,53,54,55,56:
                    drawPawns(g,patch[i],"figures/PawnW.png");
                    break;
                case 57,64:
                    drawPawns(g,patch[i],"figures/RookW.png");
                    break;
                case 58,63:
                    drawPawns(g,patch[i],"figures/KnightW.png");
                    break;
                case 59,62:
                    drawPawns(g,patch[i],"figures/BishopW.png");
                    break;
                case 60:
                    drawPawns(g,patch[i],"figures/KingW.png");
                    break;
                case 61:
                    drawPawns(g,patch[i],"figures/QweenW.png");
                    break;
                case 9,10,11,12,13,14,15,16:
                    drawPawns(g,patch[i],"figures/PawnB.png");
                    break;

            }
        }
        repaint();
    }

    public void paintpatches(Graphics g){
        numPatch();
        for (int i = 1;i <= 63;i = i + 2){
            if (patch[i].width <= ScreenWidth) {
                g.fillRect(patch[i].width, patch[i].height, BlockSizeW, BlockSizeH);
            }
            else if (i == ScreenWidth)
                i++;

            System.out.println(i +""+ patch[i]);

        }
    }

    public void paintboard (Graphics g) {

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
    public void drawPawns(Graphics g,Dimension dimension,String figure){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(figure);
        g.drawImage(image, dimension.width, dimension.height, BlockSizeW, BlockSizeH, this);
        repaint();
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
            ScreenWidth = w;
            ScreenHeight = h;
            BlockSizeH = ScreenHeight/8;
            BlockSizeW = ScreenWidth/8;
            repaint();


        }

    }


}
