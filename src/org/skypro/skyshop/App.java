package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        ProductBasket basket = new ProductBasket();

        //создаем объекты с парой товар : цена
        product1.setProduct("Молоко", 100);
        product2.setProduct("Хлеб", 50);
        product3.setProduct("стол", 500);

        //добавка товаров в корзину
        basket.setUserBasket(product1);
        basket.setUserBasket(product3);
        basket.setUserBasket(product2);

        //выводим созданные продукты
        System.out.println(product1.getProductName() + " : " + product1.getProductPrice());
        System.out.println(product2.getProductName() + " : " + product2.getProductPrice());


        // вывожу состав корзины
        basket.printBasketComposition();

        //поиск продукта в корзине
        System.out.println(basket.findProduct("Хлеб"));

        //поиск несуществующего товара в корзине
        System.out.println(basket.findProduct("zqqwf"));

        //добавление товаров в существующую корзину с превышением лимита
        basket.setUserBasket(product3);
        basket.setUserBasket(product3);
        basket.setUserBasket(product3);

        //вывод состава полной корзины
        basket.printBasketComposition();

        //стоимость полной корзины
        System.out.println(basket.getBasketPrice());

        //очистка корзины
        basket.cleanBasket();

        //печать содержимого пустой корзины
        basket.printBasketComposition();

        //получение стоимости пустой корзины
        System.out.println(basket.getBasketPrice());

        //поиск товара в пустой корзине
        System.out.println(basket.findProduct(""));
    }
}