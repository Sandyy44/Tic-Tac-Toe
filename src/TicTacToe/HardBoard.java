package TicTacToe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

//it inherits the absrtacted class "GeneralBoard"
public class HardBoard extends GeneralBoard {

    public void hardMode() {
        scorevalue = 0;
        scoreButtons.setText("0");

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

                    if (ifGameEnds == false) {
                        for (;;) {
                            CheckIfCanWin();
                            if (checkWin == true) {
                                userTurn = true;
                                playerturn.setText("Your Turn");
                                CheckWinner();
                                if (symbolWon == 2) {
                                    playerturn.setText("You Lost :(");
                                    ifGameEnds = true;
                                }
                                checkWin = false;
                                preventDoubleMove = false;
                                break;
                            } else if (doesWin == false && checkWin == false) {
                                int x = random2.nextInt(9);
                                if (x % 2 == 0 && x != 4 && button[x].getText() == "") {

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

                                } else if (x == 4 && button[0].getText() != "" && button[2].getText() != "" && button[6].getText() != "" && button[8].getText() != "") {
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
                                } else if (button[0].getText() != "" && button[2].getText() != "" && button[6].getText() != "" && button[8].getText() != "" && button[4].getText() != "") {
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

                            } else if (doesWin == true) {
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
                    if (ifGameEnds == false) {
                        for (;;) {
                            CheckIfCanWin();
                            if (checkWin == true) {
                                userTurn = true;
                                playerturn.setText("Your Turn");
                                CheckWinner();
                                if (symbolWon == 1) {
                                    playerturn.setText("You Lost :(");
                                    ifGameEnds = true;
                                }
                                preventDoubleMove = false;
                                checkWin = false;
                                break;
                            } else if (doesWin == false && checkWin == false) {
                                int x = random2.nextInt(9);
                                if (x % 2 == 0 && x != 4 && button[x].getText() == "") {
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
                                } else if (x == 4 && button[0].getText() != "" && button[2].getText() != "" && button[6].getText() != "" && button[8].getText() != "") {
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
                                } else if (button[0].getText() != "" && button[2].getText() != "" && button[6].getText() != "" && button[8].getText() != "" && button[4].getText() != "") {
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
                            } else if (doesWin == true) {
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

    //checking all the probabilities of winning or preventing losing
    public void CheckIfCanWin() {
        if (symbol == "X") {
            if (button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "" && end == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                end = true;
                ifGameEnds = true;
            }
            if (button[0].getText() == "O" && button[6].getText() == "O" && button[3].getText() == "" && end == false) {
                button[3].setText("O");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[6].getText() == "O" && button[3].getText() == "O" && button[0].getText() == "" && end == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;

            }

            if (button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "" && end == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[0].getText() == "O" && button[2].getText() == "O" && button[1].getText() == "" && end == false) {
                button[1].setText("O");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "O" && button[1].getText() == "O" && button[0].getText() == "" && end == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "" && end == false) {
                button[5].setText("O");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[3].getText() == "O" && button[5].getText() == "O" && button[4].getText() == "" && end == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[5].getText() == "O" && button[4].getText() == "O" && button[3].getText() == "" && end == false) {
                button[3].setText("O");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "" && end == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[6].getText() == "O" && button[8].getText() == "O" && button[7].getText() == "" && end == false) {
                button[7].setText("O");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[8].getText() == "O" && button[7].getText() == "O" && button[6].getText() == "" && end == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "" && end == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[0].getText() == "O" && button[8].getText() == "O" && button[4].getText() == "" && end == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[4].getText() == "O" && button[8].getText() == "O" && button[0].getText() == "" && end == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "" && end == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[6].getText() == "O" && button[4].getText() == "O" && button[2].getText() == "" && end == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "O" && button[6].getText() == "O" && button[4].getText() == "" && end == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "" && end == false) {
                button[7].setText("O");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[7].getText() == "O" && button[4].getText() == "O" && button[1].getText() == "" && end == false) {
                button[1].setText("O");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[7].getText() == "O" && button[1].getText() == "O" && button[4].getText() == "" && end == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "" && end == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "O" && button[8].getText() == "O" && button[5].getText() == "" && end == false) {
                button[5].setText("O");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[8].getText() == "O" && button[5].getText() == "O" && button[2].getText() == "" && end == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "X" && button[2].getText() == "X" && button[1].getText() == "" && end == false && preventDoubleMove == false) {
                button[1].setText("O");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "X" && button[1].getText() == "X" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "" && end == false && preventDoubleMove == false) {
                button[5].setText("O");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[3].getText() == "X" && button[5].getText() == "X" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[5].getText() == "X" && button[4].getText() == "X" && button[3].getText() == "" && end == false && preventDoubleMove == false) {
                button[3].setText("O");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[6].getText() == "X" && button[8].getText() == "X" && button[7].getText() == "" && end == false && preventDoubleMove == false) {
                button[7].setText("O");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[8].getText() == "X" && button[7].getText() == "X" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "X" && button[8].getText() == "X" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[4].getText() == "X" && button[8].getText() == "X" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[6].getText() == "X" && button[4].getText() == "X" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "X" && button[6].getText() == "X" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("O");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "X" && button[6].getText() == "X" && button[3].getText() == "" && end == false && preventDoubleMove == false) {
                button[3].setText("O");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[3].getText() == "X" && button[6].getText() == "X" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("O");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "" && end == false && preventDoubleMove == false) {
                button[7].setText("O");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[7].getText() == "X" && button[4].getText() == "X" && button[1].getText() == "" && end == false && preventDoubleMove == false) {
                button[1].setText("O");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[7].getText() == "X" && button[1].getText() == "X" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("O");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("O");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "X" && button[8].getText() == "X" && button[5].getText() == "" && end == false && preventDoubleMove == false) {
                button[5].setText("O");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[8].getText() == "X" && button[5].getText() == "X" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("O");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

        }
        if (symbol == "O") {

            if (button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "" && end == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                end = true;
                ifGameEnds = true;

            }
            if (button[0].getText() == "X" && button[6].getText() == "X" && button[3].getText() == "" && end == false) {
                button[3].setText("X");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;

            }
            if (button[6].getText() == "X" && button[3].getText() == "X" && button[0].getText() == "" && end == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;

            }

            if (button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "" && end == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;

            }
            if (button[0].getText() == "X" && button[2].getText() == "X" && button[1].getText() == "" && end == false) {
                button[1].setText("X");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "X" && button[1].getText() == "X" && button[0].getText() == "" && end == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "" && end == false) {
                button[5].setText("X");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[3].getText() == "X" && button[5].getText() == "X" && button[4].getText() == "" && end == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[5].getText() == "X" && button[4].getText() == "X" && button[3].getText() == "" && end == false) {
                button[3].setText("X");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "" && end == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[6].getText() == "X" && button[8].getText() == "X" && button[7].getText() == "" && end == false) {
                button[7].setText("X");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[8].getText() == "X" && button[7].getText() == "X" && button[6].getText() == "" && end == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "" && end == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[0].getText() == "X" && button[8].getText() == "X" && button[4].getText() == "" && end == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[4].getText() == "X" && button[8].getText() == "X" && button[0].getText() == "" && end == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "" && end == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[6].getText() == "X" && button[4].getText() == "X" && button[2].getText() == "" && end == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "X" && button[6].getText() == "X" && button[4].getText() == "" && end == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "" && end == false) {
                button[7].setText("X");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[7].getText() == "X" && button[4].getText() == "X" && button[1].getText() == "" && end == false) {
                button[1].setText("X");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[7].getText() == "X" && button[1].getText() == "X" && button[4].getText() == "" && end == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "" && end == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[2].getText() == "X" && button[8].getText() == "X" && button[5].getText() == "" && end == false) {
                button[5].setText("X");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }
            if (button[8].getText() == "X" && button[5].getText() == "X" && button[2].getText() == "" && end == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                doesWin = true;
                ifGameEnds = true;
                end = true;
            }

            if (button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "O" && button[2].getText() == "O" && button[1].getText() == "" && end == false && preventDoubleMove == false) {
                button[1].setText("X");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "O" && button[1].getText() == "O" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "" && end == false && preventDoubleMove == false) {
                button[5].setText("X");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[3].getText() == "O" && button[5].getText() == "O" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[5].getText() == "O" && button[4].getText() == "O" && button[3].getText() == "" && end == false && preventDoubleMove == false) {
                button[3].setText("X");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[6].getText() == "O" && button[8].getText() == "O" && button[7].getText() == "" && end == false && preventDoubleMove == false) {
                button[7].setText("X");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[8].getText() == "O" && button[7].getText() == "O" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "O" && button[8].getText() == "O" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[4].getText() == "O" && button[8].getText() == "O" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[6].getText() == "O" && button[4].getText() == "O" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "O" && button[6].getText() == "O" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }

            if (button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "" && end == false && preventDoubleMove == false) {
                button[6].setText("X");
                button[6].setDisable(true);
                button[6].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[0].getText() == "O" && button[6].getText() == "O" && button[3].getText() == "" && end == false && preventDoubleMove == false) {
                button[3].setText("X");
                button[3].setDisable(true);
                button[3].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[3].getText() == "O" && button[6].getText() == "O" && button[0].getText() == "" && end == false && preventDoubleMove == false) {
                button[0].setText("X");
                button[0].setDisable(true);
                button[0].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "" && end == false && preventDoubleMove == false) {
                button[7].setText("X");
                button[7].setDisable(true);
                button[7].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[7].getText() == "O" && button[4].getText() == "O" && button[1].getText() == "" && end == false && preventDoubleMove == false) {
                button[1].setText("X");
                button[1].setDisable(true);
                button[1].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[7].getText() == "O" && button[1].getText() == "O" && button[4].getText() == "" && end == false && preventDoubleMove == false) {
                button[4].setText("X");
                button[4].setDisable(true);
                button[4].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "" && end == false && preventDoubleMove == false) {
                button[8].setText("X");
                button[8].setDisable(true);
                button[8].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[2].getText() == "O" && button[8].getText() == "O" && button[5].getText() == "" && end == false && preventDoubleMove == false) {
                button[5].setText("X");
                button[5].setDisable(true);
                button[5].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
            if (button[8].getText() == "O" && button[5].getText() == "O" && button[2].getText() == "" && end == false && preventDoubleMove == false) {
                button[2].setText("X");
                button[2].setDisable(true);
                button[2].setOpacity(1);
                checkWin = true;
                preventDoubleMove = true;
            }
        }
    }
}
