package com.salajim.musab.atheistquotes.models;

/**
 * Created by Musab on 12/13/2017.
 */

public class Answers {
    private String id;
    private String name;
    private String answer;

    public Answers(String answerId, String name, String answer) {
        this.id = answerId;
        this.name = name;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAnswer() {
        return answer;
    }
}
