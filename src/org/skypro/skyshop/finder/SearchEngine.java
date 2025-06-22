package org.skypro.skyshop.finder;

import java.util.*;
import java.util.stream.Collectors;

import org.skypro.skyshop.product.BestResultNotFound;


public class SearchEngine {

    private HashSet<Searchable> finder;

    public SearchEngine() {
        finder = new HashSet<>();

    }

    public void add(Searchable product) {

        finder.add(product);

    }

    public Set<Searchable> search(String searchString) {
        //с помощью trim и lowerCase убираю лишние пробелы и привожу к нижнему регистру поисковую строку
        String cleanSearchString = searchString.trim().toLowerCase();

        //компаратор для списка сравнения по длинам строки
        Comparator<Searchable> comparator = Comparator
                //сравнение длин названий товаров
                .comparingInt((Searchable s) -> s.getProductName().length())
                .thenComparing(Searchable::getProductName);

        return finder.stream()
                //фильтрация по содержанию поисковой строки в продуктовой корзине
                .filter(product -> product.getProductName().trim().toLowerCase().contains(cleanSearchString))
                //сортировка по длине имен
                .sorted(comparator)
                //собираю отсортированные результаты
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public Searchable bestSearch(String searchString) throws BestResultNotFound {
        if (searchString.isBlank()) {
            throw new BestResultNotFound("Пустая строка поиска");
        }

        Searchable bestResult = null;
        int maxCount = 0;
        String cleanSearchString = searchString.trim().toLowerCase();

        for (Searchable product : finder) {

            String str = product.getProductName().trim().toLowerCase();
            if (str.contains(cleanSearchString)) {
                int count = countOccurrences(str, cleanSearchString);
                //поиск значения с наибольшим числом вхождений подстроки
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = product;
                }
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("В поиске ничего не найдено");
        }

        return bestResult;
    }

    // Метод для подсчета количества вхождений подстроки
    private int countOccurrences(String str, String subString) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // Продвигаемся дальше
        }

        return count;
    }

    @Override
    public String toString() {
        return finder.toString();
    }

}

