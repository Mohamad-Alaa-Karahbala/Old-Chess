package org.Frozen;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;


public class Baseboard extends JPanel implements ActionListener {
    public static int ScreenWidth = 800;
    public static int ScreenHeight = 800;
    public int BlockSizeH = ScreenHeight/8;
    public int BlockSizeW = ScreenWidth/8;
    public Dimension[] patch = new Dimension[65];
    ArrayList<Integer> blackPatches = new ArrayList<Integer>(65);
    ArrayList<Integer> whitePatches = new ArrayList<Integer>(65);
    public static ArrayList<JLabel> blackPatch = new ArrayList<JLabel>(64);
    public static ArrayList<JLabel> whitePatch = new ArrayList<JLabel>(64);



    public Baseboard(){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        Timer timer = new Timer(1000,this);
        timer.start();
        this.setBackground(Color.BLACK);
        this.addComponentListener(new ResizeListener());
        setPatches();



    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        drawfigures(g);
    }

    public void setPatches(){
            numPatch();
        for (int i = 1; i <= 64; i++){
            switch (i){
                case 1,3,5,7,10,12,14,16,17,19,21,23,26,28,30,32,33,35,37,39,42,44,46,48,49,51,53,55,58,60,62,64:
                    whitePatches.add(i);
                break;
                default:
                    blackPatches.add(i);
            }
        }
        for (int i = 0;i <= 31;i++){
            int indexW;
            int indexB;
                indexW = whitePatches.get(i);
                indexB = blackPatches.get(i);
            if (indexB == blackPatches.get(i)) {
                JLabel bLabel = new JLabel();
                bLabel.setBackground(Color.darkGray);
                bLabel.setBounds(patch[indexB].width, patch[indexB].height, BlockSizeW, BlockSizeH);
                blackPatch.add(bLabel);
                this.add(blackPatch.get(i), i);
            }

            if (indexW == whitePatches.get(i)) {
                JLabel wLabel = new JLabel();
                wLabel.setBackground(Color.lightGray);
                whitePatch.add(wLabel);
                this.add(whitePatch.get(i), i);
            }
        }
    }

    public void numPatch(){
        int x = 0;
        int y = 0;
        int index = 0;
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
                    setfigures(g,patch[i],"figures/RookB.png");
                    break;
                case 2,7:
                    setfigures(g,patch[i],"figures/KnightB.png");
                    break;
                case 3,6:
                    setfigures(g,patch[i],"figures/BishopB.png");
                    break;
                case 4:
                    setfigures(g,patch[i],"figures/KingB.png");
                    break;
                case 5:
                    setfigures(g,patch[i],"figures/QweenB.png");
                    break;
                case 49,50,51,52,53,54,55,56:
                    setfigures(g,patch[i],"figures/PawnW.png");
                    break;
                case 57,64:
                    setfigures(g,patch[i],"figures/RookW.png");
                    break;
                case 58,63:
                    setfigures(g,patch[i],"figures/KnightW.png");
                    break;
                case 59,62:
                    setfigures(g,patch[i],"figures/BishopW.png");
                    break;
                case 60:
                    setfigures(g,patch[i],"figures/KingW.png");
                    break;
                case 61:
                    setfigures(g,patch[i],"figures/QweenW.png");
                    break;
                case 9,10,11,12,13,14,15,16:
                    setfigures(g,patch[i],"figures/PawnB.png");
                    break;

            }
        }
    }

    public void paintpatches(Graphics g){
        numPatch();
        g.setColor(Color.white);
        for (int i = 0; i <= 31;i++) {
            int indexW;
            int indexB;
            indexW = whitePatches.get(i);
            indexB = blackPatches.get(i);
            if (indexW == whitePatches.get(i)) {
                g.setColor(Color.lightGray);
                g.fillRect(patch[indexW].width, patch[indexW].height, BlockSizeW, BlockSizeH);
            }
            if (indexB == blackPatches.get(i)) {
                g.setColor(Color.darkGray);
                g.fillRect(patch[indexB].width, patch[indexB].height, BlockSizeW, BlockSizeH);
            }
        }
    }

    public void setfigures(Graphics g, Dimension dimension, String figure){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(figure);
        g.drawImage(image, dimension.width+(BlockSizeW/10), dimension.height+(BlockSizeH/10), BlockSizeW-2*(BlockSizeW/10), BlockSizeH-2*(BlockSizeH/10), this);
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
