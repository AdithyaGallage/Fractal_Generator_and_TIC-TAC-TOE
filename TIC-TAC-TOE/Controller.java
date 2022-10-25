/*
* E/17/091 Gallage PGAP 
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Controller{

    Model model;
    View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.addButtonListener(new listener());
    }
    class listener implements ActionListener{
        public void actionPerformed(ActionEvent e) { 

            JButton clickedButton = (JButton)e.getSource(); // Identify the clicked button
           
            // If the button is alrady selected text area is updated from suitable message and let the player to choose, until he piks a free button
            if(model.isPlayed(clickedButton.getText())) {
                model.setOutputMessage1();
                view.txt.setText(model.getOutputMessage());
            }

            // If the picked button is not alrady selected,
            else{
                model.setButtonText(clickedButton); // Update the text inside the button from players name
                model.changePlayer(); // let the next player to play
                model.setOutputMessage2(); // outputMessage is updated
                model.setWinner(view.button); // if there is a winning instance winner is identyfied
                model.isGameOver(view.button); // Check for game is over or not
                view.txt.setText(model.getOutputMessage()); // text area is updated from the outputMessage

                // Chceck for the game is over or not
                //If game is over,
                if(model.getGameOver()){
                    // this if statement is used to idntify the game is drawn or not
                    if((model.getWinner()).equals("")){
                        // if game is deawn update the outputMessage and print it in the text area
                        model.setOutputMessage4();
                        view.txt.setText(model.getOutputMessage());
                        // final result is diplayed in a other window
                        view.finalResults(model.getOutputMessage());
                        // Intialize first player and other player
                        model.setCurrentPlayer("1");
                        model.setNextPlayer("2");
                        // Call for restart method
                        view.reStart();
                    }
                    else{
                        model.setOutputMessage3();
                        view.txt.setText(model.getOutputMessage());
                        view.finalResults(model.getOutputMessage());
                        model.setCurrentPlayer("1");
                        model.setNextPlayer("2");
                        view.reStart();
                    }
                }
            }
        }
    }   
}
