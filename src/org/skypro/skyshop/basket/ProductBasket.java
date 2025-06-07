package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.List;

//import

public class ProductBasket {

    private Map<String, List<Product>> basket = new HashMap<>();
    private LinkedList<String> removedProducts;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    //метод добавления в корзину - добавляем в лист, проверки на null и полноту корзины нет необходимости выполнять
    public void setUserBasket(Product product) {
        basket.put(product.getProductName(), (List<Product>) product);

            }


    //метод получения стоимости товаров в корзине
    public int getBasketPrice() {
        int sumBasket = 0;
        for (List<Product> productList : basket.values()) {
            if (productList != null) {
                for(Product product:productList){
                    if(product != null){
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
                for(Product products : containProduct){
                if (containProduct != null && products.getProductName().trim().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
    }return false;
}
    //метод удаления из корзины по имени
    public LinkedList removeObject(String name){
        removedProducts = new LinkedList<>();
        synchronized (basket) { // Синхронизация на коллекции
            Iterator<Product> iterator = basket.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product != null && product.getProductName().trim().equalsIgnoreCase(name)) {
                    removedProducts.add(product.getProductName());
                    iterator.remove(); // Безопасное удаление
                } else {
                    System.out.println("Список пуст");
                    break;
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

