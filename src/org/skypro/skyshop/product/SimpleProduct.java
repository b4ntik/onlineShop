package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productPrice;


    public SimpleProduct(String productName, int productPrice) {
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

    public void setProduct(String productName, int productPrice) {
        if (productName.isBlank()) {

            throw new Exception();
        } else {

            this.productName = productName;
            this.productPrice = productPrice;
        }

    }

}

