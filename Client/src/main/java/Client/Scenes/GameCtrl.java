package Client.Scenes;

import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameCtrl {

    private final MainCtrl mainCtrl;
    private final ServerUtils utils;
    private String word;

    @FXML
    private Label fill1;
    @FXML
    private Label fill2;
    @FXML
    private Label fill3;
    @FXML
    private Label fill4;
    @FXML
    private Label fill5;

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

    @FXML
    private AnchorPane writeLine;

    @Inject
    public GameCtrl(MainCtrl mainCtrl, ServerUtils utils) {
        this.mainCtrl = mainCtrl;
        this.utils = utils;

    }

    public void createGame(){
        utils.createGame();
        word = utils.getWord();
    }

    public void showWord(){
        box11.setText(String.valueOf(word.charAt(0)));
        box12.setText(String.valueOf(word.charAt(1)));
        box13.setText(String.valueOf(word.charAt(2)));
        box14.setText(String.valueOf(word.charAt(3)));
        box15.setText(String.valueOf(word.charAt(4)));
    }

    public void fillBoxes(){
        EventHandler<KeyEvent> eventHandler = event -> {
            if(!fill1.getText().equals("")){
                fill2.setText(event.getText());
            }
            else if(!fill2.getText().equals("")){
                fill3.setText(event.getText());
            }
            else if(!fill3.getText().equals("")){
                fill4.setText(event.getText());
            }
            else if(!fill4.getText().equals("")){
                fill5.setText(event.getText());
            }
        };
        fill1.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
        fill1.addEventHandler(KeyEvent.KEY_TYPED, eventHandler);
    }

    public void resetAnswer(){
        fill1.setText("");
        fill2.setText("");
        fill3.setText("");
        fill4.setText("");
        fill5.setText("");
    }
}
