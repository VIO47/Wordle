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
    private Label labelConfirm;

    @FXML
    private TextField field;

    @Inject
    public NameCtrl(ServerUtils utils, MainCtrl mainCtrl) {
        this.utils = utils;
        this.mainCtrl = mainCtrl;
    }

    public void confirm(){
        Player p = new Player();
        p.setName(field.getText());
        utils.setPlayer(p);

        mainCtrl.showEntry();
    }
}
