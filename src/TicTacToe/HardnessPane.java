package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HardnessPane extends StackPane {

    Buttons BackButton = new Buttons("Back");

    GeneralDesign general = new GeneralDesign("Please Choose The Hardness");

    final GridPane hardness = new GridPane();

    final Buttons easy = new Buttons("Easy");
    final Buttons medium = new Buttons("Medium");
    final Buttons hard = new Buttons("Hard");

    HardnessPane() {

        BackButton.setPrefWidth(90);
        BackButton.setFocusTraversable(false);
        BackButton.setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");
        BackButton.setFont(Font.font("Monaco", FontWeight.BOLD, 20));
        BackButton.setAlignment(Pos.TOP_LEFT);
        BackButton.setTranslateX(-190);
        BackButton.setTranslateY(-270);
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
        getChildren().addAll(general, hardness, BackButton);

        hardness.setAlignment(Pos.BOTTOM_CENTER);
        hardness.setTranslateY(-40);

    }
}
