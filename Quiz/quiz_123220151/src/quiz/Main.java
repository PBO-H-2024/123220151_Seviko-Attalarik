package quiz;

import javax.swing.JFrame;

import controller.GUI;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PT. OOP");
        new GUI(frame);
    }
}
