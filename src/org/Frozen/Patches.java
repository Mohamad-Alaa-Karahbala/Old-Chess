package org.Frozen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Patches extends JLabel implements MouseListener {
    public static int ScreenWidth = Baseboard.ScreenWidth;
    public static int ScreenHeight = Baseboard.ScreenHeight;
    public static int BlockSizeH = Baseboard.BlockSizeH;
    public static int BlockSizeW = Baseboard.BlockSizeW;
    public static Dimension[] patch = new Dimension[65];
    ArrayList<Integer> blackPatches = new ArrayList<Integer>(65);
    ArrayList<Integer> whitePatches = new ArrayList<Integer>(65);
    public static ArrayList<JLabel> blackPatch = new ArrayList<JLabel>(64);
    public static ArrayList<JLabel> whitePatch = new ArrayList<JLabel>(64);
    public boolean selected = false;

    public Patches() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
        setPatches();
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

    public void setPatches() {
        numPatch();
        for (int i = 1; i <= 64; i++) {
            switch (i) {
                case 1, 3, 5, 7, 10, 12, 14, 16, 17, 19, 21, 23, 26, 28, 30, 32, 33, 35, 37, 39, 42, 44, 46, 48, 49, 51, 53, 55, 58, 60, 62, 64:
                    whitePatches.add(i);
                    break;
                default:
                    blackPatches.add(i);
                    break;
            }
        }
        for (int i = 0; i <= 31; i++) {
            int indexW;
            int indexB;
            indexW = whitePatches.get(i);
            indexB = blackPatches.get(i);
            if (indexB == blackPatches.get(i)) {
                JLabel bLabel = new JLabel();
                if (!selected) {
                    bLabel.setBackground(Color.darkGray);
                }
                else {
                    bLabel.setBackground(Color.YELLOW);
                }
                bLabel.setOpaque(true);
                bLabel.setBounds(patch[indexB].width, patch[indexB].height, BlockSizeW, BlockSizeH);
                blackPatch.add(bLabel);
                this.add(blackPatch.get(i));
            }

            if (indexW == whitePatches.get(i)) {
                JLabel wLabel = new JLabel();
                wLabel.setBackground(Color.lightGray);
                wLabel.setOpaque(true);
                wLabel.setBounds(patch[indexW].width, patch[indexW].height, BlockSizeW, BlockSizeH);
                whitePatch.add(wLabel);
                this.add(whitePatch.get(i));
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        selected =  true;
        System.out.println(selected);
        setPatches();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}