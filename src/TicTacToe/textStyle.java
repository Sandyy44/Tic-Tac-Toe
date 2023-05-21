package TicTacToe;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//setting up a special design for text
public class textStyle extends Text {

    textStyle(String s) {

        setText(s);
        //text color
        setFill(Color.web("0x729B6D"));

        //font familiy
        Font font = Font.font("MV Boli");
        setFont(font);

        //text outline
        setStrokeWidth(2);
        setStroke(Color.web("0x183D14"));

    }

}
