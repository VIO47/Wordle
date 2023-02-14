package Client.Scenes;

import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class GameCtrl {

    private final MainCtrl mainCtrl;
    private final ServerUtils utils;
    private String word;
    public int tries = 4;

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
    private Label box21;
    @FXML
    private Label box22;
    @FXML
    private Label box23;
    @FXML
    private Label box24;
    @FXML
    private Label box25;

    @FXML
    private Label box31;
    @FXML
    private Label box32;
    @FXML
    private Label box33;
    @FXML
    private Label box34;
    @FXML
    private Label box35;

    @FXML
    private Label box41;
    @FXML
    private Label box42;
    @FXML
    private Label box43;
    @FXML
    private Label box44;
    @FXML
    private Label box45;

    @FXML
    private Label warning;
    @FXML
    private FlowPane write;
    @FXML
    private AnchorPane scenePane;

    @Inject
    public GameCtrl(MainCtrl mainCtrl, ServerUtils utils) {
        this.mainCtrl = mainCtrl;
        this.utils = utils;

    }

    public void createGame(Scene scene) {
        tries = 4;
        utils.createGame();
        word = utils.getWord();
        scene.setOnKeyTyped(this::directAction);
    }

    public void directAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            submitAnswer();
        } else if (event.getEventType() == KeyEvent.KEY_TYPED) {
            fillBoxes(event.getCharacter());
        }
    }

    public void fillBoxes(String s) {
        if (fill1.getText().equals("")) {
            fill1.setText(s);
        } else if (fill2.getText().equals("")) {
            fill2.setText(s);
        } else if (fill3.getText().equals("")) {
            fill3.setText(s);
        } else if (fill4.getText().equals("")) {
            fill4.setText(s);
        } else if (fill5.getText().equals("")) {
            fill5.setText(s);
        }
    }

    public void resetAnswer() {
        fill1.setText("");
        fill2.setText("");
        fill3.setText("");
        fill4.setText("");
        fill5.setText("");
    }

    public void submitAnswer() {
        String answer = fill1.getText();
        answer += fill2.getText();
        answer += fill3.getText();
        answer += fill4.getText();
        answer += fill5.getText();
        if (utils.isWord(answer)) calculateAnswer();
        else {
            warning.setVisible(true);
        }

    }

    public void calculateAnswer() {
        tries--;
        String color;
        switch (tries) {
            case 3 -> {
                color = utils.setColor(box11.getText().charAt(0), 0);
                box11.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box12.getText().charAt(0), 1);
                box12.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box13.getText().charAt(0), 2);
                box13.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box14.getText().charAt(0), 3);
                box14.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box15.getText().charAt(0), 4);
                box15.setStyle("-fx-background-color:" + color);
            }
            case 2 -> {
                color = utils.setColor(box21.getText().charAt(0), 0);
                box21.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box22.getText().charAt(0), 1);
                box22.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box23.getText().charAt(0), 2);
                box23.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box24.getText().charAt(0), 3);
                box24.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box25.getText().charAt(0), 4);
                box25.setStyle("-fx-background-color:" + color);
            }
            case 1 -> {
                color = utils.setColor(box31.getText().charAt(0), 0);
                box31.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box32.getText().charAt(0), 1);
                box32.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box33.getText().charAt(0), 2);
                box33.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box34.getText().charAt(0), 3);
                box34.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box35.getText().charAt(0), 4);
                box35.setStyle("-fx-background-color:" + color);
            }
            case 0 -> {
                color = utils.setColor(box41.getText().charAt(0), 0);
                box41.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box42.getText().charAt(0), 1);
                box42.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box43.getText().charAt(0), 2);
                box43.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box44.getText().charAt(0), 3);
                box44.setStyle("-fx-background-color:" + color);
                color = utils.setColor(box45.getText().charAt(0), 4);
                box45.setStyle("-fx-background-color:" + color);
            }
            default -> resetAnswer();
        }
    }

}
