package com.citynow.residentinformationmanagement.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String id;

    @Column(name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "area")
    @Type(type = "org.hibernate.type.TextType")
    private String area;

    @OneToMany(mappedBy = "project")
    private Set<Building> buildings = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

}