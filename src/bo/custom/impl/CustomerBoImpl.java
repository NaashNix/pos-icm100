package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

public class CustomerBoImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getNic(),
                customerDTO.getAddress(),
                customerDTO.getContactNumber()
        );

        return customerDAO.saveCustomer(customer);
    }
}
