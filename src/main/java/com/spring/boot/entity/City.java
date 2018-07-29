package com.spring.boot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mint on 7/29/18.
 */
@Entity
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    // ... additional members, often include @OneToMany mappings

    protected City() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nstate: " + this.state;
    }

    // ... etc

}

