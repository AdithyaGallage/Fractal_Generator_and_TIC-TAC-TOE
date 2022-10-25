/*
* E/17/091 Gallage PGAP 
*/

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class View extends JFrame{
    
    JButton[][] button = new JButton[3][3]; // defining 9 buttons
    JTextArea txt = new JTextArea("Chance of Player 1"); // instantiate text area for print alerts, conditions and results

    View() {
        JFrame frame = new JFrame("Tic-Tac-Toe"); // instantiate frame
        JPanel panel1 = new JPanel();  // instantiate panel1
        JPanel panel2 = new JPanel();  // instantiate panel2
        panel1.setLayout(new GridLayout(3,3)); // panel1 set as a 3x3 grid
        panel1.setSize(300,300); // set panel1 length and width
        panel2.setSize(300,50);  // set panel2 length and width
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++){ 
                button[i][j] = new JButton(""); // Instantiate a button
                button[i][j].setPreferredSize(new Dimension(100, 100)); // set its dimension
                panel1.add(button[i][j]); // add it into panel1
            }
        txt.setPreferredSize(new Dimension(300,50)); // set text area dimension
        panel2.add(txt); // add text area into panel2
        // situate panel1 and panel2 in the frame
        frame.getContentPane().add(panel1, BorderLayout.PAGE_START);
        frame.getContentPane().add(panel2, BorderLayout.LINE_START);
        // pack both panel1 and panel2 in the frame
        frame.pack();
        frame.setSize(300,400); // set frame dimension
        frame.setVisible(true); // set frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default method to exit from the plane
    }

    // method to add action listener for the buttons
    void addButtonListener(ActionListener listener) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                button[i][j].addActionListener(listener);  
    }

    // Use to print the final result in a different window
    public void finalResults(String message){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message);
    }
    
    // method to clear the text in buttons and re start the game
    public void reStart(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                button[i][j].setText("");
        txt.setText("New Game\nChance of Player 1");
    }
}
