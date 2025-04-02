package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int productPrice;


    public int getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProduct(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //форматирование строки
    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }
}
