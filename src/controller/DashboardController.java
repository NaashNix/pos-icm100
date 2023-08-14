package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.ItemBO;
import bo.custom.OrderBO;
import com.jfoenix.controls.JFXComboBox;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class DashboardController {
    public Label lblCustomerName;
    public Label lblCustomerAddress;
    public TextField txtContactNumber;
    private final CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.CUSTOMER);
    private final ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ITEM);
    private final OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ORDER);

    public JFXComboBox<String> cmbItemSelector;
    public Label lblOrderID;

    public void initialize(){
        setItemNames();

        // Getting Next OrderID
        lblOrderID.setText(orderBO.generateNextOrderID());
    }

    private void setItemNames() {
        HashMap<String, String> itemNamesAndIDs = itemBO.getItemNamesAndIDs();
        itemNamesAndIDs.forEach((key,value) -> {
            cmbItemSelector.getItems().add(value);
        });
    }


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
