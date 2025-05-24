package org.skypro.skyshop.product;

import java.lang.Exception;

public class SimpleProduct extends Product {
    private int productPrice;


    public SimpleProduct(String productName, int productPrice) throws Exception {
        super(productName);
        if (productPrice <= 0) {
            throw new Exception();
        } else {

            this.productPrice = productPrice;
        }
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }

    public void setProduct(String productName, int productPrice) throws Exception {
        if (productName.isBlank()) {

            throw new Exception();
        } else {

            this.productName = productName;
            this.productPrice = productPrice;
        }

    }

}

