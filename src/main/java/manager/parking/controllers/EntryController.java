package manager.parking.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import manager.parking.models.enumerations.TelasEnum;

import java.io.IOException;

import static manager.parking.controllers.SceneController.alterarTela;
import static manager.parking.controllers.SceneController.clienteSistema;

public class EntryController {
    @FXML
    private Label lbData;
    @FXML
    private Label lbVaga;
    @FXML
    private Label lbCliente;
    @FXML
    private Label lbTime;
    @FXML
    private Label lbTimeTotal;

    @FXML
    protected void voltarMenu() throws IOException {
        alterarTela(TelasEnum.MENU_USER);
    }
}

