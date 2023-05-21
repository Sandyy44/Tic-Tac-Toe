package TicTacToe;

import java.io.File;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class BoardPane extends StackPane {

    //setting up the background of the game board StackPane
    final ImageView background = new ImageView(new Image("greenBackground.jpg"));

    //setting up the array of the buttons for the tic tac toe game
    final Buttons[] button = new Buttons[9];

    //setting up the grid which will contain the buttons array
    final GridPane gridBtns = new GridPane();

    //setting up the grid which will contain the "back" and "new game" buttons
    final GridPane Btns = new GridPane();

    final Buttons back = new Buttons("Back"); //to go back to the first scene
    final Buttons newGame = new Buttons("New Game"); //to reset the game

    //letting the user knows whose turn it is
    final Label playerturn = new Label("");

    //whose turn it is (X or O)
    boolean player1Turn;

    //letting the computer knows if the game has been ended or not
    boolean ifGameEnds = false;

    //for FirstTurn() Method
    Random random = new Random();

    //setting up a winning sound
    Media WinningSound = new Media(new File("SoundsFiles/Winning Sound.mp3").toURI().toString());
    MediaPlayer mediaPlayerWins = new MediaPlayer(WinningSound);

    BoardPane() {

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

            column++;
            if (column == 3) {
                row++;
                column = 0;
            }

        }

        //adding all the nodes to this StackPane class & setting the position for each node in it
        getChildren().addAll(background, playerturn, Btns, gridBtns);
        playerturn.setAlignment(Pos.TOP_CENTER);
        playerturn.setTranslateY(-250);
        gridBtns.setAlignment(Pos.BOTTOM_CENTER);
        gridBtns.setTranslateY(-120);
        Btns.setAlignment(Pos.BOTTOM_CENTER);
        Btns.setTranslateY(-10);

    }

    public void playing() {
        for (int i = 0; i < 9; i++) {
            Button myButton = button[i];
            myButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (player1Turn && ifGameEnds == false && myButton.getText() == "") {
                        myButton.setText("X");
                        myButton.setDisable(true);
                        myButton.setOpacity(1);
                        player1Turn = false;
                        playerturn.setText("O Turn");
                        CheckWinner();
                    } else if (player1Turn == false && ifGameEnds == false && myButton.getText() == "") {
                        myButton.setText("O");
                        myButton.setDisable(true);
                        myButton.setOpacity(1);
                        player1Turn = true;
                        playerturn.setText("X Turn");
                        CheckWinner();
                    }
                }
            });
        }
    }

    //determining which turn it is (X or O)
    public void FirstTurn() {
        if (random.nextInt(2) == 0) {
            player1Turn = true;
            playerturn.setText("X Turn");
        } else {
            player1Turn = false;
            playerturn.setText("O Turn");
        }
    }

    //checking if there is a winning state
    public void CheckWinner() {

        if (button[0].getText() == "X"
                && button[1].getText() == "X"
                && button[2].getText() == "X") {

            Xwins(0, 1, 2);

        } else if (button[3].getText() == "X"
                && button[4].getText() == "X"
                && button[5].getText() == "X") {
            Xwins(3, 4, 5);

        } else if (button[6].getText() == "X"
                && button[7].getText() == "X"
                && button[8].getText() == "X") {
            Xwins(6, 7, 8);

        } else if (button[0].getText() == "X"
                && button[4].getText() == "X"
                && button[8].getText() == "X") {
            Xwins(0, 4, 8);

        } else if (button[0].getText() == "X"
                && button[3].getText() == "X"
                && button[6].getText() == "X") {
            Xwins(0, 3, 6);
        } else if (button[1].getText() == "X"
                && button[4].getText() == "X"
                && button[7].getText() == "X") {
            Xwins(1, 4, 7);
        } else if (button[2].getText() == "X"
                && button[5].getText() == "X"
                && button[8].getText() == "X") {
            Xwins(2, 5, 8);
        } else if (button[2].getText() == "X"
                && button[4].getText() == "X"
                && button[6].getText() == "X") {
            Xwins(2, 4, 6);
        } else if (button[2].getText() == "O"
                && button[4].getText() == "O"
                && button[6].getText() == "O") {
            Owins(2, 4, 6);
        } else if (button[0].getText() == "O"
                && button[1].getText() == "O"
                && button[2].getText() == "O") {
            Owins(0, 1, 2);

        } else if (button[3].getText() == "O"
                && button[4].getText() == "O"
                && button[5].getText() == "O") {
            Owins(3, 4, 5);
        } else if (button[6].getText() == "O"
                && button[7].getText() == "O"
                && button[8].getText() == "O") {
            Owins(6, 7, 8);
        } else if (button[0].getText() == "O"
                && button[4].getText() == "O"
                && button[8].getText() == "O") {
            Owins(0, 4, 8);

        } else if (button[0].getText() == "O"
                && button[3].getText() == "O"
                && button[6].getText() == "O") {
            Owins(0, 3, 6);
        } else if (button[1].getText() == "O"
                && button[4].getText() == "O"
                && button[7].getText() == "O") {
            Owins(1, 4, 7);
        } else if (button[2].getText() == "O"
                && button[5].getText() == "O"
                && button[8].getText() == "O") {
            Owins(2, 5, 8);
        } else {
            int checkTie = 0;
            for (int i = 0; i < 9; i++) {
                if (button[i].getText() == "O" || button[i].getText() == "X") {
                    checkTie++;
                    if (checkTie == 9) {
                        Tie();
                    }
                }
            }
        }

    }

    //they are invoked if there  is a winning state in CheckWinner() method to set the winning buttons a winnng color
    //and a winning sound
    public void Xwins(int a, int b, int c) {
        button[a].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #37CD37 100%),radial-gradient(center 50% -40%, radius 200%, #37CD37 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        button[b].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #37CD37 100%),radial-gradient(center 50% -40%, radius 200%, #37CD37 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        button[c].setStyle("-fx-background-color: #009900,linear-gradient(#009900 50%, #37CD37 100%),radial-gradient(center 50% -40%, radius 200%, #37CD37 45%, #009900 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        playerturn.setText("X Wins!!");
        mediaPlayerWins.play();
        disableBtn();
        ifGameEnds = true;
    }

    public void Owins(int a, int b, int c) {
        button[a].setStyle("-fx-background-color: #37CD37,linear-gradient(#37CD37 50%, #009900 100%),radial-gradient(center 50% -40%, radius 200%, #009900 45%, #37CD37 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        button[b].setStyle("-fx-background-color: #37CD37,linear-gradient(#37CD37 50%, #009900 100%),radial-gradient(center 50% -40%, radius 200%, #009900 45%, #37CD37 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        button[c].setStyle("-fx-background-color: #37CD37,linear-gradient(#37CD37 50%, #009900 100%),radial-gradient(center 50% -40%, radius 200%, #009900 45%, #37CD37 50%) ;-fx-background-radius:10;-fx-border-color: #0D410D;-fx-border-width:3px;-fx-border-radius: 10;");
        disableBtn();
        playerturn.setText("O Wins!!");
        mediaPlayerWins.play();
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

    public void newGame() {
        ifGameEnds = false;
        mediaPlayerWins.stop();
        FirstTurn();
        for (int i = 0; i < 9; i++) {
            button[i].setDisable(false);
            button[i].setText("");
            button[i].setStyle("-fx-text-fill:#473C33;-fx-background-color: #F3CA82,linear-gradient(#F3CA82 50%, #F6BC59 100%),radial-gradient(center 50% -40%, radius 200%, #F3CA82 45%, #F6BC59 50%) ;-fx-background-radius:10;-fx-border-color: #BD8421;-fx-border-width:3px;-fx-border-radius: 10;");
        }
    }

    //settting up the job of the "back" button
    //to clean the board from whatever happened to it
    public void backBtn() {
        for (int i = 0; i < 9; i++) {
            button[i].setDisable(false);
            button[i].setText("");
            button[i].setStyle("-fx-text-fill:#473C33;-fx-background-color: #F3CA82,linear-gradient(#F3CA82 50%, #F6BC59 100%),radial-gradient(center 50% -40%, radius 200%, #F3CA82 45%, #F6BC59 50%) ;-fx-background-radius:10;-fx-border-color: #BD8421;-fx-border-width:3px;-fx-border-radius: 10;");
        }
    }

    public void TwoPlayersMode() {
        newGame();
        playing();
        if (ifGameEnds == true) {
            disableBtn();
        }

    }

}
