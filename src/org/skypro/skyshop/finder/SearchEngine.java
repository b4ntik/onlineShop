package org.skypro.skyshop.finder;

import java.util.Arrays;

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
        for (int i = 0; i < 5; i++) {
            //с помощью trim и lowerCase убираю лишние пробелы и привожу к нижнему регистру
            if (finder[i]!=null && finder[i].searchTerm().trim().toLowerCase().contains(searchString.toLowerCase())) {

                searchResult[i] = finder[i].getStringRepresentation();

            }
        }return Arrays.toString(searchResult);
    }
    }


