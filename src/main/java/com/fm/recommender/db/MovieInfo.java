package com.fm.recommender.db;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieInfo {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "snippet")
    private String snippet;
    @Column(name = "embedding")
    private double[] embedding;

    public MovieInfo() {
    }

    public MovieInfo(int id, String title, String snippet, double[] embedding) {
        this.id = id;
        this.title = title;
        this.snippet = snippet;
        this.embedding = embedding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public double[] getEmbedding() {
        return embedding;
    }

    public void setEmbedding(double[] embedding) {
        this.embedding = embedding;
    }
}