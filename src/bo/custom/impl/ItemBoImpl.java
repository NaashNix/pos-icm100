package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

public class ItemBoImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        // Creating Item Entity
        Item item = new Item(
          itemDTO.getItemID(),
          itemDTO.getItemName(),
          itemDTO.getBatchNumber(),
          itemDTO.getPrice(),
          itemDTO.getQty(),
          itemDTO.getSupplier(),
          itemDTO.getExpireDate()
        );

        // save item via ItemDAO
        return itemDAO.save(item);
    }

    @Override
    public String getNextID() {
        String lastItemId = itemDAO.getLastItemId();
        int lastId = Integer.parseInt(lastItemId.substring(1));
        return String.format("I%03d",++lastId);
    }
}
