package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] basket;

    public ProductBasket() {
        basket = new Product[5];
    }

    //метод добавления в корзину
    public void setUserBasket(Product product) {
        boolean added = false;
        for (int i = 0; i < basket.length; i++) {

            if (basket[i] == null) {
                basket[i] = product;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Корзина полная, не удалось добавить продукт");
        }

    }

    //метод получения стоимости товаров в корзине
    public int getBasketPrice() {
        int sumBasket = 0;
        for (Product price : basket) {
            if (price != null) {
                sumBasket += price.getProductPrice();
            }
        }
        return sumBasket;
    }

    //печать содержимого корзины
    public void printBasketComposition() {

        for (Product product : basket) {
            if (product != null) {

                System.out.println(product);

            }

        }

        System.out.println("Итого: " + getBasketPrice());
    }

    //поиск продукта по имени в корзине, оставил получение стринга для поиска заданного значения
    public boolean findProduct(String name) {
        if (basket != null) {
            for (Product containProduct : basket) {
                if (containProduct != null && containProduct.getProductName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    //очистка корзины
    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}

