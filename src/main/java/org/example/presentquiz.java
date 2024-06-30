package org.example;
import javax.swing.*;





public class presentquiz {
    private String ans;
    public int limit;
    private int mov;
    public int counter;

    private java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
    private java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
    private java.util.ArrayList<Integer> askedQuestions = new java.util.ArrayList<Integer>();

    public presentquiz() {
        initializeQuestionsAndAnswers();
    }

    private void initializeQuestionsAndAnswers() {
        questions.add("What is eye contact important for during a presentation?");
        answers.add("Engaging the audience");

        questions.add("What is a key benefit of practicing your presentation?");
        answers.add("Improving confidence");

        questions.add("What should you avoid using too much in your slides?");
        answers.add("Text");

        questions.add("What is the importance of using a clear and loud voice?");
        answers.add("Ensuring everyone can hear");

        questions.add("What is the main purpose of a presentation's opening?");
        answers.add("Capturing attention");

        questions.add("What can help in reducing nervousness before a speech?");
        answers.add("Deep breathing");

        questions.add("What is an effective way to end a presentation?");
        answers.add("A strong closing statement");

        questions.add("What tool can help make a presentation more engaging?");
        answers.add("Visual aids");

        questions.add("What should you do if you forget a point during your speech?");
        answers.add("Stay calm and move on");

        questions.add("What is the benefit of using stories in presentations?");
        answers.add("Making the message memorable");
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
                presentquiz QNA = new presentquiz();
                QNA.limit = 0;
                QNA.counter = 0;
                QNA.question();
            }
        });
    }
}




