package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class StartPane extends StackPane {

    final GridPane mode = new GridPane();
    final Buttons singlePlayer = new Buttons("Against Computer");
    final Buttons twoPlayers = new Buttons("Two Players");
    GeneralDesign general = new GeneralDesign("Please Choose The Mode");
    settingsButton settingsbutton = new settingsButton();

    StartPane() {

        general.directUser.setStyle(" -fx-font-size: 40px;");
        mode.add(twoPlayers, 0, 0);
        mode.add(singlePlayer, 0, 1);
        mode.setVgap(5);
        mode.setPadding(new Insets(10));
        GridPane.setMargin(singlePlayer, new Insets(5));
        GridPane.setMargin(twoPlayers, new Insets(5));
        getChildren().addAll(general, mode, settingsbutton);
        mode.setAlignment(Pos.BOTTOM_CENTER);
        mode.setTranslateY(-100);
    }

}
