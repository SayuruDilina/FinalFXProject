package edu.icet.bo;

import edu.icet.bo.custom.Impl.ProductsBoImpl;
import edu.icet.bo.custom.Impl.SuppliersBoImpl;
import edu.icet.util.BoType;

public class BoFactory {

    private static BoFactory instance;

    private BoFactory(){}


    public static BoFactory getInstance() {
        return null==instance?new BoFactory():instance;
    }
    public <T extends SuperBo>T getBoType(BoType type){
        switch (type){
            case  PRODUCTS : return (T) new ProductsBoImpl();
            case SUPPLIERS:return  (T) new SuppliersBoImpl();
        }

        return null;
    }
}
