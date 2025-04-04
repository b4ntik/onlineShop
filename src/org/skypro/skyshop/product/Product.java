package org.skypro.skyshop.product;

public abstract class Product {
    protected String productName;

    public Product(String productName) {
    this.productName = productName;
    }


    //private int productPrice;

    //public Product(String productName) {
      //  this.productName = productName;
    //}


    public abstract int getProductPrice();

    public String getProductName() {
        return productName;
    }

    public void setProduct(String productName, int productPrice) {
        this.productName = productName;
        //this.productPrice = productPrice;
    }

    //форматирование строки
    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice();
    }


}
