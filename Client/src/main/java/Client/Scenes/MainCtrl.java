package Client.Scenes;

import Client.Utils.ServerUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MainCtrl {

    private Stage primaryStage;
    private ServerUtils utils;

    private EntryCtrl entryCtrl;
    private Scene entry;

    private InstructionsCtrl instructionsCtrl;
    private Scene instructions;

    public void initialize(Stage primaryStage, Pair<EntryCtrl, Parent> entry, Pair<InstructionsCtrl, Parent> instructions){
        this.primaryStage = primaryStage;

        this.entryCtrl = entry.getKey();
        this.entry = new Scene(entry.getValue());

        this.instructionsCtrl = instructions.getKey();
        this.instructions = new Scene(instructions.getValue());

        showEntry();
        primaryStage.show();
    }

    public void showEntry(){
        primaryStage.setScene(entry);
    }

    public void showGame(){
        utils.createGame();
    }

    public void showInstructions(){
        primaryStage.setScene(instructions);

    }
}
