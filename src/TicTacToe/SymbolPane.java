package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class SymbolPane extends StackPane {

    GeneralDesign general = new GeneralDesign("Please Choose The Symbol");
    final GridPane symbol = new GridPane();
    final Buttons x = new Buttons("X");
    final Buttons o = new Buttons("O");
    final Buttons randomly = new Buttons("Random");

    SymbolPane() {

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
        getChildren().addAll(general, symbol);
        symbol.setAlignment(Pos.BOTTOM_CENTER);
        symbol.setTranslateY(-40);
    }
}
