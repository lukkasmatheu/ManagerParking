package manager.parking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.parking.models.Clients;
import manager.parking.models.Estacionamento;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

import static manager.parking.config.Conexao.findClients;

public class BuscarClientesController {
    @FXML
    private TableView tbView;
    @FXML
    private TextField inputText;
    @FXML
    private Button button;
    @FXML
    private TableColumn<Estacionamento, String> clNome;
    @FXML
    private TableColumn<Estacionamento, String> clPhone;
    @FXML
    private TableColumn<Estacionamento, String> clMail;

    @FXML
    protected void filterListHistory(ActionEvent e) {
        List<Clients> clientes = findClients();
        if (inputText.getText().equals("") || inputText.getText().isEmpty()) {
            observableList(clientes);
        } else {
            List<Clients> clients = clientes.stream().filter(v -> v.getName().equals(inputText)).collect(Collectors.toList());
            if (!clients.isEmpty()) {
                observableList(clients);
            }
        }
    }

    private void observableList(List<Clients> clientes) {
        ObservableList<Clients> parking = FXCollections.observableList(clientes);

        clNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clPhone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        clMail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tbView.setItems(parking);
    }
}
