package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;


public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDTO);

    public String getNextID();

    public ObservableList<ItemDTO> getAllItems();

    public ItemDTO getItemByID(String itemID);
}
