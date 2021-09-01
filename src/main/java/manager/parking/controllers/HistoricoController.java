package manager.parking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.parking.models.Estacionamento;

import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static manager.parking.controllers.SceneController.clienteSistema;

public class HistoricoController {
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

    @FXML
    protected void filterListHistory(ActionEvent e){
        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        if(date.equals("") || date.isEmpty()){
            observableList(clienteSistema.getHistoricoEstacionamento());
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
