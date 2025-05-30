package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
//import org.skypro.skyshop.finder.SearchEngine;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

//import

public class ProductBasket {
    private LinkedList<Product> basket;
    private LinkedList<String> removedProducts;
    public ProductBasket() {
        basket = new LinkedList<>() ;
    }

    //метод добавления в корзину - добавляем в лист, проверки на null и полноту корзины нет необходимости выполнять
    public void setUserBasket(Product product) {
        basket.add(product);

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
        int sumSpecial = 0;
        for (Product product : basket) {
            if (product != null) {

                System.out.println(product);

            }
            if (product != null && product.isSpecial() == true) {
                sumSpecial++;
            }
        }

        System.out.println("Итого: " + getBasketPrice());
        System.out.println("Специальных товаров: " + sumSpecial);
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
    //метод удаления из корзины по имени
    public LinkedList removeObject(String name){
        removedProducts = new LinkedList<>();
        synchronized (basket) { // Синхронизация на коллекции
            Iterator<Product> iterator = basket.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().equals(name)) {
                    removedProducts.add(product.getProductName());
                    iterator.remove(); // Безопасное удаление
                }
            }
        }
        return removedProducts;
    }


    //очистка корзины
    public void cleanBasket() {
        Iterator<Product> iterator = basket.iterator();
        for (Product products : basket) {

            iterator.remove();
        }

    }
    public String toString(){

        return removedProducts.toString();
    }

}

