package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.List;

public class ProductBasket {

    private Map<String, List<Product>> basket = new HashMap<>();
    private LinkedList<String> removedProducts;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    //метод добавления в корзину - добавляем в лист, проверки на null и полноту корзины нет необходимости выполнять
    public void setUserBasket(Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        basket.put(product.getProductName(), productList);

    }


    //метод получения стоимости товаров в корзине
    public int getBasketPrice() {
        int sumBasket = 0;
        for (List<Product> productList : basket.values()) {
            if (productList != null) {
                for (Product product : productList) {
                    if (product != null) {
                        sumBasket += product.getProductPrice();
                    }
                }

            }
        }
        return sumBasket;
    }

    //печать содержимого корзины
    public void printBasketComposition() {
        int sumSpecial = 0;
        for (List<Product> productList : basket.values()) {
            if (productList != null) {

                System.out.println(productList);
            }
            for (Product product : productList) {


                if (product != null && product.isSpecial() == true) {
                    sumSpecial++;
                }
            }
        }

        System.out.println("Итого: " + getBasketPrice());
        System.out.println("Специальных товаров: " + sumSpecial);
    }

    //поиск продукта по имени в корзине, оставил получение стринга для поиска заданного значения
    public boolean findProduct(String name) {
        if (basket != null) {
            for (List<Product> containProduct : basket.values()) {
                for (Product products : containProduct) {
                    if (containProduct != null && products.getProductName().trim().equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //метод удаления из корзины по имени
    public List<Product> removeObject(String name) {

        return basket.remove(name);
    }


    //очистка корзины
    public void cleanBasket() {
        basket.clear();
    }


    public String toString() {

        return removedProducts.toString();
    }

}

