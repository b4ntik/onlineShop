package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productPrice;


    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }

    public void setProduct(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

}

