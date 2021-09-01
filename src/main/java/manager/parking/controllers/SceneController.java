package manager.parking.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.parking.models.Clients;
import manager.parking.models.Estacionamento;
import manager.parking.models.enumerations.TelasEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneController {
    public static Stage stage;
    public static List<Estacionamento> controllVagas = new ArrayList<>();
    public static Clients clienteSistema;

    public SceneController(Stage stage) throws IOException {
        controllVagas.add(Estacionamento.builder().andar("L").vaga("250").build());
        controllVagas.add(Estacionamento.builder().andar("M").vaga("250").build());
        controllVagas.add(Estacionamento.builder().andar("N").vaga("250").build());
        var loadPrimaryView = getClass().getResource(TelasEnum.LOGIN.getPathname());
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

    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage alternateStage) {
        stage = alternateStage;
    }

    public static void alterarTela(TelasEnum view) throws IOException {
        close();
        var loader = SceneController.class.getResource(view.getPathname());
        Parent root = FXMLLoader.load(loader);
        Stage stage = new Stage();
        setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void setUsuarioSessao(Clients client){
        clienteSistema = client;
    }
}
