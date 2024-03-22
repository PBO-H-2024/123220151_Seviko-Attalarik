package controller;
import javax.swing.*;

import process.Processing;

public class CHOSEN extends GUI {
    String chosen;
    
    public CHOSEN(JFrame frame, String chosen) {
        super(frame);
        this.frame = frame;
        this.chosen = chosen;
        JLabel judul = new JLabel("Masukkan data");
        JLabel NIMLabel = new JLabel("NIM");
        JLabel scoreExamLabel = new JLabel("Exam Score");
        JLabel codingLabel = new JLabel("Coding Score");
        JLabel interviewLabel = new JLabel("Interview Score");
        JTextField inputNIM = new JTextField();
        JTextField scoreExam = new JTextField();
        JTextField coding = new JTextField();
        JTextField interview = new JTextField();
        JButton submit = new JButton("Submit");
        JButton goBack = new JButton("Go Back");

        frame.getContentPane().removeAll();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        frame.add(judul);
        frame.add(inputNIM);
        frame.add(scoreExam);
        frame.add(NIMLabel);
        frame.add(scoreExamLabel);
        frame.add(coding);
        frame.add(interview);
        frame.add(codingLabel);
        frame.add(interviewLabel);
        frame.add(submit);
        frame.add(goBack);

        judul.setBounds(10, 10, 100, 30);
        NIMLabel.setBounds(10, 60, 100, 30);
        inputNIM.setBounds(150, 60, 100, 30);
        scoreExamLabel.setBounds(10, 100, 100, 30);
        scoreExam.setBounds(150, 100, 100, 30);
        codingLabel.setBounds(10, 140, 100, 30);
        coding.setBounds(150, 140, 100, 30);
        interviewLabel.setBounds(10, 180, 100, 30);
        interview.setBounds(150, 180, 100, 30);
        submit.setBounds(10, 220, 100, 30);
        goBack.setBounds(150, 220, 100, 30);

        submit.addActionListener(e -> {
            if (inputNIM.getText().isEmpty() || scoreExam.getText().isEmpty() || coding.getText().isEmpty() || interview.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                return;
            }

            String nim = inputNIM.getText();
            double exam = Double.parseDouble(scoreExam.getText());
            double code = Double.parseDouble(coding.getText());
            double interviewScore = Double.parseDouble(interview.getText());

            if (exam < 0 || exam > 100 || code < 0 || code > 100 || interviewScore < 0 || interviewScore > 100) {
                JOptionPane.showMessageDialog(null, "Data harus berupa angka dan antara 0-100");
                return;
            }

            Processing process = new Processing(chosen, nim, exam, code, interviewScore);
            process.result();
        });

        goBack.addActionListener(e -> {
            new GUI(frame);
        });

        frame.revalidate();
        frame.repaint();
    }
}
