package mines;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class MinesController {

    @FXML
    private StackPane gridContainer;
    @FXML
    private TextField widthInput;
    @FXML
    private TextField heightInput;
    @FXML
    private TextField minesInput;

    private Mines game;
    private MineButton[][] buttonGrid;
    private int currentHeight;
    private int currentWidth;
    private boolean isGameOver;

    @FXML
    public void initialize() {
        resetGame(null);
    }

    @FXML
    void resetGame(ActionEvent event) {
        try {
            currentWidth = Integer.parseInt(widthInput.getText().trim());
            currentHeight = Integer.parseInt(heightInput.getText().trim());
            int numMines = Integer.parseInt(minesInput.getText().trim());

            if (currentWidth <= 0 || currentHeight <= 0 || numMines <= 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Width, height, and mines must be greater than 0!");
                alert.show();
                return;
            }

            if (numMines > currentWidth * currentHeight) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You cannot have more mines than total tiles!");
                alert.show();
                return;
            }

            game = new Mines(currentHeight, currentWidth, numMines);
            buttonGrid = new MineButton[currentHeight][currentWidth];
            isGameOver = false;

            GridPane gridPane = new GridPane();

            for (int i = 0; i < currentHeight; i++) {
                for (int j = 0; j < currentWidth; j++) {

                    MineButton btn = new MineButton(i, j);

                    btn.setPrefSize(35, 35);
                    btn.setFont(Font.font("System", FontWeight.BOLD, 14));
                    btn.setText(".");
                    btn.setStyle("-fx-base: #e0e0e0;");

                    btn.setOnMouseClicked(this::handleTileClick);

                    ScaleTransition st = new ScaleTransition(Duration.millis(300), btn);
                    st.setFromX(0);
                    st.setFromY(0);
                    st.setToX(1);
                    st.setToY(1);
                    st.play();

                    buttonGrid[i][j] = btn;
                    gridPane.add(btn, j, i);
                }
            }

            gridContainer.getChildren().clear();
            gridContainer.getChildren().add(gridPane);

            if (gridContainer.getScene() != null && gridContainer.getScene().getWindow() != null) {
                gridContainer.getScene().getWindow().sizeToScene();
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid integers!");
            alert.show();
        }
    }

    private void handleTileClick(MouseEvent event) {
        if (isGameOver) {
            return;
        }

        MineButton clickedBtn = (MineButton) event.getSource();
        int i = clickedBtn.row;
        int j = clickedBtn.col;

        if (event.getButton() == MouseButton.SECONDARY) {
            game.toggleFlag(i, j);
        } else if (event.getButton() == MouseButton.PRIMARY) {
            
            if (clickedBtn.getText().equals("F")) {
                return;
            }

            boolean safe = game.open(i, j);

            if (!safe) {
                game.setShowAll(true);
                isGameOver = true;
            }
        }

        updateBoardDisplay();

        if (!isGameOver && game.isDone()) {
            isGameOver = true;
            Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
            winAlert.setHeaderText(null);
            winAlert.setContentText("OMG, you just won!!!");
            winAlert.showAndWait();
        }
    }

    private void updateBoardDisplay() {
        for (int i = 0; i < currentHeight; i++) {
            for (int j = 0; j < currentWidth; j++) {
                String val = game.get(i, j);
                MineButton btn = buttonGrid[i][j];

                if (!btn.getText().equals(val) && !val.equals("F") && !val.equals(".")) {
                    ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
                    st.setFromX(0.8);
                    st.setFromY(0.8);
                    st.setToX(1);
                    st.setToY(1);
                    st.play();
                }

                btn.setText(val);

                if (!val.equals(".") && !val.equals("F")) {
                    btn.setDisable(true);
                    String textColor = "black";
                    String bgColor = "#ddd";

                    switch (val) {
                        case "1": textColor = "#0000FF"; break;
                        case "2": textColor = "#008000"; break;
                        case "3": textColor = "#FF0000"; break;
                        case "4": textColor = "#00008B"; break;
                        case "5": textColor = "#8B0000"; break;
                        case "6": textColor = "#008080"; break;
                        case "7": textColor = "#000000"; break;
                        case "8": textColor = "#808080"; break;
                        case "X":
                            textColor = "white";
                            bgColor = "#cc0000";
                            if (isGameOver) {
                                FadeTransition ft = new FadeTransition(Duration.millis(500), btn);
                                ft.setFromValue(0.4);
                                ft.setToValue(1.0);
                                ft.setCycleCount(FadeTransition.INDEFINITE);
                                ft.setAutoReverse(true);
                                ft.play();
                            }
                            break;
                    }
                    
                    btn.setStyle("-fx-opacity: 1; -fx-text-fill: " + textColor + "; -fx-background-color: " + bgColor + ";");
                } else if (val.equals("F")) {
                    btn.setStyle("-fx-text-fill: red; -fx-base: #e0e0e0;");
                } else {
                    btn.setStyle("-fx-text-fill: black; -fx-base: #e0e0e0;");
                }
            }
        }
    }

    private class MineButton extends Button {
        int row;
        int col;

        public MineButton(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}