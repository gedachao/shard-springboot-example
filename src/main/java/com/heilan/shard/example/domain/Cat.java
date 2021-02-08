package com.heilan.shard.example.domain;

public class Cat {
    private Integer id;

    private String catName;

    private String hobby;

    public Cat() {
    }

    public Cat(Integer id, String catName, String hobby) {
        this.id = id;
        this.catName = catName;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}