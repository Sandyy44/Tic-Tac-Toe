package TicTacToe;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class musicButton extends Button {

    //setting up a background music
    String musicFile = "SoundsFiles/My Coffee.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    musicButton() {

        setStyle("-fx-border-color: transparent;-fx-border-width: 0;  -fx-background-radius: 0;  -fx-background-color: transparent;");
        setBackground(Background.EMPTY);
        ImageView iconOn = new ImageView(new Image("onsound.png"));
        iconOn.setFitWidth(80);
        iconOn.setFitHeight(80);
        setGraphic(iconOn);
        setFocusTraversable(false);
        setPrefSize(80, 80);
        ImageView iconOff = new ImageView(new Image("offsound.png"));

        //to keep the playing endless times
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });

        mediaPlayer.play();

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
        //setting up the job of the music button
        //if the music was on and the user clicked the music button, then pause the music
        //if it was paused, then turn it on
        setOnAction(e -> {
            if (mediaPlayer.getStatus().equals(Status.PLAYING)) {
                setBackground(Background.EMPTY);
                iconOff.setFitWidth(80);
                iconOff.setFitHeight(80);
                setFocusTraversable(false);
                setPrefSize(80, 80);
                setGraphic(iconOff);
                mediaPlayer.pause();
            } else if (mediaPlayer.getStatus().equals(Status.PAUSED)) {
                setBackground(Background.EMPTY);
                iconOn.setFitWidth(80);
                iconOn.setFitHeight(80);
                setFocusTraversable(false);
                setPrefSize(80, 80);
                setGraphic(iconOn);
                mediaPlayer.setOnEndOfMedia(new Runnable() {
                    public void run() {
                        mediaPlayer.seek(Duration.ZERO);
                    }
                });

                mediaPlayer.play();
            }

        });

    }

}
