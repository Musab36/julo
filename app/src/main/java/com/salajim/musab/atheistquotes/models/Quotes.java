package com.salajim.musab.atheistquotes.models;

/**
 * Created by Musab on 11/26/2017.
 */

public class Quotes {
    private String quote;
    private String author;
    private String quotesId;

    public Quotes() { }

    public Quotes(String quote, String author, String quotesId) {
        this.quote = quote;
        this.author = author;
        this.quotesId = quotesId;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuotesId() {
        return quotesId;
    }

}
