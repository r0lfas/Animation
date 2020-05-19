package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Animation")
public class Animation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Letters allowed")
    private String name;

    @Column(name = "genre")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Letters allowed")
    private String genre;

    @Column(name = "year")
    @Pattern(regexp = "^-?\\d+$", message = "Only numbers allowed")
    private String year;


    @Column(name = "groups")
    private String groups;



    public Animation() {
    }

    public Animation(String name, String genre, String year, String groups) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.groups = groups;
    }



    public Animation(int id, String name, String genre, String year, String groups){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
