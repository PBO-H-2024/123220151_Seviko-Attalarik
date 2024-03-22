package controller;

import javax.swing.*;

public class GUI {
    JFrame frame;
    String nim;
    
    public GUI(JFrame frame) {
        this.frame = frame;

        frame.getContentPane().removeAll();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JButton android = new JButton("Android");
        JButton web = new JButton("Web");

        frame.add(android);
        frame.add(web);

        android.setBounds(20, 100, 100, 30);
        web.setBounds(150, 100, 100, 30);

        android.addActionListener(e -> {
            new CHOSEN(frame, "ANDROID");
        });

        web.addActionListener(e -> {
            new CHOSEN(frame, "WEB");
        });

        frame.revalidate();
        frame.repaint();
    }
}
