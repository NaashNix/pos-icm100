package dao.custom;

import dao.SuperDAO;
import entity.Customer.Customer;

public interface CustomerDAO extends SuperDAO {
    public boolean saveCustomer(Customer customer);
}
