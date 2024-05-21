package TicTacToe;

import java.io.File;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//this is the GUI of the game board
//it had to be an abstracted class to inherit from it three different classes
//one for each game level (easy, medium and hard), with the same GUI properties
//but with a different handle method in each class for the array of buttons
//so in order to make an abstracted method
//which will contain the programming for each level in the abstracted handle method in the inherited classes
//this general class had to be abstracted too
public abstract class GeneralBoard extends StackPane {

    ///////attributes for only hard level///////
    ////////////////////////
    //this variable is so important to let the computer choose only one probability
    //from the winning probabilities and the drawing ones too
    //if there was multiple ones available at the same move, so it will just choose a random one (from the winnig probabilities)
    //then changing its value to be true
    //so no other probability regardless of its type would be chosen, and the game will be just ended at this move
    //its value changes when making a new game to be false
    boolean end;

    //this variable only changes to be true if a winning probability for the computer had been achieved
    //it let the computer knows that the game must be ended (in the handle method) after invoking the CheckIfCanWin() method
    boolean doesWin;

    //this variable is so important to let the computer knows
    //if the CheckIfCanWin() method was invoked and if the game still goinng on, so it will prevent double move from
    //the invoked method and the regular programmed move in the handle method
    //its value renewed each time it's computer turn
    boolean checkWin;

    //it has the same explanation for "end" variable but it's only diffrent in
    //preventing double move if there was more than one draw probability available
    //so it forces the computer to choose only one probability at a time and unlike the "end" variable
    //its value renewed each time it's computer turn
    boolean preventDoubleMove;
    ////////////////////////
    ///////attributes for only hard level///////

    //setting up the background of the game board StackPane
    final ImageView background = new ImageView(new Image("greenBackground.jpg"));

    //setting up the array of the buttons for the tic tac toe game
    final Buttons[] button = new Buttons[9];

    //setting up the grid which will contain the buttons array
    final GridPane gridBtns = new GridPane();

    //setting up the grid which will contain the "back" and "new game" buttons
    final GridPane Btns = new GridPane();

    final Buttons back = new Buttons("Back"); //to go back to the first StackPane
    final Buttons newGame = new Buttons("New Game"); //to renew the game

    //letting the user knows whose turn it is
    final Label playerturn = new Label("");

    //for FirstTurnComp()
    Random random = new Random();

    //for actionPerformed(ActionEvent e)
    Random random2 = new Random();

    //whose turn it is (computer or user)
    boolean userTurn;

    //what is the current symbol the user playing with
    String symbol;

    //letting the computer knows if the game has been ended or not
    boolean ifGameEnds = false;

    //it's important to know which symbol has won to determine who won the game, the computer or the user
    //if x won, its value would be set to 1 in xWins() method, if it's o, then its value would be set to 2 in oWins() method
    //so if the user was playing using X, in their turn each time after making the move and the CheckWinner() method is invoked
    //there would be a check for the symbolWon value
    //if its is equal to 1, then the user won, and the text in the label would be changed to display a winning message to the user
    //if it's the computer turn, the same process will be done but the symbolWon will be checked if its value is equal to 2
    //if so, then the user loses, and the text in the label will be changed to display a losing message to the user
    //if the user was playing using O, then it will be the opposite of the same process
    int symbolWon;

    //displaying what is the current symbol the user is playing with
    Button symbolBtn = new Button();

    //setting up a winning sound
    Media WinningSound = new Media(new File("SoundsFiles/Winning Sound.mp3").toURI().toString());
    MediaPlayer mediaPlayerWins = new MediaPlayer(WinningSound);

    //setting up a losing sound
    Media LosingSound = new Media(new File("SoundsFiles/Game Over.mp3").toURI().toString());
    MediaPlayer mediaPlayerLoses = new MediaPlayer(LosingSound);

    Buttons scoreButtons = new Buttons("0");
    Label score = new Label("Score: ");
    int scorevalue = 0;

    GeneralBoard() {

        //setting up the properties of the nodes
        back.setPrefSize(200, 30);
        newGame.setPrefSize(200, 30);
        setStyle("-fx-border-color:#BF5723;-fx-border-width:5px;-fx-border-radius:1px;");
        playerturn.setFont(Font.font("Garamond", FontWeight.BOLD, 50));
        Btns.setHgap(5);
        Btns.setPadding(new Insets(10));
        GridPane.setMargin(back, new Insets(5));
        GridPane.setMargin(newGame, new Insets(5));
        Btns.add(newGame, 0, 0);
        Btns.add(back, 1, 0);
        symbolBtn.setPrefSize(30, 30);
        symbolBtn.setFocusTraversable(false);
        symbolBtn.setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:5;-fx-border-color:#5D9036 ;-fx-border-width:2px;-fx-border-radius: 5;");
        symbolBtn.setFont(Font.font("Monaco", FontWeight.BOLD, 20));

        scoreButtons.setPrefSize(30, 30);
        scoreButtons.setFocusTraversable(false);
        scoreButtons.setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:5;-fx-border-color:#5D9036 ;-fx-border-width:2px;-fx-border-radius: 5;");
        scoreButtons.setFont(Font.font("Monaco", FontWeight.BOLD, 20));

        //to set each button position of the array in the grid
        int column = 0;
        int row = 0;

        //creating the array of buttons for the game board
        for (int i = 0; i < 9; i++) {

            button[i] = new Buttons();
            button[i].setPrefSize(115, 115);
            GridPane.setMargin(button[i], new Insets(5));
            button[i].setFocusTraversable(false);
            gridBtns.add(button[i], column, row);
            button[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
            column++;
            if (column == 3) {
                row++;
                column = 0;
            }

        }

        //adding all the nodes to this StackPane class & setting the position for each node in it
        getChildren().addAll(background, playerturn, Btns, gridBtns, symbolBtn, score, scoreButtons);
        scoreButtons.setAlignment(Pos.TOP_LEFT);
        scoreButtons.setTranslateX(-220);
        scoreButtons.setTranslateY(-240);

        score.setAlignment(Pos.TOP_LEFT);
        score.setTranslateX(-220);
        score.setTranslateY(-280);

        symbolBtn.setAlignment(Pos.TOP_RIGHT);
        symbolBtn.setTranslateX(220);
        symbolBtn.setTranslateY(-265);
        playerturn.setAlignment(Pos.TOP_CENTER);
        playerturn.setTranslateY(-250);
        gridBtns.setAlignment(Pos.BOTTOM_CENTER);
        gridBtns.setTranslateY(-120);
        Btns.setAlignment(Pos.BOTTOM_CENTER);
        Btns.setTranslateY(-10);

    }

    //checking if there is a winning state
    public void CheckWinner() {
        if (button[0].getText() == "X"
                && button[1].getText() == "X"
                && button[2].getText() == "X") {
            symbolWon = 1;
            Xwins(0, 1, 2);
        } else if (button[3].getText() == "X"
                && button[4].getText() == "X"
                && button[5].getText() == "X") {
            symbolWon = 1;
            Xwins(3, 4, 5);
        } else if (button[6].getText() == "X"
                && button[7].getText() == "X"
                && button[8].getText() == "X") {
            symbolWon = 1;
            Xwins(6, 7, 8);
        } else if (button[0].getText() == "X"
                && button[4].getText() == "X"
                && button[8].getText() == "X") {
            symbolWon = 1;
            Xwins(0, 4, 8);
        } else if (button[0].getText() == "X"
                && button[3].getText() == "X"
                && button[6].getText() == "X") {
            symbolWon = 1;
            Xwins(0, 3, 6);
        } else if (button[1].getText() == "X"
                && button[4].getText() == "X"
                && button[7].getText() == "X") {
            symbolWon = 1;
            Xwins(1, 4, 7);
        } else if (button[2].getText() == "X"
                && button[5].getText() == "X"
                && button[8].getText() == "X") {
            symbolWon = 1;
            Xwins(2, 5, 8);
        } else if (button[2].getText() == "X"
                && button[4].getText() == "X"
                && button[6].getText() == "X") {
            symbolWon = 1;
            Xwins(2, 4, 6);
        } else if (button[0].getText() == "O"
                && button[1].getText() == "O"
                && button[2].getText() == "O") {
            symbolWon = 2;
            Owins(0, 1, 2);

        } else if (button[3].getText() == "O"
                && button[4].getText() == "O"
                && button[5].getText() == "O") {
            symbolWon = 2;
            Owins(3, 4, 5);

        } else if (button[6].getText() == "O"
                && button[7].getText() == "O"
                && button[8].getText() == "O") {
            symbolWon = 2;
            Owins(6, 7, 8);

        } else if (button[0].getText() == "O"
                && button[4].getText() == "O"
                && button[8].getText() == "O") {
            symbolWon = 2;
            Owins(0, 4, 8);
        } else if (button[0].getText() == "O"
                && button[3].getText() == "O"
                && button[6].getText() == "O") {
            symbolWon = 2;
            Owins(0, 3, 6);
        } else if (button[1].getText() == "O"
                && button[4].getText() == "O"
                && button[7].getText() == "O") {
            symbolWon = 2;
            Owins(1, 4, 7);
        } else if (button[2].getText() == "O"
                && button[5].getText() == "O"
                && button[8].getText() == "O") {
            symbolWon = 2;
            Owins(2, 5, 8);
        } else if (button[2].getText() == "O"
                && button[4].getText() == "O"
                && button[6].getText() == "O") {
            symbolWon = 2;
            Owins(2, 4, 6);
        } else {
            int checkTie = 0;
            for (int i = 0; i < 9; i++) {
                if (button[i].getText() == "O" || button[i].getText() == "X") {
                    checkTie++;
                    if (checkTie == 9) {
                        Tie();
                        ifGameEnds = true;
                    }
                }
            }
        }

    }

    //they are invoked if there  is a winning state in CheckWinner() method to set the winning buttons a specific color 
    //based on who wins it will be a specific color
    //and a winning/losing sound
    public void Xwins(int a, int b, int c) {
        if (symbol == "X") {
            if (symbolWon == 1) {
                button[a].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerWins.play();
                scorevalue++;
                scoreButtons.setText(String.valueOf(scorevalue));
            } else if (symbolWon == 2) {
                button[a].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerLoses.play();
            }
        }

        if (symbol == "O") {
            if (symbolWon == 2) {
                button[a].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerWins.play();
                scorevalue++;

                scoreButtons.setText(String.valueOf(scorevalue));
            } else if (symbolWon == 1) {
                button[a].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerLoses.play();
            }
        }

        disableBtn();
        ifGameEnds = true;
    }

    public void Owins(int a, int b, int c) {
        if (symbol == "X") {
            if (symbolWon == 1) {
                button[a].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerWins.play();
                scorevalue++;
                scoreButtons.setText(String.valueOf(scorevalue));

            } else if (symbolWon == 2) {
                button[a].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerLoses.play();

            }
        }

        if (symbol == "O") {
            if (symbolWon == 2) {
                button[a].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #3ABC27 100%),radial-gradient(center 50% -40%, radius 200%, #3ABC27 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerWins.play();

                scorevalue++;
                scoreButtons.setText(String.valueOf(scorevalue));
            } else if (symbolWon == 1) {
                button[a].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[b].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                button[c].setStyle("-fx-background-color: #FF4242,linear-gradient(#FF4242 50%, #FD5E5E 100%),radial-gradient(center 50% -40%, radius 200%, #FD5E5E 45%, #FF4242 50%) ;-fx-background-radius:10;-fx-border-color: #D42626;-fx-border-width:3px;-fx-border-radius: 10;");
                mediaPlayerLoses.play();
            }
        }

        disableBtn();
        ifGameEnds = true;
    }

    //if no one wins
    public void Tie() {
        playerturn.setText("It's a Tie");
    }

    //disabling the buttons if the game ends
    public void disableBtn() {
        for (int i = 0; i < 9; i++) {
            button[i].setDisable(true);
            button[i].setOpacity(1);
        }
    }

    //settting up the job of the "back" button
    //to clean the board from whatever happened to it
    public void backBtn() {
        for (int i = 0; i < 9; i++) {
            mediaPlayerWins.stop();
            mediaPlayerLoses.stop();
            button[i].setDisable(false);
            button[i].setText("");
            button[i].setStyle("-fx-text-fill:#473C33;-fx-background-color: #F3CA82,linear-gradient(#F3CA82 50%, #F6BC59 100%),radial-gradient(center 50% -40%, radius 200%, #F3CA82 45%, #F6BC59 50%) ;-fx-background-radius:10;-fx-border-color: #BD8421;-fx-border-width:3px;-fx-border-radius: 10;");

        }
        scorevalue = 0;
        scoreButtons.setText("0");

    }

    //to save the user symbol choice 
    public void X() {
        symbol = "X";
    }

    public void O() {
        symbol = "O";
    }

    public void randomly() {
        if (random.nextInt(2) == 0) {
            symbol = "X";
        } else {
            symbol = "O";
        }
    }

    public void FirstTurnComp() {
        if (random.nextInt(2) == 0) {
            userTurn = true;
            playerturn.setText("Your Turn!");
        } else {
            userTurn = false;
            playerturn.setText("Computer Turn");
        }
    }

    //to use it in different classes with a different jobs
    public abstract void actionPerformed(ActionEvent e);

    public void newGame() {

        symbolBtn.setText(symbol);

        ///////initializing all the used variables///////
        preventDoubleMove = false;
        end = false;
        checkWin = false;
        doesWin = false;
        ifGameEnds = false;
        mediaPlayerWins.stop();
        mediaPlayerLoses.stop();
        symbolWon = 0;

        //determining whose first turn it is each time
        FirstTurnComp();

        //cleaning the board
        for (int i = 0; i < 9; i++) {
            button[i].setDisable(false);
            button[i].setText("");
            button[i].setStyle("-fx-text-fill:#473C33;-fx-background-color: #F3CA82,linear-gradient(#F3CA82 50%, #F6BC59 100%),radial-gradient(center 50% -40%, radius 200%, #F3CA82 45%, #F6BC59 50%) ;-fx-background-radius:10;-fx-border-color: #BD8421;-fx-border-width:3px;-fx-border-radius: 10;");
        }

    }

}
