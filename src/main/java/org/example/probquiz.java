package org.example;

import javax.swing.*;

public class probquiz {

        private String ans;
        public int limit;
        private int mov;
        public int counter;

        private java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
        private java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
        private java.util.ArrayList<Integer> askedQuestions = new java.util.ArrayList<Integer>();

    public probquiz() {
        initializeQuestionsAndAnswers();
    }

    private void initializeQuestionsAndAnswers() {
        questions.add("What is the probability of flipping a coin and it landing on heads?");
        answers.add("50%");

        questions.add("What is the mean of the numbers 1, 2, 3, 4, and 5?");
        answers.add("3");

        questions.add("What is the median of the numbers 3, 5, 1, 4, and 2?");
        answers.add("3");

        questions.add("What is the mode of the numbers 1, 2, 2, 3, and 4?");
        answers.add("2");

        questions.add("What is the range of the numbers 7, 2, 10, 3, and 5?");
        answers.add("8");

        questions.add("What is the probability of rolling a 3 on a standard 6-sided die?");
        answers.add("1/6");

        questions.add("In a normal distribution, what percentage of data falls within one standard deviation of the mean?");
        answers.add("68%");

        questions.add("What is the probability of drawing an Ace from a standard deck of 52 playing cards?");
        answers.add("1/13");

        questions.add("What is the expected value of a fair 6-sided die roll?");
        answers.add("3.5");

        questions.add("What is the standard deviation a measure of?");
        answers.add("Spread or dispersion of a set of values");
    }

        private void generateQuestion () {
        int index;
        do {
            index = (int) (Math.random() * questions.size());
        } while (askedQuestions.contains(index));
        askedQuestions.add(index);
        ans = answers.get(index);
        JOptionPane.showMessageDialog(null, questions.get(index));
    }

        private void correct () {
        counter++;
        JOptionPane.showMessageDialog(null, "Correct answer!");
        askToContinue();
    }

        private void wrong () {
        JOptionPane.showMessageDialog(null, "Wrong answer. The right answer is: " + ans);
        askToContinue();
    }

        private void askToContinue () {
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

        public void question () {
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

        public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                probquiz QNA = new probquiz();
                QNA.limit = 0;
                QNA.counter = 0;
                QNA.question();
            }
        });
    }
    }

