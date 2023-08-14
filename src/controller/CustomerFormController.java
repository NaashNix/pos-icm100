package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import dto.CustomerDTO;
import entity.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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

    public void initialize(){
        txtCustomerID.setText(customerBO.generateNextCustomerID());
    }



    public void btnAddOnAction(ActionEvent actionEvent) {
        // Validation (Empty Text Validation)
        if(emptyValidation()){
            boolean saveResult = customerBO.saveCustomer(new CustomerDTO(
                    txtCustomerID.getText(),
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    txtNIC.getText(),
                    txtAddress.getText(),
                    txtContactNumber.getText()
            ));

            Alert alert;
            if(saveResult){
                alert = new Alert(Alert.AlertType.INFORMATION, "Customer Saved Successfully!");
            }else{
                alert = new Alert(Alert.AlertType.WARNING, "Customer not saved!");
            }
            alert.show();

            initialize();
            clearFields();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill all text fields");
            alert.show();
        }
    }

    private void clearFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtNIC.clear();
        txtContactNumber.clear();
        txtAddress.clear();
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
