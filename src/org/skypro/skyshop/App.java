package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        ProductBasket finder = new ProductBasket();
        ProductBasket setBasket = new ProductBasket();
        ProductBasket printBasket = new ProductBasket();
        ProductBasket cleanBasket = new ProductBasket();

        //создаем объекты с парой товар : цена
        product1.setProduct("Молоко", 100);
        product2.setProduct("Хлеб", 50);
        product3.setProduct("стол", 500);

        //создаю новую корзину с товарами - массив из 5 объектов
        ProductBasket[] basket1 = new ProductBasket[5];
        //выводим созданные продукты
        System.out.println(product1.getProductName() + " : " + product1.getProductPrice());
        System.out.println(product2.getProductName() + " : " + product2.getProductPrice());

        //добавляю продукты в корзину
        basket1[0] = new ProductBasket(product1.getProductName(), product1.getProductPrice());
        basket1[1] = new ProductBasket(product2.getProductName(), product2.getProductPrice());

        // вывожу состав корзины
        printBasket.printBasketComposition(basket1);

        //поиск продукта в корзине
        System.out.println(finder.findProduct(basket1, "Хлеб"));

        //поиск несуществующего товара в корзине
        System.out.println(finder.findProduct(basket1, "яйца"));

        //добавление нескольких товаров в существующую корзину
        setBasket.setUserBasket(basket1, product3.getProductName(), product3.getProductPrice());
        setBasket.setUserBasket(basket1, product3.getProductName(), product3.getProductPrice());
        setBasket.setUserBasket(basket1, product3.getProductName(), product3.getProductPrice());
        //добавление товара в полную корзину
        setBasket.setUserBasket(basket1, product3.getProductName(), product3.getProductPrice());
        //вывод состава полной корзины
        printBasket.printBasketComposition(basket1);
        //стоимость полной корзины
        System.out.println(ProductBasket.getBasketPrice(basket1));

        //очистка корзины
        cleanBasket.cleanBasket(basket1);
        //печать содержимого пустой корзины
        printBasket.printBasketComposition(basket1);
        //получение стоимости пустой корзины
        System.out.println(ProductBasket.getBasketPrice(basket1));
        //поиск товара в пустой корзине
        System.out.println(finder.findProduct(basket1, "яйца"));
    }
}