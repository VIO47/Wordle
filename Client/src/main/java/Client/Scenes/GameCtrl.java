package Client.Scenes;


import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameCtrl {

    private final MainCtrl mainCtrl;
    private final ServerUtils utils;
    private String word;

    @FXML
    private Label box11;
    @FXML
    private Label box12;
    @FXML
    private Label box13;
    @FXML
    private Label box14;
    @FXML
    private Label box15;


    @Inject
    public GameCtrl(MainCtrl mainCtrl, ServerUtils utils) {
        this.mainCtrl = mainCtrl;
        this.utils = utils;

    }

    public void showWord(){
        word = utils.getWord();
        box11.setText(String.valueOf(word.charAt(0)));
        box12.setText(String.valueOf(word.charAt(1)));
        box13.setText(String.valueOf(word.charAt(2)));
        box14.setText(String.valueOf(word.charAt(3)));
        box15.setText(String.valueOf(word.charAt(4)));
    }


}
