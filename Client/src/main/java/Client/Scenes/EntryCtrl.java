package Client.Scenes;

import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class EntryCtrl {

    private final MainCtrl mainCtrl;
    private final ServerUtils utils;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonInstruct;

    @FXML
    private Label test;

    @Inject
    public EntryCtrl(MainCtrl mainCtrl, ServerUtils utils) {
        this.mainCtrl = mainCtrl;
        this.utils = utils;
    }

    public void showInstructions(){
        mainCtrl.showInstructions();
    }

    public void play(){
        mainCtrl.showGame();
    }

    public void test(){
        test.setText(utils.getDummyPlayer().getName());
    }
}
