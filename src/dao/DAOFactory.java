package dao;


import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.LoginDAOImpl;
import dao.custom.impl.OrderDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        LOGIN, ITEM, CUSTOMER, ORDER
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory == null){
            return daoFactory = new DAOFactory();
        }else{
            return daoFactory;
        }
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case LOGIN:
                return new LoginDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }

    private DAOFactory(){}



}
