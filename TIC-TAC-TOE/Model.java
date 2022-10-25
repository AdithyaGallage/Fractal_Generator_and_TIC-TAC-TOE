/*
* E/17/091 Gallage PGAP 
*/

import javax.swing.JButton;

class Model{
    
    private boolean gameOver; // variable for identify the game is over or not
    private String winner; // variable for store the name of the winner
    private String currentPlayer = "1"; // name of the currently playing player 
    private String nextPlayer = "2";    // name of the next player
    private String outputMessage; // variable for store instructions and alerts

    // setters for private variables
    public void setGeameOver(boolean gameOver){ this.gameOver = gameOver; }
    public void setWinner(String winner){ this.winner = winner; }
    public void setCurrentPlayer(String currentPlayer){ this.currentPlayer = currentPlayer; }
    public void setNextPlayer(String nextPlayer){ this.nextPlayer = nextPlayer; }
    public void setOutputMessage(String outputMessage){ this.outputMessage = outputMessage; }

    // getters for private variables
    public boolean getGameOver(){ return this.gameOver; }
    public String getWinner(){ return this.winner; }
    public String getCurrentPlayer(){ return this.currentPlayer; }
    public String getNextPlayer(){ return this.nextPlayer; }
    public String getOutputMessage(){ return this.outputMessage; }

    /*
     * method to identify  the winner
     * if there is a game winning instance set the winner's name.And then game status set as gameOver.
     * Otherwise game winner's name is set as "" and game status set as !gameOver
     */
    public void setWinner(JButton[][] button){
        if((button[0][0].getText()).equals(button[0][1].getText()) && (button[0][1].getText()).equals(button[0][2].getText()) && !(button[0][0].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][0].getText();
        } 
        else if((button[0][0].getText()).equals(button[1][0].getText()) && (button[1][0].getText()).equals(button[2][0].getText()) && !(button[0][0].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][0].getText();
        }
        else if((button[2][0].getText()).equals(button[2][1].getText()) && (button[2][1].getText()).equals(button[2][2].getText()) && !(button[2][0].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[2][0].getText();
        }
        else if((button[0][2].getText()).equals(button[1][2].getText()) && (button[1][2].getText()).equals(button[2][2].getText()) && !(button[0][2].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][2].getText();
        }
        else if((button[0][0].getText()).equals(button[1][1].getText()) && (button[1][1].getText()).equals(button[2][2].getText()) && !(button[0][0].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][0].getText();
        }
        else if((button[0][2].getText()).equals(button[1][1].getText()) && (button[1][1].getText()).equals(button[2][0].getText()) && !(button[0][2].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][2].getText();
        }
        else if ((button[0][1].getText()).equals(button[1][1].getText()) && (button[1][1].getText()).equals(button[2][1].getText()) && !(button[0][1].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[0][1].getText();
        }
        else if((button[1][0].getText()).equals(button[1][1].getText()) && (button[1][1].getText()).equals(button[1][2].getText()) && !(button[1][0].getText()).equals("")){
            this.gameOver = true;
            this.winner = button[1][0].getText();
        }
        else{
            this.gameOver = false;
            this.winner = "";
        }
    }

    // method to set the player name, inside the button
    public void setButtonText(JButton button){
        button.setText(this.currentPlayer);
    }

    // method to idetyfy a certain button is played or not
    public boolean isPlayed(String player) {
        //if text inside the button is equals to "", return false
        if(player.equals("")) return false;
        //Otherwise return false
        else return true;
    }

    // method to idetyfy game is over or not
    public void isGameOver(JButton[][] button){
        // if gameOver is false, text inside the buttons are checked.If at lest one is equal to "", game status set as gameOver. Otherwise not
        if(!this.gameOver){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if((button[i][j].getText()).equals("")){
                        this.gameOver = false;
                        return;
                    }
                }
            }
            this.gameOver = true; 
        }
    }

    // method to switch the players(change the chance for current player to next player)
    public void changePlayer(){
        String temp = this.currentPlayer;
        this.currentPlayer = this.nextPlayer;
        this.nextPlayer = temp;
    }

    // methods to set the value of ouputMessage variable
    public void setOutputMessage1(){
        this.outputMessage = "Retry Player "+ this.currentPlayer+"\nPleace select a button which is not alrady picked";
    }
    public void setOutputMessage2(){
        this.outputMessage = "Chance of Player " + this.currentPlayer;
    }
    public void setOutputMessage3(){
        this.outputMessage = "Game Over!! Match is WON by Player "+ this.winner;
    }
    public void setOutputMessage4(){
        this.outputMessage = "Game Over!! Match is DRAWN";
    }

}