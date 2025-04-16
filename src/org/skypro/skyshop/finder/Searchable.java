package org.skypro.skyshop.finder;

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
}
