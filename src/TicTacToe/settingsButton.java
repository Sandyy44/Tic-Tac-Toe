package TicTacToe;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

public class settingsButton extends Button {

    settingsButton() {

        setStyle("-fx-border-color: transparent;-fx-border-width: 0;  -fx-background-radius: 0;  -fx-background-color: transparent;");
        setTranslateX(-213);
        setTranslateY(-267);
        setBackground(Background.EMPTY);
        ImageView icon = new ImageView(new Image("Settings-icon-symbol.png"));
        icon.setFitWidth(50);
        icon.setFitHeight(50);
        setGraphic(icon);
        setFocusTraversable(false);

        //creating shadow effect
        DropShadow shadow = new DropShadow();

        //Adding the shadow when the mouse cursor is on the button
        addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setEffect(shadow);
            }
        }
        );

        //Removing the shadow when the mouse cursor is off it
        addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setEffect(null);
            }
        });
    }

}
