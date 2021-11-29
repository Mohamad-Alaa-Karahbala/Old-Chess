package org.Frozen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Patch extends JPanel implements MouseListener {

    public Color patchColor = new Color(0,0,200);
    public boolean selected = false;
    public boolean busy = false;
    public JPanel jPanel;

    public Patch(Dimension dimension,int x,int y){
        jPanel = new JPanel();
        jPanel.setBounds(dimension.width,dimension.height,x,y);
        jPanel.setBackground(patchColor);
        jPanel.addMouseListener(this);
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPatchColor(Color patchColor) {
        this.patchColor = patchColor;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean isSelected() {
        return selected;
    }

    public Color getPatchColor() {
        return patchColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (selected){
            this.setSelected(false);
        }
        else this.setSelected(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        patchColor = e.getComponent().getBackground();
        e.getComponent().setBackground(new Color(240,230,140));
        if (busy){
            e.getComponent().setBackground(Color.green);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setBackground(patchColor);
    }
}
