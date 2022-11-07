package com.citynow.residentinformationmanagement.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "parking_type")
public class ParkingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "unit")
    @Type(type = "org.hibernate.type.TextType")
    private String unit;

    @OneToMany(mappedBy = "parkingType")
    private Set<ParkingRegister> parkingRegisters = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<ParkingRegister> getParkingRegisters() {
        return parkingRegisters;
    }

    public void setParkingRegisters(Set<ParkingRegister> parkingRegisters) {
        this.parkingRegisters = parkingRegisters;
    }

}