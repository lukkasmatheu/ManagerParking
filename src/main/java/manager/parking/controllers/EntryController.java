package manager.parking.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import manager.parking.models.Estacionamento;
import manager.parking.models.enumerations.TelasEnum;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import static manager.parking.config.Conexao.updateClient;
import static manager.parking.controllers.SceneController.alterarTela;
import static manager.parking.controllers.SceneController.clienteSistema;
import static manager.parking.controllers.SceneController.controllVagas;

public class EntryController implements Initializable {
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

    private static Random rand = new Random();

    @FXML
    protected void voltarMenu() throws IOException {
        alterarTela(TelasEnum.MENU_USER);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int ch = rand.nextInt (3);

        List<Estacionamento> estacionamentos = clienteSistema.getHistoricoEstacionamento();

        if(estacionamentos.size()>= 1 && estacionamentos.get(estacionamentos.size() - 1).isOpen()){
            estacionamentos.get(estacionamentos.size() - 1).setOpen(false);
            estacionamentos.get(estacionamentos.size() - 1).setHorarioSaida(LocalDateTime.now().toString().replace("\\w{10}",""));
            lbTimeTotal.setText("" + (Integer.parseInt(estacionamentos.get(estacionamentos.size() - 1).getHorarioSaida()) - Integer.parseInt(estacionamentos.get(estacionamentos.size() -1).getHorarioEntrada())));
        }else{
            int vaga = Integer.parseInt(controllVagas.get(ch).getVaga()) - 1;
            Estacionamento estacionamento = new Estacionamento();
            estacionamento.setData(LocalDateTime.now().toString());
            estacionamento.setHorarioEntrada(LocalDateTime.now().toString().replace("\\w{10}",""));
            estacionamento.setAndar(controllVagas.get(ch).getAndar());
            estacionamento.setVaga(controllVagas.get(ch).getAndar() + vaga);
            estacionamento.setOpen(true);
            estacionamentos.add(estacionamento);
        }
        lbData.setText(LocalDateTime.now().toString());
        lbTime.setText(estacionamentos.get(estacionamentos.size() - 1).getHorarioEntrada());
        lbCliente.setText(clienteSistema.getName());
        lbVaga.setText(estacionamentos.get(estacionamentos.size() - 1).getVaga());
        clienteSistema.setHistoricoEstacionamento(estacionamentos);
        updateClient(clienteSistema);
    }
}

