package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Main class for managing the courses
public class Courses extends JFrame {
    private Color DefaultColor, ClickedColor;
    private JDesktopPane jDesktopPane2;

    public Courses() {
        initComponents();
        DefaultColor = new Color(128, 0, 0);
        ClickedColor = Color.white;
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JPanel jPanel3 = new JPanel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JButton exitButton = new JButton("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Set a GridBagLayout for the main panel
        jPanel1.setLayout(new BorderLayout());

        // Header panel
        jPanel2.setBackground(Color.white);
        jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        jLabel3.setToolTipText("Click to go back");
        jLabel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", Font.BOLD, 24)); // Larger font size
        jLabel1.setForeground(Color.black);
        jLabel1.setText("COURSES");
        // Add exit button
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setBackground(new java.awt.Color(128, 0, 0));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));

        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(true);
        exitButton.setBounds(600, 10, 80, 30);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Redirect to mainpage class
                new mainpage().setVisible(true);
            }
        });
        jPanel1.add(exitButton);

        // Use GridBagLayout for header
        jPanel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel2.add(jLabel1, gbc);

        gbc.gridx = 1;
        jPanel2.add(jLabel3, gbc);

        jPanel1.add(jPanel2, BorderLayout.NORTH);

        // Course selection panel
        jPanel3.setBackground(new java.awt.Color(128, 0, 0));
        jPanel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel[] courseLabels = {jLabel2, jLabel4, jLabel5, jLabel6, jLabel7};
        String[] courseNames = {"OOP", "OB", "DLD", "Probability", "Presentation Skills"};

        JInternalFrame[] coursePages = {new OOPPage(), new OBPage(), new DLDPage(), new ProbabilityPage(), new PresentationSkillsPage()};

        for (int i = 0; i < courseLabels.length; i++) {
            courseLabels[i].setFont(new java.awt.Font("Bookman Old Style", Font.BOLD, 18));
            courseLabels[i].setForeground(new java.awt.Color(255, 255, 255));
            courseLabels[i].setText(courseNames[i]);
            courseLabels[i].setHorizontalTextPosition(SwingConstants.RIGHT);
            courseLabels[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            int finalI = i;
            courseLabels[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt) {
                    openCoursePage(coursePages[finalI]);
                }

                public void mouseEntered(MouseEvent evt) {
                    courseLabels[finalI].setCursor(new Cursor(Cursor.HAND_CURSOR));
                    courseLabels[finalI].setForeground(Color.white);
                }

                public void mouseExited(MouseEvent evt) {
                    courseLabels[finalI].setForeground(Color.WHITE);
                }
            });
            jPanel3.add(courseLabels[i]);
        }

        jPanel1.add(jPanel3, BorderLayout.WEST);

        // Desktop pane for displaying course details
        jDesktopPane2 = new JDesktopPane();
        jDesktopPane2.setBackground(Color.LIGHT_GRAY);
        jPanel1.add(jDesktopPane2, BorderLayout.CENTER);

        // Set the layout for the main JFrame
        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null); // Center the frame
        setSize(737, 505); // Set the default size
        setResizable(false); // Make the window non-resizable
    }

    // Method to load image icon


    // Event handler for clicking on jLabel3
    private void jLabel3MouseClicked(MouseEvent evt) {
        // Handle the click on the image if needed
    }

    // Method to open course page in internal frame
    private void openCoursePage(JInternalFrame coursePage) {
        // Remove any existing internal frames
        for (JInternalFrame frame : jDesktopPane2.getAllFrames()) {
            frame.dispose();
        }
        // Add and display the new internal frame
        jDesktopPane2.add(coursePage);
        coursePage.setVisible(true);
    }

    // Main method to start the application
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Courses().setVisible(true));
    }
}

// Internal Frame for OOP
class OOPPage extends JInternalFrame {
    public OOPPage() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        youtube = new javax.swing.JButton();
        google = new javax.swing.JButton();
        quiz = new javax.swing.JButton();
        headerpanel = new javax.swing.JPanel();
        subjectname = new java.awt.Label();
        subjectdescriptionpanel = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));

        setResizable(false);
        setSize(440, 350);

        youtube.setBackground(new java.awt.Color(128, 0, 0));
        youtube.setForeground(new java.awt.Color(255, 255, 255));
        youtube.setText("Youtube Lectures");
        youtube.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });

        google.setBackground(new java.awt.Color(128, 0, 0));
        google.setForeground(new java.awt.Color(255, 255, 255));
        google.setText("Study Material");
        google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleActionPerformed(evt);
            }
        });

        quiz.setBackground(new java.awt.Color(128, 0, 0));
        quiz.setForeground(new java.awt.Color(255, 255, 255));
        quiz.setText("Final Quiz");
        quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizActionPerformed(evt);
            }
        });

        headerpanel.setBackground(new java.awt.Color(128, 0, 0));

        subjectname.setAlignment(java.awt.Label.CENTER);
        subjectname.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        subjectname.setForeground(new java.awt.Color(255, 255, 255));
        subjectname.setText("Object Oriented Programming");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerpanelLayout.setVerticalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectdescriptionpanel.setBackground(new java.awt.Color(128, 0, 0));

        textArea1.setBackground(new java.awt.Color(128, 0, 0));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setText("Java, an acronym for \"Just Another Virtual \nAccelerator,\" is a widely-used object-oriented\n programming language (OOPL) that was first\n released by Sun Microsystems in 1995. Java's\n primary aim is to be a platform-independent\n language that can run on any device equipped\nwith the Java Virtual Machine (JVM), embodying\n the \"write once, run anywhere\" (WORA)\nphilosophy.\nAs an object-oriented programming language,\nJava emphasizes the use of objects and classes,\nenabling developers to create modular, reusable\ncode.");

        javax.swing.GroupLayout subjectdescriptionpanelLayout = new javax.swing.GroupLayout(subjectdescriptionpanel);
        subjectdescriptionpanel.setLayout(subjectdescriptionpanelLayout);
        subjectdescriptionpanelLayout.setHorizontalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subjectdescriptionpanelLayout.setVerticalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(google, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(youtube, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(quiz, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {google, quiz, youtube});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(youtube, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(google)
                                                .addGap(18, 18, 18)
                                                .addComponent(quiz))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {google, quiz, youtube});

        pack();
    }// </editor-fold>

    private void googleActionPerformed(java.awt.event.ActionEvent evt) {
        // Open w3schools Java tutorial in default browser
        openWebpage("https://www.w3schools.com/java/");
    }

    private void quizActionPerformed(java.awt.event.ActionEvent evt) {
        oopquiz QNA = new oopquiz();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();
    }

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {
        // Open YouTube link in default browser
        openWebpage("https://youtu.be/ntLJmHOJ0ME?si=SVD2FBTF91TYe_KM");
    }

    /**
     * Opens the specified URL in the default browser.
     *
     * @param url The URL to open
     */
    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param args the command line arguments
     */

    private javax.swing.JButton google;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton quiz;
    private javax.swing.JPanel subjectdescriptionpanel;
    private java.awt.Label subjectname;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton youtube;
    // End of variables declaration
}




// Internal Frame for OB
class OBPage extends JInternalFrame {
    public OBPage() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        youtube = new javax.swing.JButton();
        google = new javax.swing.JButton();
        quiz = new javax.swing.JButton();
        headerpanel = new javax.swing.JPanel();
        subjectname = new java.awt.Label();
        subjectdescriptionpanel = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));

        setResizable(false);
        setSize(440, 350);

        youtube.setBackground(new java.awt.Color(128, 0, 0));
        youtube.setForeground(new java.awt.Color(255, 255, 255));
        youtube.setText("Youtube Lectures");
        youtube.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });

        google.setBackground(new java.awt.Color(128, 0, 0));
        google.setForeground(new java.awt.Color(255, 255, 255));
        google.setText("Study Material");
        google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleActionPerformed(evt);
            }
        });

        quiz.setBackground(new java.awt.Color(128, 0, 0));
        quiz.setForeground(new java.awt.Color(255, 255, 255));
        quiz.setText("Final Quiz");
        quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizActionPerformed(evt);
            }
        });

        headerpanel.setBackground(new java.awt.Color(128, 0, 0));

        subjectname.setAlignment(java.awt.Label.CENTER);
        subjectname.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        subjectname.setForeground(new java.awt.Color(255, 255, 255));
        subjectname.setText("Organizational Behaviour");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerpanelLayout.setVerticalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectdescriptionpanel.setBackground(new java.awt.Color(128, 0, 0));

        textArea1.setBackground(new java.awt.Color(128, 0, 0));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setText("Organizational Behaviour (OB) is a \nmultidisciplinary field of study that explores\n the impact that individuals, groups, and \nstructures have on behavior within organizations.\n Its aim is to apply this knowledge toward improving an\n organization's effectiveness. The subject integrates insights \nfrom psychology, sociology, anthropology, and management \nto examine topics such as motivation, leadership, team \ndynamics, communication, and organizational culture.\n By understanding these elements, organizations\n can foster a productive and positive work environment, \nultimately leading to enhanced performance and \nemployee satisfaction.");

        javax.swing.GroupLayout subjectdescriptionpanelLayout = new javax.swing.GroupLayout(subjectdescriptionpanel);
        subjectdescriptionpanel.setLayout(subjectdescriptionpanelLayout);
        subjectdescriptionpanelLayout.setHorizontalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subjectdescriptionpanelLayout.setVerticalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(google, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(youtube, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(quiz, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {google, quiz, youtube});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(youtube, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(google)
                                                .addGap(18, 18, 18)
                                                .addComponent(quiz))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {google, quiz, youtube});

        pack();
    }// </editor-fold>

    private void googleActionPerformed(java.awt.event.ActionEvent evt) {
        // Open w3schools Java tutorial in default browser
        openWebpage("https://pressbooks.senecacollege.ca/organizationalbehaviour/chapter/chapter-1/");
    }

    private void quizActionPerformed(java.awt.event.ActionEvent evt) {
        obquiz QNA = new obquiz();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();
    }

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {
        // Open YouTube link in default browser
        openWebpage("https://youtu.be/Sg64udtQ300?si=Iny-RBuxF1z-Picu");
    }


    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }




    private javax.swing.JButton google;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton quiz;
    private javax.swing.JPanel subjectdescriptionpanel;
    private java.awt.Label subjectname;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton youtube;
// End of variables declaration
}





// Internal Frame for DLD
class DLDPage extends JInternalFrame {
    public DLDPage() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        youtube = new javax.swing.JButton();
        google = new javax.swing.JButton();
        quiz = new javax.swing.JButton();
        headerpanel = new javax.swing.JPanel();
        subjectname = new java.awt.Label();
        subjectdescriptionpanel = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));

        setResizable(false);
        setSize(440, 350);

        youtube.setBackground(new java.awt.Color(128, 0, 0));
        youtube.setForeground(new java.awt.Color(255, 255, 255));
        youtube.setText("Youtube Lectures");
        youtube.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });

        google.setBackground(new java.awt.Color(128, 0, 0));
        google.setForeground(new java.awt.Color(255, 255, 255));
        google.setText("Study Material");
        google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleActionPerformed(evt);
            }
        });

        quiz.setBackground(new java.awt.Color(128, 0, 0));
        quiz.setForeground(new java.awt.Color(255, 255, 255));
        quiz.setText("Final Quiz");
        quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizActionPerformed(evt);
            }
        });

        headerpanel.setBackground(new java.awt.Color(128, 0, 0));

        subjectname.setAlignment(java.awt.Label.CENTER);
        subjectname.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        subjectname.setForeground(new java.awt.Color(255, 255, 255));
        subjectname.setText("Organizational Behaviour");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerpanelLayout.setVerticalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectdescriptionpanel.setBackground(new java.awt.Color(128, 0, 0));

        textArea1.setBackground(new java.awt.Color(128, 0, 0));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setText("Digital logic design is a key subject\n in computer science and electrical \nengineering that focuses on the principles \nof designing and analyzing digital circuits. \nIt covers Boolean algebra, logic gates,\n and the creation of combinational and \nsequential circuits. This subject is\n essential for understanding the hardware \ncomponents of computers and other digital devices,\n enabling the development of efficient \nand reliable electronic systems.");

        javax.swing.GroupLayout subjectdescriptionpanelLayout = new javax.swing.GroupLayout(subjectdescriptionpanel);
        subjectdescriptionpanel.setLayout(subjectdescriptionpanelLayout);
        subjectdescriptionpanelLayout.setHorizontalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subjectdescriptionpanelLayout.setVerticalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(google, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(youtube, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(quiz, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {google, quiz, youtube});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(youtube, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(google)
                                                .addGap(18, 18, 18)
                                                .addComponent(quiz))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {google, quiz, youtube});

        pack();
    }// </editor-fold>

    private void googleActionPerformed(java.awt.event.ActionEvent evt) {
        // Open w3schools Java tutorial in default browser
        openWebpage("https://www.engrcs.com/courses/engr250/engr250lecture.pdf");
    }

    private void quizActionPerformed(java.awt.event.ActionEvent evt) {
        dldquiz QNA = new dldquiz();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();
    }

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {
        // Open YouTube link in default browser
        openWebpage("https://youtu.be/O0gtKDu_cJc?si=1teHTC_4qi1ZeVY2");
    }


    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }




    private javax.swing.JButton google;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton quiz;
    private javax.swing.JPanel subjectdescriptionpanel;
    private java.awt.Label subjectname;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton youtube;
// End of variables declaration
}



// Internal Frame for Probability
class ProbabilityPage extends JInternalFrame {
    public ProbabilityPage() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        youtube = new javax.swing.JButton();
        google = new javax.swing.JButton();
        quiz= new javax.swing.JButton();
        headerpanel = new javax.swing.JPanel();
        subjectname = new java.awt.Label();
        subjectdescriptionpanel = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));

        setResizable(false);
        setSize(440, 350);

        youtube.setBackground(new java.awt.Color(128, 0, 0));
        youtube.setForeground(new java.awt.Color(255, 255, 255));
        youtube.setText("Youtube Lectures");
        youtube.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });

        google.setBackground(new java.awt.Color(128, 0, 0));
        google.setForeground(new java.awt.Color(255, 255, 255));
        google.setText("Study Material");
        google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleActionPerformed(evt);
            }
        });

        quiz.setBackground(new java.awt.Color(128, 0, 0));
        quiz.setForeground(new java.awt.Color(255, 255, 255));
        quiz.setText("Final Quiz");
        quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizActionPerformed(evt);
            }
        });

        headerpanel.setBackground(new java.awt.Color(128, 0, 0));

        subjectname.setAlignment(java.awt.Label.CENTER);
        subjectname.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        subjectname.setForeground(new java.awt.Color(255, 255, 255));
        subjectname.setText("Organizational Behaviour");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerpanelLayout.setVerticalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectdescriptionpanel.setBackground(new java.awt.Color(128, 0, 0));

        textArea1.setBackground(new java.awt.Color(128, 0, 0));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setText("Probability and statistics are branches \n of mathematics focused on understanding uncertainty \n and data. Probability quantifies the likelihood \n of events occurring, essential for predicting \n outcomes in uncertain situations. Statistics involves \n collecting, analyzing, and interpreting data to \n make informed decisions and draw conclusions \n about larger populations. Together, they form \n the foundation of data science, crucial \n for applications across various fields.");

        javax.swing.GroupLayout subjectdescriptionpanelLayout = new javax.swing.GroupLayout(subjectdescriptionpanel);
        subjectdescriptionpanel.setLayout(subjectdescriptionpanelLayout);
        subjectdescriptionpanelLayout.setHorizontalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subjectdescriptionpanelLayout.setVerticalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(google, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(youtube, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(quiz, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {google, quiz, youtube});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(youtube, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(google)
                                                .addGap(18, 18, 18)
                                                .addComponent(quiz))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {google, quiz, youtube});

        pack();
    }// </editor-fold>

    private void googleActionPerformed(java.awt.event.ActionEvent evt) {
        // Open w3schools Java tutorial in default browser
        openWebpage("https://ocw.mit.edu/courses/1-151-probability-and-statistics-in-engineering-spring-2005/pages/lecture-notes/");
    }

    private void quizActionPerformed(java.awt.event.ActionEvent evt) {
        probquiz QNA = new probquiz();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();
    }

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {
        // Open YouTube link in default browser
        openWebpage("https://youtu.be/Q_u3Lt5AV3c?si=PqFGSdRzqED0Y3Aa");
    }


    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }




    private javax.swing.JButton google;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton quiz;
    private javax.swing.JPanel subjectdescriptionpanel;
    private java.awt.Label subjectname;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton youtube;
// End of variables declaration
}


// Internal Frame for Presentation Skills
class PresentationSkillsPage extends JInternalFrame {
    public PresentationSkillsPage() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        youtube = new javax.swing.JButton();
        google = new javax.swing.JButton();
        quiz = new javax.swing.JButton();
        headerpanel = new javax.swing.JPanel();
        subjectname = new java.awt.Label();
        subjectdescriptionpanel = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));

        setResizable(false);
        setSize(440, 350);

        youtube.setBackground(new java.awt.Color(128, 0, 0));
        youtube.setForeground(new java.awt.Color(255, 255, 255));
        youtube.setText("Youtube Lectures");
        youtube.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });

        google.setBackground(new java.awt.Color(128, 0, 0));
        google.setForeground(new java.awt.Color(255, 255, 255));
        google.setText("Study Material");
        google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleActionPerformed(evt);
            }
        });

        quiz.setBackground(new java.awt.Color(128, 0, 0));
        quiz.setForeground(new java.awt.Color(255, 255, 255));
        quiz.setText("Final Quiz");
        quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizActionPerformed(evt);
            }
        });

        headerpanel.setBackground(new java.awt.Color(128, 0, 0));

        subjectname.setAlignment(java.awt.Label.CENTER);
        subjectname.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        subjectname.setForeground(new java.awt.Color(255, 255, 255));
        subjectname.setText("Organizational Behaviour");

        javax.swing.GroupLayout headerpanelLayout = new javax.swing.GroupLayout(headerpanel);
        headerpanel.setLayout(headerpanelLayout);
        headerpanelLayout.setHorizontalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerpanelLayout.setVerticalGroup(
                headerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectdescriptionpanel.setBackground(new java.awt.Color(128, 0, 0));

        textArea1.setBackground(new java.awt.Color(128, 0, 0));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setText("Communication and presentation skills are crucial competencies\n that empower individuals to effectively convey ideas, information, \nand emotions in various settings. These skills encompass the \nability to articulate thoughts clearly, listen actively, and adapt \ncommunication styles to different audiences. Additionally, effective presentation skills \ninvolve structuring content logically, using visual aids effectively, \nand engaging an audience through confident delivery. Mastering these \nskills not only enhances professional success but also fosters better \ninterpersonal relationships and collaboration");

        javax.swing.GroupLayout subjectdescriptionpanelLayout = new javax.swing.GroupLayout(subjectdescriptionpanel);
        subjectdescriptionpanel.setLayout(subjectdescriptionpanelLayout);
        subjectdescriptionpanelLayout.setHorizontalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        subjectdescriptionpanelLayout.setVerticalGroup(
                subjectdescriptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectdescriptionpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(google, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(youtube, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(quiz, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {google, quiz, youtube});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(youtube, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(google)
                                                .addGap(18, 18, 18)
                                                .addComponent(quiz))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectdescriptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {google, quiz, youtube});

        pack();
    }// </editor-fold>

    private void googleActionPerformed(java.awt.event.ActionEvent evt) {
        // Open w3schools Java tutorial in default browser
        openWebpage("https://www.ddegjust.ac.in/studymaterial/mca-5/mca-106.pdf");
    }

    private void quizActionPerformed(java.awt.event.ActionEvent evt) {

        presentquiz QNA = new presentquiz();
        QNA.limit = 0;
        QNA.counter = 0;
        QNA.question();


    }


    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {
        // Open YouTube link in default browser
        openWebpage("https://youtu.be/D4kBDeZiHyw?si=DD-NTJ4kLvNINuEh");
    }


    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }




    private javax.swing.JButton google;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton quiz;
    private javax.swing.JPanel subjectdescriptionpanel;
    private java.awt.Label subjectname;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton youtube;
// End of variables declaration
}

