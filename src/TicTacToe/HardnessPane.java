package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class HardnessPane extends StackPane {

    GeneralDesign general = new GeneralDesign("Please Choose The Hardness");

    final GridPane hardness = new GridPane();

    //final textStyle directUser = new textStyle("Please Choose The Hardness");
    final Buttons easy = new Buttons("Easy");
    final Buttons medium = new Buttons("Medium");
    final Buttons hard = new Buttons("Hard");

    HardnessPane() {
        easy.setPrefWidth(200);
        medium.setPrefWidth(200);
        hard.setPrefWidth(200);

        general.directUser.setStyle(" -fx-font-size: 36px;");

        hardness.add(easy, 0, 0);
        hardness.add(medium, 0, 1);
        hardness.add(hard, 0, 2);
        hardness.setVgap(5);
        hardness.setPadding(new Insets(10));
        GridPane.setMargin(easy, new Insets(5));
        GridPane.setMargin(medium, new Insets(5));
        GridPane.setMargin(hard, new Insets(5));
        getChildren().addAll(general, hardness);

        hardness.setAlignment(Pos.BOTTOM_CENTER);
        hardness.setTranslateY(-40);

    }
}
