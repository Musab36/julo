package com.salajim.musab.atheistquotes;

/**
 * Created by Musab on 11/13/2017.
 */

public class Quotes {
    private String imageUrl;
    private String author;
    private String quote;

    public Quotes(String imageUrl, String author, String quote) {
        this.imageUrl = imageUrl;
        this.author = author;
        this.quote = quote;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }
}
