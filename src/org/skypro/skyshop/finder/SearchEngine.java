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
        if (searchString == null || searchString.isBlank()){
            throw new Exception();
        }
       int number = 0;
       int index = 0;
       int indexSubstring;
       Searchable searchResult = null;
        String subString = searchString;
        for (int i = 0; i < 10; i++) {
            if (finder[i] != null) {
                String str = finder[i].getStringRepresentation();
                indexSubstring = str.indexOf(subString, index);
                if (indexSubstring != 0) {
                    number++;
                    index = indexSubstring + subString.length();
                    indexSubstring = str.indexOf(subString, index);
                }

                searchResult = finder[number];
            }

            }
if(searchResult == null){
    throw new BestResultNotFound();
}
         return searchResult;
    }
    }


