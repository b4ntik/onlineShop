package org.skypro.skyshop.product;
import java.lang.Exception;
public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 150;

    public FixPriceProduct(String productName) throws Exception{
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getProductName() + " : " + "Фиксированная цена " + getProductPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
