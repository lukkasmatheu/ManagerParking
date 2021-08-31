package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manager.parking.models.Clients;
import manager.parking.models.enumerations.TelasEnum;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static manager.parking.config.Conexao.findClient;
import static manager.parking.controllers.SceneController.alterarTela;
import static manager.parking.controllers.SceneController.setUsuarioSessao;
import static manager.parking.utils.utils.criptografaSenha;

public class LoginController {

    @FXML
    private Button btLogin;
    @FXML
    private Button btCadastro;
    @FXML
    private TextField txLogin;
    @FXML
    private PasswordField txSenha;

    public void handleButtonClick() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (txLogin.getText().equals("")) {
            if (!txLogin.getStyle().contains("-fx-border-color: #ff0000"))
                txLogin.setStyle(txLogin.getStyle() + "-fx-border-color: #ff0000 ");
        }
        if (validaLogin()) {
            try {
                System.out.print(txLogin.getText());
                alterarTela(TelasEnum.MENU_USER);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        try {
            System.out.print(txLogin.getText());
            alterarTela(TelasEnum.CADASTRO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validaLogin() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Clients cliente = findClient(txLogin.getText());
        String senha = criptografaSenha(txSenha.getText());
        if (cliente != null && cliente.getLogin().equals(txLogin.getText()) && cliente.getSenha().equals(senha)) {
            setUsuarioSessao(cliente);
            return true;
        }
        return false;
    }

}

