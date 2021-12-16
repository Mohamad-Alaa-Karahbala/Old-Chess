package org.Frozen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {
    String password = "1234";
    String username = "alaa";
    JButton jButton;
    JTextField jPassword;
    JTextField jUsername;
    Login(){
        JPanel jPanel = new JPanel();
        jPassword = new JTextField();
        jUsername = new JTextField();
        jButton = new JButton("Login");
        jButton.addActionListener(this);
        jButton.setPreferredSize(new Dimension(100,50));
        jPassword.setPreferredSize(new Dimension(500,50));
        jUsername.setPreferredSize(new Dimension(500,50));
        jPanel.add(jUsername);
        jPanel.add(jPassword);
        jPanel.add(jButton);
        Main.frame.setLayout(new FlowLayout());
        Main.frame.add(jPanel);
        Main.frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== jButton){
            if (jPassword.getText().equals(password) && jUsername.getText().equals(username)){
                Main.start();
            }
            else{
                System.out.println("wrong password or username");
            }
        }

    }
}
