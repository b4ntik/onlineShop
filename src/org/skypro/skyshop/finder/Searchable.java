package org.skypro.skyshop.finder;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.text.Article;

public interface Searchable {
    default String searchTerm() {
        return "";
    };

    default String getProductType() {
        return "";
    };

    default String getStringRepresentation() {
        return "";
    };
    default String getProductName(){
        return "";
    }

    //переопределение equals для продуктов
    boolean equals(Product product);

    //переопределение equals для статей
    boolean equals(Article article);
}
