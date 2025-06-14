package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.List;

public class ProductBasket {

    private Map<String, List<Product>> basket = new HashMap<>();
    private List<String> removedProducts;

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
    public List<String> removeObject(String name) {

       removedProducts = new LinkedList<String>();//Add commentMore actions
        synchronized (basket) { // Синхронизация на коллекции
            Iterator<Map.Entry<String, List<Product>>> iterator = basket.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, List<Product>> entry = iterator.next();
                List<Product> valueList = entry.getValue();
                if (valueList != null ) {
                    for (Product product : valueList){
                        if (product.getProductName().trim().toLowerCase().equals(name.trim().toLowerCase())){
                            removedProducts.add(entry.getKey());
                            iterator.remove();
                            break;
                        }
                    }
                }
            }
        }

        return removedProducts;
    }


    //очистка корзины
    public void cleanBasket() {
        basket.clear();
    }

}

