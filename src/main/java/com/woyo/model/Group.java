package com.woyo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private Set persons = new HashSet(0);

    // Constructors

    /** default constructor */
    public Group() {
    }

    /** full constructor */
    public Group(String name, Set persons) {
        this.name = name;
        this.persons = persons;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getPersons() {
        return this.persons;
    }

    public void setPersons(Set persons) {
        this.persons = persons;
    }

}