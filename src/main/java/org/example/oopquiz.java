package org.example;
import java.util.*;
import javax.swing.*;




class oopquiz {
        private String ans;
        public int limit;
        public int mov;
        public int counter;

        private java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
        private java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
        private java.util.ArrayList<Integer> askedQuestions = new java.util.ArrayList<Integer>();

        public oopquiz() {
            initializeQuestionsAndAnswers();
        }

     private void initializeQuestionsAndAnswers() {
            questions.add("What does OOP stand for?");
            answers.add("Object-Oriented Programming");

            questions.add("What is an object in OOP?");
            answers.add("An instance of a class");

            questions.add("What is a class in OOP?");
            answers.add("A blueprint for objects");

            questions.add("What is inheritance in OOP?");
            answers.add("A mechanism where one class acquires properties of another");

            questions.add("What is polymorphism in OOP?");
            answers.add("Ability of different classes to be treated as instances of the same class through a common interface");

            questions.add("What is encapsulation in OOP?");
            answers.add("Wrapping data and methods into a single unit, class");

            questions.add("What is abstraction in OOP?");
            answers.add("Hiding complex implementation details and showing only the necessary features");

            questions.add("What is a constructor in OOP?");
            answers.add("A special method used to initialize objects");

            questions.add("What is method overloading in OOP?");
            answers.add("Defining multiple methods with the same name but different parameters");

            questions.add("What is an interface in OOP?");
            answers.add("A reference type in Java that is similar to a class and is a collection of abstract methods");
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
                    oopquiz QNA = new oopquiz();
                    QNA.limit = 0;
                    QNA.counter = 0;
                    QNA.question();
                }
            });
        }
    }

