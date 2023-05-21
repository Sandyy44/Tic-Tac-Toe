package TicTacToe;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class overallView {

    //passing the stage here to keep the main class clean
    overallView(Stage stage) {

        //creating an object of our StartPane class
        StartPane startPane = new StartPane();

        //putting it into a Group to prevent the StackPane from expanding to the whole stage while resizing it
        //forcing it to only stay in the given space 
        Group startGroup = new Group(startPane);

        //As the default position of the group is top left corner of the stage 
        //we had to put it into a new StackPane to force the group to be the center of the stage
        StackPane startPaneBase = new StackPane(startGroup);

        //setting a background color for our base StackPane
        startPaneBase.setStyle("-fx-background:#FFB366;");

        //
        //
        //DOING THE SAME PROCESS TO ALL OF OUR STACKPANE CLASSES
        //
        //
        //creating an object of the HardnessPane class to use it with single player mode
        HardnessPane hardnessPane = new HardnessPane();
        Group hardnessGroup = new Group(hardnessPane);
        StackPane hardnessPaneBase = new StackPane(hardnessGroup);
        hardnessPaneBase.setStyle("-fx-background:#FFB366;");

        //creating an object from SymbolPane class to use it in the easy level
        SymbolPane symbolEasy = new SymbolPane();
        Group symbolEasyGroup = new Group(symbolEasy);
        StackPane symbolEasyBase = new StackPane(symbolEasyGroup);
        symbolEasyBase.setStyle("-fx-background:#FFB366;");

        //creating an object from SymbolPane class to use it in the medium level
        SymbolPane symbolMedium = new SymbolPane();
        Group symbolMediumGroup = new Group(symbolMedium);
        StackPane symbolMediumBase = new StackPane(symbolMediumGroup);
        symbolMediumBase.setStyle("-fx-background:#FFB366;");

        //creating an object from SymbolPane class to use it in the hard level
        SymbolPane symbolHard = new SymbolPane();
        Group symbolHardGroup = new Group(symbolHard);
        StackPane symbolHardBase = new StackPane(symbolHardGroup);
        symbolHardBase.setStyle("-fx-background:#FFB366;");

        //creating an object from BoardPane class to use it in two players mode
        BoardPane boardPane = new BoardPane();
        Group boardGroup = new Group(boardPane);
        StackPane boardBase = new StackPane(boardGroup);
        boardBase.setStyle("-fx-background:#FFB366;");

        //creating an object from EasyBoard class to use it in single players mode
        EasyBoard easyBoard = new EasyBoard();
        Group easyBoardGroup = new Group(easyBoard);
        StackPane easyBoardBase = new StackPane(easyBoardGroup);
        easyBoardBase.setStyle("-fx-background:#FFB366;");

        //creating an object from MediumBoard class to use it in single players mode
        MediumBoard mediumBoard = new MediumBoard();
        Group mediumBoardGroup = new Group(mediumBoard);
        StackPane mediumBoardBase = new StackPane(mediumBoardGroup);
        mediumBoardBase.setStyle("-fx-background:#FFB366;");

        //creating an object from HardBoard class to use it in single players mode
        HardBoard hardBoard = new HardBoard();
        Group hardBoardGroup = new Group(hardBoard);
        StackPane hardBoardBase = new StackPane(hardBoardGroup);
        hardBoardBase.setStyle("-fx-background:#FFB366;");

        //creating an object from SettingsPane class to use it in the start pane
        SettingsPane settingsStartPane = new SettingsPane();
        Group settingsStartGroup = new Group(settingsStartPane);
        StackPane settingsStartBase = new StackPane(settingsStartGroup);
        settingsStartBase.setStyle("-fx-background:#FFB366;");

        //
        //
        //centring all the groups to the base StackPane
        //
        //
        hardnessGroup.setTranslateY(-19.1);
        hardnessGroup.setTranslateX(-0.4);

        symbolEasyGroup.setTranslateY(-19.1);
        symbolEasyGroup.setTranslateX(-0.4);

        symbolHardGroup.setTranslateY(-19.1);
        symbolHardGroup.setTranslateX(-0.4);

        symbolMediumGroup.setTranslateY(-19.1);
        symbolMediumGroup.setTranslateX(-0.4);

        startGroup.setTranslateY(-49);
        startGroup.setTranslateX(-0.4);

        boardGroup.setTranslateY(-58);

        easyBoardGroup.setTranslateY(-58);
        mediumBoardGroup.setTranslateY(-58);
        hardBoardGroup.setTranslateY(-58);

        //creating our main scene and passing it the start page and its preferable size
        Scene startScene = new Scene(startPaneBase, 510, 610);

        //setting up our application name
        stage.setTitle("Tic Tac Toe");

        //setting up our application logo
        Image logo = new Image("tic-tac-toe.png");
        stage.getIcons().add(logo);

        //passing the scene to the stage
        stage.setScene(startScene);

        //
        //
        //
        //connecting all the buttons to all the diffrent stackpanes
        //and invoking all the diffrent wanted methods
        //
        //
        //
        startPane.singlePlayer.setOnAction(e -> stage.getScene().setRoot(hardnessPaneBase));

        startPane.twoPlayers.setOnAction(e -> {
            stage.getScene().setRoot(boardBase);
            boardPane.TwoPlayersMode();
        });

        symbolEasy.x.setOnAction(e -> {
            easyBoard.X();
            stage.getScene().setRoot(easyBoardBase);
            easyBoard.easyMode();

        });

        symbolEasy.o.setOnAction(e -> {
            easyBoard.O();
            stage.getScene().setRoot(easyBoardBase);
            easyBoard.easyMode();
        });

        symbolEasy.randomly.setOnAction(e -> {
            easyBoard.randomly();
            stage.getScene().setRoot(easyBoardBase);
            easyBoard.easyMode();

        });

        symbolHard.x.setOnAction(e -> {
            hardBoard.X();
            stage.getScene().setRoot(hardBoardBase);
            hardBoard.hardMode();
        });

        symbolHard.o.setOnAction(e -> {
            hardBoard.O();
            stage.getScene().setRoot(hardBoardBase);
            hardBoard.hardMode();
        });

        symbolHard.randomly.setOnAction(e -> {
            hardBoard.randomly();
            stage.getScene().setRoot(hardBoardBase);
            hardBoard.hardMode();
        });

        symbolMedium.x.setOnAction(e -> {
            mediumBoard.X();
            stage.getScene().setRoot(mediumBoardBase);
            mediumBoard.mediumMode();
        });

        symbolMedium.o.setOnAction(e -> {
            mediumBoard.O();
            stage.getScene().setRoot(mediumBoardBase);
            mediumBoard.mediumMode();
        });

        symbolMedium.randomly.setOnAction(e -> {
            mediumBoard.randomly();
            stage.getScene().setRoot(mediumBoardBase);
            mediumBoard.mediumMode();
        });

        hardnessPane.medium.setOnAction(e -> stage.getScene().setRoot(symbolMediumBase));

        hardnessPane.easy.setOnAction(e -> stage.getScene().setRoot(symbolEasyBase));

        hardnessPane.hard.setOnAction(e -> stage.getScene().setRoot(symbolHardBase));

        boardPane.back.setOnAction(e -> stage.getScene().setRoot(startPaneBase));

        boardPane.newGame.setOnAction(e -> boardPane.newGame());

        easyBoard.back.setOnAction(e -> stage.getScene().setRoot(startPaneBase));

        easyBoard.newGame.setOnAction(e -> easyBoard.newGame());

        mediumBoard.back.setOnAction(e -> stage.getScene().setRoot(startPaneBase));

        mediumBoard.newGame.setOnAction(e -> mediumBoard.newGame());

        hardBoard.back.setOnAction(e -> stage.getScene().setRoot(startPaneBase));

        hardBoard.newGame.setOnAction(e -> hardBoard.newGame());

        startPane.settingsbutton.setOnAction(e -> stage.getScene().setRoot(settingsStartBase));

        settingsStartPane.back.setOnAction(e -> stage.getScene().setRoot(startPaneBase));

    }

}
