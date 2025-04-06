package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Молоко", 100);
        DiscountedProduct product2 = new DiscountedProduct("Хлеб", 50, 10);
        SimpleProduct product3 = new SimpleProduct("стол", 500);
        FixPriceProduct product4 = new FixPriceProduct("Салфетки");

        ProductBasket basket = new ProductBasket();

        //изменяем объекты с парой товар : цена
        product1.setProduct("Топленое молоко", 150);
        product2.setProduct("Хлеб черный", 40);
        product3.setProduct("Стул", 500);

        //добавка товаров в корзину
        basket.setUserBasket(product1);
        basket.setUserBasket(product3);
        basket.setUserBasket(product2);
        basket.setUserBasket(product4);

        //выводим созданные продукты
        System.out.println(product1.getProductName() + " : " + product1.getProductPrice());
        System.out.println(product2.getProductName() + " : " + product2.getProductPrice());


        // вывожу состав корзины
        basket.printBasketComposition();

        //поиск продукта в корзине
        System.out.println(basket.findProduct("Хлеб черный"));

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