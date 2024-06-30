package org.example;
import javax.swing.*;
import java.util.ArrayList;

class minigame {
    private String ans;
    int limit;
    private int mov;
    int counter;

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    private ArrayList<Integer> askedQuestions = new ArrayList<>();

    public minigame() {
        initializeQuestionsAndAnswers();
    }

    private void initializeQuestionsAndAnswers() {
        // Existing questions and answers (30 in total)
        questions.add("What country has the highest life expectancy?");
        answers.add("Hong Kong");

        questions.add("What is the largest planet in our solar system?");
        answers.add("Jupiter");

        questions.add("What is the largest living species of lizard?");
        answers.add("Komodo dragon");

        questions.add("What is the world's largest waterfall, by volume of water?");
        answers.add("Inga Falls");

        questions.add("What is the highest mountain peak in the solar system?");
        answers.add("Olympus Mons");

        questions.add("Where would you be if you were standing on the Spanish Steps?");
        answers.add("Rome");

        questions.add("Which language has more native speakers: English or Spanish?");
        answers.add("Spanish");

        questions.add("What is the most common surname in the United States?");
        answers.add("Smith");

        questions.add("Which of the following planets in our solar system is known as the Red Planet?");
        answers.add("Mars");

        questions.add("Which of the following famous paintings by Leonardo da Vinci is also known as La Gioconda?");
        answers.add("Mona Lisa");

        questions.add("What is the capital of France?");
        answers.add("Paris");

        questions.add("Which of the following authors wrote the book 'To Kill a Mockingbird'?");
        answers.add("Harper Lee");

        questions.add("What is the chemical symbol for gold?");
        answers.add("Au");

        questions.add("Which of the following musicians is known as the 'King of Rock and Roll'?");
        answers.add("Elvis Presley");

        questions.add("What is the largest mammal on Earth?");
        answers.add("Blue whale");

        questions.add("Which of the following elements is the lightest in the periodic table?");
        answers.add("Hydrogen");

        questions.add("What is the smallest country in the world, both in terms of population and land area?");
        answers.add("Vatican City");

        questions.add("Which of the following ancient wonders is located in Egypt?");
        answers.add("The Great Pyramid of Giza");

        questions.add("What is the highest mountain peak in North America?");
        answers.add("Denali (formerly known as Mount McKinley)");

        questions.add("Which of the following planets in our solar system is no longer considered a planet?");
        answers.add("Pluto");

        questions.add("What is the largest city in the United States by population?");
        answers.add("New York City");

        questions.add("Which of the following authors wrote the book 'The Lord of the Rings'?");
        answers.add("J.R.R. Tolkien");

        questions.add("What is the chemical symbol for silver?");
        answers.add("Ag");

        questions.add("Which of the following musicians is known as the 'Queen of Pop'?");
        answers.add("Madonna");

        questions.add("What is the deepest ocean trench in the world?");
        answers.add("Challenger Deep");

        questions.add("Which of the following elements is the heaviest in the periodic table?");
        answers.add("Osmium");

        questions.add("What is the largest island in the Mediterranean Sea?");
        answers.add("Sicily");

        questions.add("Which of the following ancient civilizations built the city of Machu Picchu?");
        answers.add("Inca");

        questions.add("What is the highest mountain peak in South America?");
        answers.add("Aconcagua");

        questions.add("Which of the following planets in our solar system has the most moons?");
        answers.add("Jupiter");

        // Additional 10 questions and answers
        questions.add("Which mammal can fly without being a bird?");
        answers.add("Bat");

        questions.add("What is the largest desert in the world?");
        answers.add("Antarctica (Polar desert)");

        questions.add("Who wrote the novel '1984'?");
        answers.add("George Orwell");

        questions.add("What is the capital of Canada?");
        answers.add("Ottawa");

        questions.add("Which planet is known as the 'Morning Star' or 'Evening Star'?");
        answers.add("Venus");

        questions.add("What is the longest river in the world?");
        answers.add("Amazon River");

        questions.add("Who painted 'Starry Night'?");
        answers.add("Vincent van Gogh");

        questions.add("What is the smallest bone in the human body?");
        answers.add("Stapes (stirrup bone)");

        questions.add("What is the largest moon of Saturn?");
        answers.add("Titan");

        questions.add("Which famous physicist developed the theory of relativity?");
        answers.add("Albert Einstein");

        // Additional 10 questions and answers
        questions.add("Which ocean is the largest?");
        answers.add("Pacific Ocean");

        questions.add("Who was the first man to walk on the moon?");
        answers.add("Neil Armstrong");

        questions.add("What is the capital of Australia?");
        answers.add("Canberra");

        questions.add("Which animal is known as the 'King of the Jungle'?");
        answers.add("Lion");

        questions.add("Who painted the ceiling of the Sistine Chapel?");
        answers.add("Michelangelo");

        questions.add("What is the largest continent by land area?");
        answers.add("Asia");

        questions.add("Who invented the telephone?");
        answers.add("Alexander Graham Bell");

        questions.add("What is the chemical symbol for iron?");
        answers.add("Fe");

        questions.add("Which mammal has the longest gestation period?");
        answers.add("Elephant");

        questions.add("What is the largest moon of Jupiter?");
        answers.add("Ganymede");

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
        int option = JOptionPane.showConfirmDialog(null, "Do you want to return to Dashboard?", "Return to Dashboard", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Return to Dashboard
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new mainpage();
                }
            });
        } else {
            System.exit(0); // Exit the application if "No" is selected
        }
    }

    void question() {
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
                minigame QNA = new minigame();
                QNA.limit = 0;
                QNA.counter = 0;
                QNA.question();
            }
        });
    }
}
