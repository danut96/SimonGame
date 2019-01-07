package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.animation.*;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Thread implements Initializable {

    @FXML
    private Button Buton1;

    @FXML
    private Button Buton2;

    @FXML
    private Button Buton3;

    @FXML
    private Button Buton4;

    @FXML
    private Label Score;

    @FXML
    private Button Play;

    @FXML
    private Button Quit;



    public void quit(){

        System.exit(0);

    }

    //use this instance of game
    public Game game;

    static int code = 1; // code returned by game.stopGame


    public void animation(Button b, int i){

        FadeTransition f= new FadeTransition(Duration.seconds(1.2),b);
        f.setFromValue(1);
        f.setToValue(0.3);
        if(i == 0) {
            f.setDelay(Duration.seconds(2));
        }
        f.play();
        if(i<game.level+3) {
            int x = i + 1;
            f.setOnFinished(e -> animation(show(game.v[x]), x));
        }
        if( i == game.level+3) {
            f.setOnFinished(e -> {
                butonEnable();
                f.stop();
            });
        }
    }

    public Button show(int i){

            switch (i) {
                case 0:
                    return Buton1;
                case 1:
                    return Buton2;
                case 2:
                    return Buton3;
                case 3:
                    return Buton4;
            }
        return Buton1;

    }

    public void clickAnimation(Button b){

        int c = Character.getNumericValue(b.getId().charAt(5));
        code = game.stopGame(c-1);
        FadeTransition f= new FadeTransition(Duration.seconds(0.3),b);
        f.setFromValue(1);
        f.setToValue(0.3);
        f.play();
        FadeTransition fadein = new FadeTransition(Duration.seconds(0.1),b);
        fadein.setFromValue(0.3);
        fadein.setToValue(1);
        f.setOnFinished(e -> fadein.play());
        if(code != 2)fadein.setOnFinished(e -> check());
        if(code == 2){
            f.pause();
            fadein.pause();
            check();
        }
    }


    public void check(){

        if(code == 0){
            SetHighestScore.SetHighestScore(game.level);
            butonDisable();
            Play.setDisable(false);
            Score.setText("Score: 0");
            new lostWindow().display();

        }
        if(code == 2){
            Game.level++;
            Score.setText("Score:  "+ Game.level);
            butonDisable();
            game = new Game();
            animation(show(game.v[0]),0);
        }

    }

    public void butonDisable(){

        Buton1.setDisable(true);
        Buton1.setOpacity(0.3);
        Buton2.setDisable(true);
        Buton2.setOpacity(0.3);
        Buton3.setDisable(true);
        Buton3.setOpacity(0.3);
        Buton4.setDisable(true);
        Buton4.setOpacity(0.3);

    }


    public void butonEnable(){

        Buton1.setOpacity(1);
        Buton2.setOpacity(1);
        Buton3.setOpacity(1);
        Buton4.setOpacity(1);
        Buton1.setDisable(false);
        Buton2.setDisable(false);
        Buton3.setDisable(false);
        Buton4.setDisable(false);

    }


    public void play(){

        butonDisable();
        Play.setDisable(true);
        game = new Game();
        animation(show(game.v[0]),0);

    }

    @Override
    public void initialize(URL url, ResourceBundle r){

        Score.setText("Score:  "+ Game.level);
        butonDisable();
        Buton1.setOnAction(e-> clickAnimation(Buton1));
        Buton2.setOnAction(e-> clickAnimation(Buton2));
        Buton3.setOnAction(e-> clickAnimation(Buton3));
        Buton4.setOnAction(e-> clickAnimation(Buton4));

    }

}
