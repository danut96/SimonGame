package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LostController implements Initializable {

    @FXML
    private Label highestScore;

    @FXML
    private Button reset;

    @FXML
    private Label Score;

    @FXML
    private Button newGame;

    @FXML
    private Button quit;

    public void quit(){

        System.exit(0);

    }

    public void newGame(){

        Game.level = 0;
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();

    }

    public void resetHighestScore(){

        SetHighestScore.resetHighestScore();

    }

    @Override
    public void initialize (URL u, ResourceBundle r){

        Score.setText("You scored "+ Game.level+" points");
        highestScore.setText("Your highest score: "+SetHighestScore.highestScore);

    }

}
