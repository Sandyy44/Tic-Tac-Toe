package TicTacToe;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Buttons extends Button {

    //setting up a click sound
    String musicFile = "SoundsFiles/Button Click.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    //a constructor with a special design for normal buttons
    Buttons(String s) {

        //passing the text to the parent class
        super(s);

        //setting up the properties for the buttons
        setFont(Font.font("MV Boli", FontWeight.BOLD, 30));
        setPrefSize(300, 30);
        setFocusTraversable(false);
        setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");
        setFont(Font.font("MV Boli", FontWeight.BOLD, 25));

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

        //to reset the color after it's clicked
        addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");
                mediaPlayer.play();

            }
        });

        //to set a diffrent color shade wshen we pressing the button
        addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                setStyle("-fx-text-fill:#20282C ;-fx-background-color: #7C9C64;-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");

                //important to prevent click sound lagging 
                mediaPlayer.stop();

            }
        });

        //to reset the main button colors back after releasing it
        addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setStyle("-fx-text-fill:#20282C ;-fx-background-color: #8CB76B,linear-gradient(#8CB76B 50%, #B2DF90 100%),radial-gradient(center 50% -40%, radius 200%, #B2DF90 45%, #8CB76B 50%);-fx-background-radius:50;-fx-border-color:#5D9036 ;-fx-border-width:3px;-fx-border-radius: 50;");

            }
        });

    }

    //creating another constructor with another special design for tic tac toe board buttons
    Buttons() {
        setFocusTraversable(false);
        setStyle("-fx-text-fill:#473C33;-fx-background-color: #F3CA82,linear-gradient(#F3CA82 50%, #F6BC59 100%),radial-gradient(center 50% -40%, radius 200%, #F3CA82 45%, #F6BC59 50%) ;-fx-background-radius:10;-fx-border-color: #BD8421;-fx-border-width:3px;-fx-border-radius: 10;");
        setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));

        DropShadow shadow = new DropShadow();
        addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                mediaPlayer.play();

            }
        });
        //Adding the shadow when the mouse cursor is on the button
        addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setEffect(shadow);
            }
        }
        );

        addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //important to prevent click sound lagging 
                mediaPlayer.stop();

            }
        });

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
