package com.woyo.model;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

    // Fields

    private Integer id;
    private Group group;
    private String name;
    private String password;

    // Constructors

    /** default constructor */
    public Person() {
    }

    /** full constructor */
    public Person(Group group, String name, String password) {
        this.group = group;
        this.name = name;
        this.password = password;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}