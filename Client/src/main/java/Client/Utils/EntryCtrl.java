package Client.Utils;

import com.google.inject.Inject;
import javafx.fxml.FXML;

import java.awt.*;

public class EntryCtrl {

    private final MainCtrl mainCtrl;

    @FXML
    public Button playButton;
    public Button instructionsButton;

    @Inject
    public EntryCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void showInstruction(){
        mainCtrl.showInstructions();
    }

    public void play(){
        mainCtrl.showGame();
    }
}
