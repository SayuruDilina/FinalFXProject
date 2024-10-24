package edu.icet.dao;

import edu.icet.dao.custom.Impl.ProductsDaoImpl;
import edu.icet.dao.custom.Impl.SuppliersDaoImpl;
import edu.icet.util.DaoType;

public class DaoFactory {

    private static DaoFactory instance;

    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return null==instance?new DaoFactory():instance;
    }

    public <T extends SuperDao> T getDaoType(DaoType type){
        switch (type){
            case PRODUCTS : return  (T) new ProductsDaoImpl();
            case  SUPPLIERS:return  (T) new SuppliersDaoImpl();
        }
        return null;
    }
}
