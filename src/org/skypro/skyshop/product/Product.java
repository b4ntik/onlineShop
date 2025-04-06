package org.skypro.skyshop.product;

public abstract class Product {
    protected String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract int getProductPrice();

    public String getProductName() {
        return productName;
    }


    //форматирование строки
    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }
}

