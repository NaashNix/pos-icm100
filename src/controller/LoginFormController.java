package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {

    public TextField txtUsername;
    public PasswordField txtPassword;

    public void btnLoginOnClick(ActionEvent actionEvent) {
        System.out.println(txtUsername.getText());
        System.out.println(txtPassword.getText());
    }
}
