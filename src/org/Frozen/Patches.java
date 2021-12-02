package org.Frozen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Patches extends JPanel {
    public static int ScreenWidth = Baseboard.ScreenWidth;
    public static int ScreenHeight = Baseboard.ScreenHeight;
    public static int BlockSizeH = Baseboard.BlockSizeH;
    public static int BlockSizeW = Baseboard.BlockSizeW;
    public Dimension[] patchD = new Dimension[65];
    ArrayList<Integer> blackPatches = new ArrayList<Integer>(65);
    ArrayList<Integer> whitePatches = new ArrayList<Integer>(65);
    ArrayList<Integer> allPatches = new ArrayList<Integer>(65);
    public static ArrayList<Patch> patches = new ArrayList<Patch>(64);
    public static ArrayList<JPanel> allPatch = new ArrayList<JPanel>(65);
    public Color patchColor = new Color(0x000000);
    public boolean selected = false;
    public static boolean mode = false;
    public static int first;
    public static int second;



    public Patches() {
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
            patchD[index] = new Dimension(x,y);
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

            Patch patch = new Patch(patchD[i],BlockSizeW,BlockSizeH);
            if (whitePatches.contains(i)){
                patch.getjPanel().setBackground(Color.gray);
            }
            if (blackPatches.contains(i)){
                patch.getjPanel().setBackground(Color.DARK_GRAY);
            }
            patches.add(patch);
            allPatch.add(patch.getjPanel());



        }

    }


   }