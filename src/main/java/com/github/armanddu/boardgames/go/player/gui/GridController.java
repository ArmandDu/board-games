package com.github.armanddu.boardgames.go.player.gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Created by armanddu on 07/04/16 for board-games.
 */
public class GridController {

    @FXML
    public TextField loginField;
    @FXML
    public Text titleField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text actionTarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actionTarget.setText("Sign in button pressed");
    }

    public void updateTitle(Event event) {
        titleField.setText("Welcome " + loginField.getText());
    }
}
