package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.sql.Date;
import java.time.LocalDate;

public class AddItemController {
    public TextField txtItemId;
    public TextField txtItemName;
    public TextField txtBatchNumber;
    public TextField txtSupplierName;
    public TextField txtItemPrice;
    public DatePicker pickerExpireDate;
    public TextField txtQty;


    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ITEM);

    public void initialize(){
        txtItemId.setText(itemBO.getNextID());
    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        ItemDTO itemDTO = new ItemDTO(
                txtItemId.getText(),
                txtItemName.getText(),
                txtBatchNumber.getText(),
                Double.parseDouble(txtItemPrice.getText()),
                Double.parseDouble(txtQty.getText()),
                txtSupplierName.getText(),
                Date.valueOf(LocalDate.now())
        );

        boolean b = itemBO.saveItem(itemDTO);

    }
}
