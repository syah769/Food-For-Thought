package com.mobilemocap.ahmadriza.apik.Model;

/**
 * Created by Ahmad Riza on 18/06/2017.
 */

public class Human {
    protected int weight;
    protected int height;
    protected int age;
    protected char gender;
    protected String activ;

    public Human(int weight, int height, int age, char gender, String activ) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.activ = activ;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getActiv() {
        return activ;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setActiv(String activ) {
        this.activ = activ;
    }
}
