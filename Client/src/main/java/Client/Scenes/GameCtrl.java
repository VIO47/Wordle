package Client.Scenes;

import Client.Utils.ServerUtils;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    private AnchorPane fadeScene;
    @FXML
    private Pane winnerPane;

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
        scene.setOnKeyPressed(this::directAction);
    }

    public void directAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !fill5.getText().equals("")) {
            submitAnswer();
        } else if (event.getCode() == KeyCode.BACK_SPACE) {
            deleteBox();
        } else if (event.getEventType() == KeyEvent.KEY_TYPED) {
            fillBoxes(event.getCharacter());
        }
    }

    public void deleteBox() {
        if (!fill5.getText().equals("")) {
            fill5.setText("");
        } else if (!fill4.getText().equals("")) {
            fill4.setText("");
        } else if (!fill3.getText().equals("")) {
            fill3.setText("");
        } else if (!fill2.getText().equals("")) {
            fill2.setText("");
        } else if (!fill1.getText().equals("")) {
            fill1.setText("");
        }
        warning.setVisible(false);
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
        if(answer.equals(word)){
            fadeScene.setVisible(true);
            winnerPane.setVisible(true);
        }
        //calculateAnswer();

    }

    public void calculateAnswer() {
        tries--;
        String color1 = utils.setColor(fill1.getText().charAt(0), 0);
        String color2 = utils.setColor(fill2.getText().charAt(0), 1);
        String color3 = utils.setColor(fill3.getText().charAt(0), 2);
        String color4 = utils.setColor(fill4.getText().charAt(0), 3);
        String color5 = utils.setColor(fill5.getText().charAt(0), 4);
        switch (tries) {
            case 3 -> {
                box11.setStyle(color1);
                box11.setText(fill1.getText());
                box12.setStyle(color2);
                box12.setText(fill2.getText());
                box13.setStyle(color3);
                box13.setText(fill3.getText());
                box14.setStyle(color4);
                box14.setText(fill4.getText());
                box15.setStyle(color5);
                box15.setText(fill5.getText());
            }
            case 2 -> {
                box21.setStyle(color1);
                box21.setText(fill1.getText());
                box22.setStyle(color2);
                box22.setText(fill2.getText());
                box23.setStyle(color3);
                box23.setText(fill3.getText());
                box24.setStyle(color4);
                box24.setText(fill4.getText());
                box25.setStyle(color5);
                box25.setText(fill5.getText());
            }
            case 1 -> {
                box31.setStyle(color1);
                box31.setText(fill1.getText());
                box32.setStyle(color2);
                box32.setText(fill2.getText());
                box33.setStyle(color3);
                box33.setText(fill3.getText());
                box34.setStyle(color4);
                box34.setText(fill4.getText());
                box35.setStyle(color5);
                box35.setText(fill5.getText());
            }
            case 0 -> {
                box41.setStyle(color1);
                box41.setText(fill1.getText());
                box42.setStyle(color2);
                box42.setText(fill2.getText());
                box43.setStyle(color3);
                box43.setText(fill3.getText());
                box44.setStyle(color4);
                box44.setText(fill4.getText());
                box45.setStyle(color5);
                box45.setText(fill5.getText());
            }
        }
        resetAnswer();
    }

}
