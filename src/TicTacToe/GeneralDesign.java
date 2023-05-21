package TicTacToe;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import static javafx.scene.layout.StackPane.setAlignment;

//this class is for the fixed attributes of start, hardness and symbol stackpanes
//to preventing repeating the same lines of code
public class GeneralDesign extends StackPane {

    final textStyle text = new textStyle("Tic Tac Toe");
    final ImageView background = new ImageView(new Image("finalBackground.gif"));
    textStyle directUser;

    public GeneralDesign(String s) {

        directUser = new textStyle(s);
        setAlignment(directUser, Pos.CENTER);
        directUser.setTranslateY(-40);
        background.setFitHeight(600);
        background.setFitWidth(500);
        text.setStyle(" -fx-font-size: 70px;");
        setAlignment(text, Pos.TOP_CENTER);
        getChildren().addAll(background, text, directUser);
        setAlignment(text, Pos.TOP_CENTER);
        text.setTranslateY(50);
        setStyle("-fx-border-color:#BF5723;-fx-border-width:5px;-fx-border-radius:1px;");
    }

}
