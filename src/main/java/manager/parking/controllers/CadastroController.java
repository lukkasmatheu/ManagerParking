package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manager.parking.models.Clients;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;

import static manager.parking.utils.utils.criptografaSenha;

public class CadastroController {
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
    private Button btCadastro;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Clients usuario = new Clients();
        usuario.setName(txNome.getText());
        String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        if (verificaSenha()) {
            usuario.setSenha(criptografaSenha(txSenha.getText()));
        }
        usuario.setEmail(txEmail.getText());
        usuario.setBirthdate(date);
        usuario.setLogin(txLogin.getText());

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

}
