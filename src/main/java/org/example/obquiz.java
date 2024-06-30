package org.example;


import java.util.*;
import javax.swing.*;





class obquiz {
    private String ans;
    public int limit;
    private int mov;
    public int counter;

    private java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
    private java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
    private java.util.ArrayList<Integer> askedQuestions = new java.util.ArrayList<Integer>();

    public obquiz() {
        initializeQuestionsAndAnswers();
    }

    private void initializeQuestionsAndAnswers() {
        questions.add("What is the study of human behavior in organizational settings?");
        answers.add("Organizational Behavior");

        questions.add("What is the process of influencing others to achieve group or organizational goals?");
        answers.add("Leadership");

        questions.add("What term describes the shared values, beliefs, and norms within an organization?");
        answers.add("Organizational Culture");

        questions.add("What is the practice of managing and improving employee performance?");
        answers.add("Performance Management");

        questions.add("What is a group of people working together to achieve a common goal called?");
        answers.add("Team");

        questions.add("What theory suggests that specific and challenging goals lead to higher performance?");
        answers.add("Goal-setting Theory");

        questions.add("What is the process of resolving a dispute or a conflict called?");
        answers.add("Conflict Resolution");

        questions.add("What is the method of motivating employees through recognition and rewards?");
        answers.add("Incentive Programs");

        questions.add("What term refers to a person's belief in their capability to execute tasks?");
        answers.add("Self-efficacy");

        questions.add("What is the study of how individuals make decisions within organizations?");
        answers.add("Decision Making Theory");
    }

    private void generateQuestion() {
        int index;
        do {
            index = (int)(Math.random() * questions.size());
        } while (askedQuestions.contains(index));
        askedQuestions.add(index);
        ans = answers.get(index);
        JOptionPane.showMessageDialog(null, questions.get(index));
    }

    private void correct() {
        counter++;
        JOptionPane.showMessageDialog(null, "Correct answer!");
        askToContinue();
    }

    private void wrong() {
        JOptionPane.showMessageDialog(null, "Wrong answer. The right answer is: " + ans);
        askToContinue();
    }

    private void askToContinue() {
        mov = JOptionPane.showConfirmDialog(null, "Click on yes to continue", "Continue", JOptionPane.YES_NO_OPTION);
        if (mov == JOptionPane.YES_OPTION) {
            question();
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        JOptionPane.showMessageDialog(null, "Game Ended\nYour score is: " + counter + "/" + 5 + "\nThank you for playing");

        // Directly return to courses
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Courses();
            }
        });
    }

    public void question() {
        if (limit < 5) {
            generateQuestion();
            String userAnswer = JOptionPane.showInputDialog("Your answer:");
            limit++;
            if (userAnswer != null && userAnswer.equalsIgnoreCase(ans)) {
                correct();
            } else {
                wrong();
            }
        } else {
            showFinalScore();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                obquiz QNA = new obquiz();
                QNA.limit = 0;
                QNA.counter = 0;
                QNA.question();
            }
        });
    }
}



