package org.skypro.skyshop.finder;

import java.util.*;

import org.skypro.skyshop.product.BestResultNotFound;


public class SearchEngine {

    private HashSet<Searchable> finder;

    public SearchEngine() {
        finder = new HashSet<>();

    }

    public void add(Searchable product) {

        finder.add(product);

    }


    public Set search(String searchString){
        SortedSet<Searchable> searchResult = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                //сравнение длин имен продуктов в цикле
                int lenCompare = Integer.compare(o1.getProductName().length(),o2.getProductName().length());
                //если длины равны, сравниваем по имени
                    if(lenCompare !=0){
                        return lenCompare;
                    }
                return o1.getProductName().compareTo(o2.getProductName());
            }
        });

        //с помощью trim и lowerCase убираю лишние пробелы и привожу к нижнему регистру поисковую строку
        String cleanSearchString = searchString.trim().toLowerCase();

        for (Searchable product : finder) {
            //System.out.println(product.getProductName());
            String name = product.getProductName();
            if (name.trim().toLowerCase().contains(cleanSearchString)) {

                searchResult.add(product);
            }
        }

        return searchResult;
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

