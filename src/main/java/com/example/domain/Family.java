package com.example.domain;

import java.util.List;

public class Family {
    private String father;
    private String mother;
    private List<String> sibling;

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public List<String> getSibling() {
        return sibling;
    }

    public void setSibling(List<String> sibling) {
        this.sibling = sibling;
    }
}
