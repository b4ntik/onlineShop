package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount = 20;

    public DiscountedProduct(String productName, int basePrice) {
        super(productName);
        this.basePrice = basePrice;
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice*discount/100);
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice() + " ( " + discount+ "%)";
    }
}

