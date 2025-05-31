package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.finder.SearchEngine;
import org.skypro.skyshop.product.*;
import java.lang.Exception;
import org.skypro.skyshop.text.Article;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleProduct product1;
        DiscountedProduct product2, product5;
        SimpleProduct product3;
        FixPriceProduct product4;
        Article article1;
        Article article2;
        ProductBasket basket = new ProductBasket();
        SearchEngine finder = new SearchEngine();
        article1 = new Article("Это название статьи", "Это текст статьи");
        article2 = new Article("Еще одна статья", "Текст еще одной статьи");
        try {
            product1 = new SimpleProduct("11", 100);
            product2 = new DiscountedProduct("Хлеб", 50, 10);
            product3 = new SimpleProduct("стол", 500);
            product4 = new FixPriceProduct("Салфетки");

            //изменяем объекты с парой товар : цена
            product1.setProduct("20 ", 150);
            product2.setProduct("Хлеб черный", 40);
            product3.setProduct("Стул", 3600);

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
            System.out.println("__________________________");

            //поиск продукта в корзине
            //System.out.println(basket.findProduct("Хлеб черный"));

            //поиск несуществующего товара в корзине
            System.out.println(basket.findProduct("zqqwf"));
            System.out.println("__________________________");

            //добавление товаров в существующую корзину
            basket.setUserBasket(product3);


            //вывод состава полной корзины
            //basket.printBasketComposition();

            //стоимость полной корзины
            System.out.println(basket.getBasketPrice());

            //очистка корзины
            //basket.cleanBasket();

            //печать содержимого пустой корзины
           // basket.printBasketComposition();

            //получение стоимости пустой корзины
            //System.out.println(basket.getBasketPrice());

            //поиск товара в пустой корзине
            //System.out.println(basket.findProduct(""));

            //пополнение корзины
            finder.add(article2);
            finder.add(article1);
            finder.add(product1);
            finder.add(product2);
            finder.add(product3);
            finder.add(product4);


            System.out.println(finder.search("е"));
            System.out.println("__________________________");

            System.out.println(finder.bestSearch("хлеб"));
            System.out.println("__________________________");

           //System.out.println(finder.bestSearch("45"));

            //product2 = new DiscountedProduct("Какое-то имя", 50, 101);

            System.out.println(basket.removeObject("стул"));
            basket.printBasketComposition();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}