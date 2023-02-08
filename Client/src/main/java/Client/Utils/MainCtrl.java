package Client.Utils;

import Client.Utils.EntryCtrl;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MainCtrl {

    private Stage primaryStage;

    private EntryCtrl entryCtrl;
    private Scene entry;

    public void initialize(Stage primaryStage, Pair<EntryCtrl, Parent> entry){
        this.primaryStage = primaryStage;

        this.entryCtrl = entry.getKey();
        this.entry = new Scene(entry.getValue());
    }

    public void showEntry(){
        primaryStage.setScene(entry);
    }

    public void showGame(){

    }

    public void showInstructions(){

    }
}
