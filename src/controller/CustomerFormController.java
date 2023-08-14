package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerFormController {
    public TextField txtCustomerID;
    public TextField txtContactNumber;
    public TextField txtFirstName;
    public TextField txtAddress;
    public TextField txtLastName;
    public TableView tblCustomers;
    public TableColumn colCustomerID;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colContactNumber;
    public TableColumn colAddress;
    public TableColumn colNIC;
    public JFXButton btnADD;
    public TextField txtNIC;

    public void btnAddOnAction(ActionEvent actionEvent) {

    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
