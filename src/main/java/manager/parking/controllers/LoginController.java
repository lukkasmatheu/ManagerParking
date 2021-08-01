package manager.parking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manager.parking.Main;

import java.io.IOException;

public class LoginController {

    @FXML private Button btLogin;
    @FXML private Button btCadastro;
    @FXML private TextField txLogin;
    @FXML private PasswordField txSenha;

    public void handleButtonClick() {
        String texto = txLogin.getText();
        System.out.println("CLASE AINDA NAO CRIADA" + txLogin.getText() + txSenha.getText());
        if (texto.equals("")) {
            System.out.println(texto);
            if(! txLogin.getStyle().contains("-fx-border-color: #ff0000"))
                txLogin.setStyle(txLogin.getStyle()+ "-fx-border-color: #ff0000 " );
        }
    }
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
        try {
            System.out.print(txLogin.getText());
            Main.close();
            Parent root = FXMLLoader.load(getClass().getResource("telaCadastro.fxml"));
            Stage stage = new Stage();
            Main.stage= stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

