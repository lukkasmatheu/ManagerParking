package manager.parking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.parking.config.Conexao;
import manager.parking.controllers.SceneController;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Conexao conexao = new Conexao();
        SceneController controlerstage = new SceneController(stage);
    }

}

