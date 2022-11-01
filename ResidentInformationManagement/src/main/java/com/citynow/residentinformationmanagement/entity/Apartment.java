package com.citynow.residentinformationmanagement.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @Column(name = "id", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String id;

    @Column(name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany(mappedBy = "apartment")
    private Set<ApartmentRegister> apartmentRegisters = new LinkedHashSet<>();

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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Set<ApartmentRegister> getApartmentRegisters() {
        return apartmentRegisters;
    }

    public void setApartmentRegisters(Set<ApartmentRegister> apartmentRegisters) {
        this.apartmentRegisters = apartmentRegisters;
    }

}