package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import manager.parking.models.enumerations.TelasEnum;

import java.io.IOException;

import static manager.parking.controllers.SceneController.alterarTela;

public class MenuController {
    @FXML
    protected void openViewBuscarUsuarios(ActionEvent event) {
        try {
            alterarTela(TelasEnum.BUSCA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openViewHistorico(ActionEvent event) {
        try {
            alterarTela(TelasEnum.REGISTRO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openViewTicketEntrada(ActionEvent event) {
        try {
            alterarTela(TelasEnum.TICKET_ENTRADA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openViewTicketSaida(ActionEvent event) {
        try {
            alterarTela(TelasEnum.TICKET_SAIDA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
