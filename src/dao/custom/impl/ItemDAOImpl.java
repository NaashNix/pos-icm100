package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) {
        try {
            return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?,?,?)",
                    item.getItemID(),
                    item.getItemName(),
                    item.getBatchNumber(),
                    item.getPrice(),
                    item.getQty(),
                    item.getSupplier(),
                    item.getExpireDate()
            );
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public String getLastItemId() {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT*FROM item ORDER BY itemID DESC LIMIT 1");
            if(resultSet.next()){
                return resultSet.getString("itemID");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "I000";
    }
}
