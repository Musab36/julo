package com.salajim.musab.atheistquotes.models;

/**
 * Created by Musab on 12/8/2017.
 */

public class Questions {
    private String questionsId;
    private String name;
    private String question;

    public Questions() { }

    public Questions(String questionsId, String name, String question) {
        this.questionsId = questionsId;
        this.name = name;
        this.question = question;
    }

    public String getQuestionsId() {
        return questionsId;
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }
}
