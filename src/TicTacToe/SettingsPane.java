package TicTacToe;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import static javafx.scene.layout.StackPane.setAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SettingsPane extends StackPane {

    musicButton musicbutton = new musicButton();
    final textStyle text = new textStyle("Settings");
    final ImageView background = new ImageView(new Image("settingsback.jpg"));
    Buttons back = new Buttons("Back");
    Buttons exit = new Buttons("Exit");
    Text music = new Text("Music");

    SettingsPane() {
        back.setPrefWidth(200);
        exit.setPrefWidth(200);
        background.setFitHeight(600);
        background.setFitWidth(500);
        text.setStyle(" -fx-font-size: 70px;");
        music.setFont(Font.font(20));
        getChildren().addAll(background, text, musicbutton, back, music, exit);
        setAlignment(text, Pos.TOP_CENTER);
        setAlignment(musicbutton, Pos.CENTER);
        musicbutton.setTranslateY(-50);
        setAlignment(back, Pos.CENTER);
        back.setTranslateY(80);
        setAlignment(exit, Pos.CENTER);
        exit.setTranslateY(170);
        setAlignment(music, Pos.CENTER);
        music.setTranslateY(5);
        text.setTranslateY(20);
        setStyle("-fx-border-color:#BF5723;-fx-border-width:5px;-fx-border-radius:1px;");
        exit.setOnAction(e -> Platform.exit());

    }

}
