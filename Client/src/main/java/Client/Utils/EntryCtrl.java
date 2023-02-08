package Client.Utils;

import com.google.inject.Inject;
import javafx.fxml.FXML;

import java.awt.*;

public class EntryCtrl {

    private final MainCtrl mainCtrl;

    @FXML
    public Button playButton;

    @FXML
    public Button instructionsButton;

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
