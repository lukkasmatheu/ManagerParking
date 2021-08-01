package manager.parking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage alternateStage) {
        stage = alternateStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var loadPrimaryView = getClass().getResource("telaLogin.fxml");
        Parent root = FXMLLoader.load(loadPrimaryView);

        stage.setTitle("LOGIN");

        stage.setScene(new Scene(root));
        stage.show();
        this.stage = stage;

        stage.setResizable(false);
    }

    public static void close() {
        stage.close();
    }
}

