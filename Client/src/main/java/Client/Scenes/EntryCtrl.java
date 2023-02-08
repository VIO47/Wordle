package Client.Scenes;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class EntryCtrl {

    private final MainCtrl mainCtrl;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonInstruct;

    @Inject
    public EntryCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void showInstructions(){
        mainCtrl.showInstructions();
    }

    public void play(){
        mainCtrl.showGame();
    }
}
