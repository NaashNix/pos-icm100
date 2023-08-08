package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.LoginDAO;

public class LoginBoImpl implements LoginBO {

    @Override
    public boolean checkPassword(String username) {
        LoginDAO loginDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGIN);
        String passwordByUsername = loginDAO.getPasswordByUsername(username);
        return passwordByUsername != null;
        
    }

}
