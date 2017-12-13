package com.salajim.musab.atheistquotes.models;

import org.parceler.Parcel;

/**
 * Created by Musab on 12/8/2017.
 */
@Parcel
public class Questions {
    String questionsId;
    String name;
    String question;

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
