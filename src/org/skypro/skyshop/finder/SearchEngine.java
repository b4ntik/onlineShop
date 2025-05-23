package org.skypro.skyshop.finder;

import java.util.Arrays;

import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Exception;


public class SearchEngine {

    private Searchable[] finder;

    public SearchEngine() {
        Searchable[] finder = new Searchable[10];
        this.finder = finder;
    }

    public void add(Searchable product) {

        for (int i = 0; i < finder.length; i++) {

            if (finder[i] == null) {
                finder[i] = product;
                return;
            }
        }
    }

    public String search(String searchString) {
        String[] searchResult = new String[5];
        int y = 0;
        for (int i = 0; i < 10; i++) {
            //с помощью trim и lowerCase убираю лишние пробелы и привожу к нижнему регистру
            if (finder[i] != null && finder[i].searchTerm().trim().toLowerCase().contains(searchString.toLowerCase()) && y < 5) {

                searchResult[y] = finder[i].getStringRepresentation();
                y++;

            }
        }
        return Arrays.toString(searchResult);
    }

    public Searchable bestSearch(String searchString) throws BestResultNotFound {
        if (searchString == null || searchString.isBlank()) {
            throw new Exception();
        }

        Searchable bestResult = null;
        int maxCount = 0;

        for (int i = 0; i < finder.length; i++) {
            if (finder[i] != null) {
                String str = finder[i].getStringRepresentation();
                int count = countOccurrences(str, searchString);
                //поиск значения с наибольшим числом вхождений подстроки
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = finder[i];
                }
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound();
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
}

