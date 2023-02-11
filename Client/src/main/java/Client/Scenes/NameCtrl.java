package Client.Scenes;

import Client.Utils.ServerUtils;
import Commons.Player;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NameCtrl {

    private final ServerUtils utils;
    private final MainCtrl mainCtrl;

    @FXML
    private TextField field;

    @FXML
    private Label labelConfirm;

    @Inject
    public NameCtrl(ServerUtils utils, MainCtrl mainCtrl) {
        this.utils = utils;
        this.mainCtrl = mainCtrl;
    }

    public void confirm(){
        utils.setDummy(new Player(field.getText()));
        mainCtrl.showEntry();
    }
}
