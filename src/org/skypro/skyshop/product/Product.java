package org.skypro.skyshop.product;

import org.skypro.skyshop.finder.Searchable;

public abstract class Product implements Searchable {
    protected String productName;

    public Product(String productName) throws Exception{
        if (productName.isBlank()) {
            throw new Exception();
        } else {
            this.productName = productName;
        }


    }

    public boolean isSpecial() {
        return false;
    }

    public abstract int getProductPrice();

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return "PRODUCT";
    }

    public String getStringRepresentation() {

        return getProductName() + " - " + getProductType();
    }


    //форматирование строки
    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }

    @Override
    public String searchTerm() {
        return productName;

    }

}

