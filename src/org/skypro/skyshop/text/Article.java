package org.skypro.skyshop.text;

import org.skypro.skyshop.finder.Searchable;

public class Article implements Searchable {
private String articleTitle;
private String articleBody;

    public Article(String articleTitle, String articleBody){
        this.articleTitle=articleTitle;
        this.articleBody=articleBody;
    }
    public String toString(){
        return "Название статьи" + articleTitle + "\n"+
                "Текст статьи" + articleBody;
    }
}
