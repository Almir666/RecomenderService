package com.fm.recommender.db;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class TestMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "snippet")
    private String snippet;
    @Column(name = "embedding")
    private double embedding;

    public TestMovie() {
    }

    public TestMovie(String id, String title, String snippet, double embedding) {
        this.id = id;
        this.title = title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public double getEmbedding() {
        return embedding;
    }

    public void setEmbedding(double embedding) {
        this.embedding = embedding;
    }
}
