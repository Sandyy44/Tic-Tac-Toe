package TicTacToe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EasyBoard extends GeneralBoard {

    public void easyMode() {

        newGame();

        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        if (symbol == "X") {
            if (ifGameEnds == false && clickedButton.getText() == "") {
                if (ifGameEnds == false && userTurn) {
                    clickedButton.setText("X");
                    userTurn = false;
                    clickedButton.setDisable(true);
                    clickedButton.setOpacity(1);
                    playerturn.setText("Computer Turn");
                    CheckWinner();
                    if (symbolWon == 1) {
                        playerturn.setText("You Won!!");
                        ifGameEnds = true;
                    }
                }
                if (ifGameEnds == false && userTurn == false) {
                    for (;;) {
                        int x = random2.nextInt(9);
                        Button myButton = button[x];
                        if (ifGameEnds == false && myButton.getText() == "") {
                            myButton.setText("O");
                            myButton.setDisable(true);
                            myButton.setOpacity(1);
                            userTurn = true;
                            playerturn.setText("Your Turn");
                            CheckWinner();
                            if (symbolWon == 2) {
                                playerturn.setText("You Lost :(");
                                ifGameEnds = true;
                            }
                            break;
                        }
                    }

                }
            }
        }
        if (symbol == "O") {
            if (ifGameEnds == false && clickedButton.getText() == "") {
                if (ifGameEnds == false && userTurn) {
                    clickedButton.setText("O");
                    userTurn = false;
                    clickedButton.setDisable(true);
                    clickedButton.setOpacity(1);
                    playerturn.setText("Computer Turn");
                    CheckWinner();
                    if (symbolWon == 2) {
                        playerturn.setText("You Won!!");
                        ifGameEnds = true;
                    }
                }
                if (ifGameEnds == false && userTurn == false) {
                    for (;;) {
                        int x = random2.nextInt(9);
                        Button myButton = button[x];
                        if (ifGameEnds == false && myButton.getText() == "") {
                            myButton.setText("X");
                            myButton.setDisable(true);
                            myButton.setOpacity(1);
                            userTurn = true;
                            playerturn.setText("Your Turn");
                            CheckWinner();
                            if (symbolWon == 1) {
                                playerturn.setText("You Lost :(");
                                ifGameEnds = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
