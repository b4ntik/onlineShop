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
        return basket.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    //печать содержимого корзины
    public void printBasketComposition() {

        basket.values().forEach(productList-> {
            if (productList != null){
                System.out.println(productList);
            }
        });
        int sumSpecial = getSpecialCount();
        System.out.println("Итого: " + getBasketPrice());
        System.out.println("Специальных товаров: " + sumSpecial);
    }

    //метод для подсчета специальных товаров в корзине
    private int getSpecialCount() {
        return (int) basket.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(product -> product != null && product.isSpecial())
                .count();
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

        removedProducts = new LinkedList<String>();
        synchronized (basket) { // Синхронизация на коллекции
            Iterator<Map.Entry<String, List<Product>>> iterator = basket.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, List<Product>> entry = iterator.next();
                List<Product> valueList = entry.getValue();
                if (valueList != null) {
                    for (Product product : valueList) {
                        if (product.getProductName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
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

