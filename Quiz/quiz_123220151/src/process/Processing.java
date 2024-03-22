package process;

import javax.swing.*;

public class Processing extends JFrame{
    double examScore, codingScore, interviewScore;
    final double ANDROID_EXAM_WEIGHT = 0.2, ANDROID_CODING_WEIGHT = 0.5, ANDROID_INTERVIEW_WEIGHT = 0.3;
    final double WEB_EXAM_WEIGHT = 0.4, WEB_CODING_WEIGHT = 0.35, WEB_INTERVIEW_WEIGHT = 0.25;

    String nim, chosen;

    public Processing (String chosen, String nim, double examScore, double codingScore, double interviewScore) {
        this.nim = nim;
        this.chosen = chosen;
        this.examScore = examScore;
        this.codingScore = codingScore;
        this.interviewScore = interviewScore;
    }

    public void result() {
        if (chosen.equals("ANDROID")) {
            examScore = examScore * ANDROID_EXAM_WEIGHT;
            codingScore = codingScore * ANDROID_CODING_WEIGHT;
            interviewScore = interviewScore * ANDROID_INTERVIEW_WEIGHT;
        } else if (chosen.equals("WEB")) {
            examScore = examScore * WEB_EXAM_WEIGHT;
            codingScore = codingScore * WEB_CODING_WEIGHT;
            interviewScore = interviewScore * WEB_INTERVIEW_WEIGHT;
        }

        double finalScore = examScore + codingScore + interviewScore;

        if (finalScore < 85) {
            JOptionPane.showMessageDialog(null, "Ditolak");
            return;
        } else if (finalScore > 85 && finalScore < 100) {
            JOptionPane.showMessageDialog(null, "Diterima");
        }
    }
}
