package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import entity.Customer;
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
    private CustomerBO customerBO = (CustomerBO)BOFactory.getBoFactory().getBo(BOFactory.BoTypes.CUSTOMER);

    public void btnAddOnAction(ActionEvent actionEvent) {
        // Validation
        if(emptyValidation()){
            System.out.println("All Text Fields Are good!");
        }
    }

    public boolean emptyValidation(){
        return !txtAddress.getText().isEmpty() &&
                !txtContactNumber.getText().isEmpty() &&
                !txtCustomerID.getText().isEmpty() &&
                !txtLastName.getText().isEmpty() &&
                !txtNIC.getText().isEmpty() &&
                !txtFirstName.getText().isEmpty();
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
