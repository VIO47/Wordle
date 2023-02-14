package Client.Scenes;

import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class EntryCtrl {

    private final MainCtrl mainCtrl;
    private final ServerUtils utils;

    @FXML
    private Label x1;

    @Inject
    public EntryCtrl(MainCtrl mainCtrl, ServerUtils utils) {
        this.mainCtrl = mainCtrl;
        this.utils = utils;
    }

    public void showInstructions(){
        mainCtrl.showInstructions();
    }

    public void play(){
        utils.read();
        mainCtrl.showGame();
    }
}
