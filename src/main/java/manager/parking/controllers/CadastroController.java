package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manager.parking.models.Clients;
import manager.parking.models.Veiculos;
import manager.parking.models.enumerations.TelasEnum;
import manager.parking.models.enumerations.TypesVeiculosEnum;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static manager.parking.controllers.SceneController.alterarTela;
import static manager.parking.utils.utils.criptografaSenha;

public class CadastroController implements Initializable {
    Clients usuario = new Clients();
    @FXML
    private TextField txLogin;
    @FXML
    private TextField txNome;
    @FXML
    private PasswordField txSenha;
    @FXML
    private DatePicker datepicker;
    @FXML
    private PasswordField txContraSenha;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txModelo;
    @FXML
    private TextField txPlaca;
    @FXML
    private ChoiceBox<TypesVeiculosEnum> fxTipo = new ChoiceBox<>();
    @FXML
    private TextField txMarca;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException, NoSuchAlgorithmException {

        usuario.setName(txNome.getText());
        String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        if (verificaSenha()) {
            usuario.setSenha(criptografaSenha(txSenha.getText()));
            usuario.setEmail(txEmail.getText());
            usuario.setBirthdate(date);
            usuario.setLogin(txLogin.getText());
            try {
                alterarTela(TelasEnum.CADASTRO_VEICULO);

            } catch (Exception e) {
                System.out.println("[CONTROLLER]- ERRO AO ALTERAR PARA TELA DE CADASTRO DO VEICULO" + e.getMessage());
            }
        } else {
            txContraSenha.setStyle(txContraSenha.getStyle() + "-fx-border-color: #ff0000 ");
        }
    }

    @FXML
    protected void cadastraVeiculo(ActionEvent event) {
        Veiculos veic = new Veiculos();
        if (!txPlaca.getText().isEmpty() && !txMarca.getText().isEmpty() && !txModelo.getText().isEmpty()) {
            veic.builder()
                    .marca(txMarca.getText())
                    .modelo(txModelo.getText())
                    .placa(txPlaca.getText())
                    .tipoVeiculo(fxTipo.getValue())
                    .build();
            usuario.setVeiculo(veic);
            try {
                alterarTela(TelasEnum.LOGIN);
            } catch (Exception e) {
                System.out.println("[CONTROLLER]- ERRO AO ALTERAR PARA TELA DE MENU");
            }
        } else {
            System.out.println("[CONTROLLER] - ERROR AO TENTAR CADASTRAR VEICULO");
        }
    }

    private boolean verificaSenha() {
        boolean validation;

        if ((txSenha.getText()).equals(txContraSenha.getText()) && txSenha.getLength() >= 5) {
            validation = true;
        } else {
            validation = false;
        }
        return validation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxTipo.getItems().setAll(TypesVeiculosEnum.values());
    }
}
