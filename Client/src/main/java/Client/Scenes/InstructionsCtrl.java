package Client.Scenes;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InstructionsCtrl {

    private final MainCtrl mainCtrl;

    @FXML
    private Label labelBack;

    @Inject
    public InstructionsCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void goBack(){
        mainCtrl.showEntry();
    }
}
