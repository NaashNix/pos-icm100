package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {

    public TextField txtUsername;
    public PasswordField txtPassword;

    LoginBO loginBO = BOFactory.getBoFactory().getBo(BOFactory.BoTypes.LOGIN);

    public void btnLoginOnClick(ActionEvent actionEvent) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        Boolean result = loginBO.checkPassword(username,password);

    }
}
