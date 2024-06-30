package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class mainpage extends JFrame implements ActionListener {

    private JButton miniGameButton, toDoListButton, coursesButton, exitButton;

    public mainpage() {
        setTitle("Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        miniGameButton = createButton("Mini-Game", "/game.png", 90, 90);
        toDoListButton = createButton("To-Do List", "/task manager.png", 90, 90);
        coursesButton = createButton("Courses", "/courses.png", 90, 90);
        exitButton = createButton("Exit", null, 0, 0);

        panel.add(miniGameButton);
        panel.add(toDoListButton);
        panel.add(coursesButton);
        panel.add(exitButton);
        add(panel);

        setVisible(true);
    }

    private JButton createButton(String text, String iconPath, int iconWidth, int iconHeight) {
        JButton button;
        if (iconPath != null) {
            button = new JButton(text, createIcon(iconPath, iconWidth, iconHeight));
        } else {
            button = new JButton(text);
        }
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        button.setBackground(new Color(128, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(150, 0, 0));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(128, 0, 0));
            }
        });

        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miniGameButton) {
            startMiniGame();
        } else if (e.getSource() == toDoListButton) {
            openToDoList();
        } else if (e.getSource() == coursesButton) {
            viewCourses();
        } else if (e.getSource() == exitButton) {
            StudyBuddyApp LoginFrame = new StudyBuddyApp();
            LoginFrame.show();
            dispose();
        }
    }

    private void startMiniGame() {
        minigame QNA = new minigame();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();
    }

    private void openToDoList() {
       todolist t = new todolist();
       t.show();
       dispose();
    }

    private void viewCourses() {
       Courses c = new Courses();
       c.show();
       dispose();
    }

    private ImageIcon createIcon(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(mainpage::new);
    }
}







