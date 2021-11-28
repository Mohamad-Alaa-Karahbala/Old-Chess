package org.Frozen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Patches extends JPanel implements MouseListener {
    public static int ScreenWidth = Baseboard.ScreenWidth;
    public static int ScreenHeight = Baseboard.ScreenHeight;
    public static int BlockSizeH = Baseboard.BlockSizeH;
    public static int BlockSizeW = Baseboard.BlockSizeW;
    public static Dimension[] patch = new Dimension[65];
    ArrayList<Integer> blackPatches = new ArrayList<Integer>(65);
    ArrayList<Integer> whitePatches = new ArrayList<Integer>(65);
    ArrayList<Integer> allPatches = new ArrayList<Integer>(65);
    public static ArrayList<JLabel> blackPatch = new ArrayList<JLabel>(65);
    public static ArrayList<JLabel> whitePatch = new ArrayList<JLabel>(65);
    public static ArrayList<JPanel> allPatch = new ArrayList<JPanel>(65);
    public Color patchColor = new Color(0x000000);
    public boolean selected = false;



    public Patches() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        setPatches();
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPatchColor(Color patchColor) {
        this.patchColor = patchColor;
    }

    public void numPatch(){
        int x = 0;
        int y = 0;
        int index = 0;
        while (y/BlockSizeH <= 7){
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
                    allPatches.add(i);
            switch (i) {
                case 1, 3, 5, 7, 10, 12, 14, 16, 17, 19, 21, 23, 26, 28, 30, 32, 33, 35, 37, 39, 42, 44, 46, 48, 49, 51, 53, 55, 58, 60, 62, 64:
                    whitePatches.add(i);
                    break;
                default:
                    blackPatches.add(i);
                    break;
            }

            JPanel jPanel = new JPanel();
            if (whitePatches.contains(i)){
                setPatchColor(Color.GRAY);

            }
            if (blackPatches.contains(i)){
                setPatchColor(Color.DARK_GRAY);
            }
            if (selected){
                setPatchColor(Color.YELLOW);
            }
            jPanel.setBackground(patchColor);
            jPanel.setBounds(patch[i].width,patch[i].height,BlockSizeW,BlockSizeH);
            jPanel.addMouseListener(this);
            allPatch.add(jPanel);


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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        selected = false;

    }
}