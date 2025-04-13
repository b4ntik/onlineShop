package org.skypro.skyshop.finder;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.text.Article;

import java.util.Locale;

public class SearchEngine {

    private Searchable[] finder;
    private String[] searchResult;

    public SearchEngine() {
       Searchable[] finder = new Searchable[10];
       String[] searchResult = new String[5];
       this.finder = finder;
       this.searchResult = searchResult;

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

        for (int i = 0; i < 5; i++) {
            //с помощью trim и lowerCase убираю лишние пробелы и привожу к нижнему регистру
            if (finder[i]!=null && finder[i].searchTerm().trim().toLowerCase().contains(searchString.toLowerCase())) {

                searchResult[i] = finder[i].getStringRepresentation();

            }
        }return searchResult.toString();//"Ничего не найдено";
    }

    public void printFinderContent() {
        for (String items : searchResult) {
            if (items != null) {
                System.out.println(items);
            }
        }

    }

    }


