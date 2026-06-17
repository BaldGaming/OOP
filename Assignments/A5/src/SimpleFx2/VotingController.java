package SimpleFx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VotingController {

    // The score
    private int score = 0;

    // The result label
    @FXML
    private Label countLabel;

    // Define click behavior
    @FXML
    void ofraVote(ActionEvent event) {
        score++; // Ofra Haza increases the counter
        countLabel.setText(String.valueOf(score));
    }

    @FXML
    void yardenaVote(ActionEvent event) {
        score--; // Yardena Arazi decreases the counter
        countLabel.setText(String.valueOf(score));
    }
}