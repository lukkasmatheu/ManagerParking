package manager.parking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.parking.models.Estacionamento;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static manager.parking.config.Conexao.findClient;
import static manager.parking.config.Conexao.findClients;
import static manager.parking.controllers.SceneController.clienteSistema;

public class HistoricoController implements Initializable {
    @FXML
    private TableView tableViewer;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button button;
    @FXML
    private TableColumn<Estacionamento, String> clData;
    @FXML
    private TableColumn<Estacionamento, String> clVaga;
    @FXML
    private TableColumn<Estacionamento, String> clTimeEntry;
    @FXML
    private TableColumn<Estacionamento, String> clTimeOut;
    @FXML
    private TableColumn<Estacionamento, Float> clValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(clienteSistema.getHistoricoEstacionamento());
        tableViewer.getItems().setAll(findClient(clienteSistema.getLogin()).getHistoricoEstacionamento());
    }

    @FXML
    protected void filterListHistory(){
        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
        if(date == null || date.equals("") || date.isEmpty()){
            tableViewer.getItems().setAll(findClient(clienteSistema.getLogin()).getHistoricoEstacionamento());
        }else{
            List<Estacionamento> estacionamentos = clienteSistema.getHistoricoEstacionamento().stream().filter(v -> v.getData().equals(date)).collect(Collectors.toList());
            if(!estacionamentos.isEmpty()){
                observableList(estacionamentos);
            }
        }
    }

    private void observableList(List<Estacionamento> historicoEstacionamentos) {
        ObservableList<Estacionamento> parking = FXCollections.observableList(historicoEstacionamentos);

        clData.setCellValueFactory(new PropertyValueFactory<>("data"));
        clVaga.setCellValueFactory(new PropertyValueFactory<>("vaga"));
        clTimeEntry.setCellValueFactory(new PropertyValueFactory<>("horarioEntrada"));
        clTimeOut.setCellValueFactory(new PropertyValueFactory<>("horarioSaida"));
        clValue.setCellValueFactory(new PropertyValueFactory<>("valor"));

        tableViewer.setItems(parking);
    }
}
