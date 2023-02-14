package Client.Scenes;

import Client.Utils.ServerUtils;
import Commons.Player;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class NameCtrl {

    private final ServerUtils utils;
    private final MainCtrl mainCtrl;

    @FXML
    private TextField nameField;

    @Inject
    public NameCtrl(ServerUtils utils, MainCtrl mainCtrl) {
        this.utils = utils;
        this.mainCtrl = mainCtrl;
    }

    public void confirm(){
        utils.dummyPlayer = new Player(nameField.getText());
        mainCtrl.showEntry();
    }

    public void keyPressed(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            confirm();
        }
    }
}
