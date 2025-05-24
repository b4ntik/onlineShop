package org.skypro.skyshop.product;
import java.lang.Exception;
public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) throws Exception {
        super(productName);
        if (discount < 0 || discount > 100 || basePrice <= 0) {
            throw new Exception("Некорректно указаны значения в полях");

        } else {
            this.basePrice = basePrice;
            this.discount = discount;
        }
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getProductPrice() + "(" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public void setProduct(String productName, int basePrice) {
        this.productName = productName;
        this.basePrice = basePrice;
    }

}

