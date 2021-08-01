package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manager.parking.models.Users;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsersController {
    @FXML
    private TextField txName;
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

    List<Users> usuarios = new ArrayList();


    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Users usuario = new Users();
        usuario.setName(txName.getText());
        String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        if (verificaSenha()) {
            usuario.setSenha(txSenha.getText());
        }
        usuario.setEmail(txEmail.getText());
        System.out.print("nome de usuario: " + usuario.getName() + " \n" +
                " Email de usuario " + usuario.getEmail() + " Id de usuario: " + Users.getId() + " Data de nascimento:  " + date);
        usuarios.add(usuario);
        manager.parking.Main.close();
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
