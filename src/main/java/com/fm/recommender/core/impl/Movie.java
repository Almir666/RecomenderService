package com.fm.recommender.core.impl;

public class Movie {
    private String id;
    private final String title;
    private final String snippet;
    private final double [] embedding;

    public Movie(String id, String name, String snippet, double[] embedding) {
        this.id = id;
        this.title = name;
        this.snippet = snippet;
        this.embedding = embedding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public double[] getEmbedding() {
        return embedding;
    }

    public String getSnippet() {
        return snippet;
    }
}

