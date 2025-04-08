package org.skypro.skyshop.finder;

public interface Searchable {
    void searchTerm(String searchString){
        getStringRepresentation();
    }
    default void getStringRepresentation(){
        System.out.println("Имя " + getStringRepresentation(););
    }
    public void contentType(){
        ;
    }
}
