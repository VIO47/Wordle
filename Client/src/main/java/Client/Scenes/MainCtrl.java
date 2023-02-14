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

    private NameCtrl nameCtrl;
    private Scene name;

    private GameCtrl gameCtrl;
    private Scene game;

    public void initialize(Stage primaryStage, Pair<EntryCtrl, Parent> entry, Pair<InstructionsCtrl, Parent> instructions, Pair<NameCtrl, Parent> name,
                           Pair<GameCtrl, Parent> game){
        this.primaryStage = primaryStage;

        this.entryCtrl = entry.getKey();
        this.entry = new Scene(entry.getValue());

        this.instructionsCtrl = instructions.getKey();
        this.instructions = new Scene(instructions.getValue());

        this.nameCtrl = name.getKey();
        this.name = new Scene(name.getValue());

        this.gameCtrl = game.getKey();
        this.game = new Scene(game.getValue());

        showName();
        primaryStage.show();
    }

    public void showEntry(){
        primaryStage.setScene(entry);
    }

    public void showGame(){
        primaryStage.setScene(game);
        gameCtrl.createGame(game);
    }

    public void showInstructions(){
        primaryStage.setScene(instructions);
    }

    public void showName(){
        primaryStage.setScene(name);
    }
}
