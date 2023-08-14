package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DashboardController {
    public Label lblCustomerName;
    public Label lblCustomerAddress;
    public TextField txtContactNumber;
    private CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.CUSTOMER);


    public void btnFindOnAction(ActionEvent actionEvent) {
        // Check the customer from contact number
        CustomerDTO searchedCustomer = customerBO.getCustomerByContactNumber(txtContactNumber.getText());
        if(searchedCustomer != null){
            lblCustomerAddress.setText(searchedCustomer.getAddress());
            lblCustomerName.setText(searchedCustomer.getFirstName()+" "+searchedCustomer.getLastName());
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Customer not found!");
            alert.show();
        }

    }
}
