package org.example;
import javax.swing.*;





class dldquiz {
    private String ans;
   public int limit;
    private int mov;
    public int counter;

    private java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
    private java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
    private java.util.ArrayList<Integer> askedQuestions = new java.util.ArrayList<Integer>();

    public dldquiz() {
        initializeQuestionsAndAnswers();
    }

    private void initializeQuestionsAndAnswers() {
        questions.add("What is the basic building block of digital circuits?");
        answers.add("Logic gate");

        questions.add("Which logic gate outputs true only when all inputs are true?");
        answers.add("AND gate");

        questions.add("What is the output of an OR gate when at least one input is true?");
        answers.add("True");

        questions.add("Which gate inverts the input signal?");
        answers.add("NOT gate");

        questions.add("What is the binary representation of the decimal number 5?");
        answers.add("101");

        questions.add("Which number system uses only the digits 0 and 1?");
        answers.add("Binary");

        questions.add("What is a group of 8 bits called?");
        answers.add("Byte");

        questions.add("What does the acronym 'DLD' stand for?");
        answers.add("Digital Logic Design");

        questions.add("What is the function of a flip-flop in digital circuits?");
        answers.add("To store a single bit of data");

        questions.add("Which type of flip-flop is triggered by a change in input rather than a clock signal?");
        answers.add("Asynchronous flip-flop");
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
        int option = JOptionPane.showConfirmDialog(null, "Do you want to return to courses?", "Return to Dashboard", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Return to Dashboard
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Courses();
                }
            });
        } else {
            mainpage m =new mainpage();
            m.show();
        }
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
                dldquiz QNA = new dldquiz();
                QNA.limit = 0;
                QNA.counter = 0;
                QNA.question();
            }
        });
    }
}


