package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SymbolPane extends StackPane {

    Buttons BackButton = new Buttons("Back");

    GeneralDesign general = new GeneralDesign("Please Choose The Symbol");
    final GridPane symbol = new GridPane();
    final Buttons x = new Buttons("X");
    final Buttons o = new Buttons("O");
    final Buttons randomly = new Buttons("Random");

    SymbolPane() {
        BackButton.setPrefWidth(90);
        BackButton.setFocusTraversable(false);
        BackButton.setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");
        BackButton.setFont(Font.font("Monaco", FontWeight.BOLD, 20));
        BackButton.setAlignment(Pos.TOP_LEFT);
        BackButton.setTranslateX(-190);
        BackButton.setTranslateY(-270);
        x.setPrefWidth(200);
        o.setPrefWidth(200);
        randomly.setPrefWidth(200);
        general.directUser.setStyle(" -fx-font-size: 37px;");
        symbol.add(x, 0, 0);
        symbol.add(o, 0, 1);
        symbol.add(randomly, 0, 2);
        symbol.setVgap(5);
        symbol.setPadding(new Insets(10));
        GridPane.setMargin(x, new Insets(5));
        GridPane.setMargin(o, new Insets(5));
        GridPane.setMargin(randomly, new Insets(5));
        getChildren().addAll(general, symbol, BackButton);
        symbol.setAlignment(Pos.BOTTOM_CENTER);
        symbol.setTranslateY(-40);
    }
}
