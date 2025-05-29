package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
//import org.skypro.skyshop.finder.SearchEngine;

import java.awt.*;
import java.util.LinkedList;

//import

public class ProductBasket {

    private LinkedList<Product> basket, removeProducts;

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
        removeProducts = new LinkedList<>();
        for(Product products : basket){
            if (products.getProductName().equals(name)){

                removeProducts.add(products.getProductName());
                basket.remove(name);
            }
        } return removeProducts;

    }


    //очистка корзины
    public void cleanBasket() {
        for (Product products : basket) {

            basket.remove();
        }

    }

}

