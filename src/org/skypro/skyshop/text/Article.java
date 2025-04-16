package org.skypro.skyshop.text;

import org.skypro.skyshop.finder.Searchable;

public class Article implements Searchable {
    private String articleTitle;
    private String articleBody;

    public Article(String articleTitle, String articleBody) {
        this.articleTitle = articleTitle;
        this.articleBody = articleBody;
    }

    @Override
    public String getProductType() {
        return "ARTICLE";
    }

    public String toString() {
        return articleTitle + "\n" + articleBody;
    }

    public String searchTerm() {
        String result = getArticleTitle() + "\n" + getArticleBody();
        return result;
    }

    public String getStringRepresentation() {

        return getArticleTitle() + " - " + getProductType();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleBody() {
        return articleBody;
    }
}
