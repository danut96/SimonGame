package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static java.lang.Thread.currentThread;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("simon.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Simon");
        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        System.out.print(currentThread());
    }
}
