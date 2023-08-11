package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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
    public TableColumn colItemID;
    public TableColumn colItemName;
    public TableColumn colBatchNo;
    public TableColumn colItemPrice;
    public TableColumn colSupplier;
    public TableColumn colExpireDate;
    public TableView tblItems;


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
