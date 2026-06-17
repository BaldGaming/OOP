package simpleFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Voting extends Application {

    // The score
    private int score = 0;

    @Override
    public void start(Stage primaryStage) {

        // Create the buttons
        Button ofraBtn = new Button("Ofra Haza");
        Button yardenaBtn = new Button("Yardena Arazi");

        // Create the result label with the starting value "0"
        Label countLabel = new Label("0");
        
        // Styling the label: red background, bold and centered text
        countLabel.setStyle("-fx-background-color: red; " +
                            "-fx-text-fill: black; " +
                            "-fx-alignment: center; " +
                            "-fx-font-weight: bold; " +
                            "-fx-padding: 15px;");

        // Stretching the label across the entire bottom row
        countLabel.setMaxWidth(Double.MAX_VALUE); 

        // Define click behavior
        ofraBtn.setOnAction(e -> {
            score++; // Ofra Haza increases the counter
            countLabel.setText(String.valueOf(score));
        });

        yardenaBtn.setOnAction(e -> {
            score--; // Yardena Arazi decreases the counter
            countLabel.setText(String.valueOf(score));
        });

        // Layout Setup
        
        // HBox: Top row for the buttons with 15px spacing between them
        HBox topRow = new HBox(15); 
        topRow.setAlignment(Pos.CENTER);
        topRow.getChildren().addAll(ofraBtn, yardenaBtn);

        // VBox: The main container holding the top row and the label with 20px spacing
        VBox root = new VBox(20);
        root.setPadding(new Insets(20)); // Margin around all elements in the window
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(topRow, countLabel);

        // Scene setup and displaying the window
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setTitle("Voting Machine"); // Updated window title
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}