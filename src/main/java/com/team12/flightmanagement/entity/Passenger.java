package com.team12.flightmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;

    @ManyToMany(mappedBy = "passengers")
    @JsonBackReference
    private List<Aircraft> aircraftList = new ArrayList<>();

    // add aircraft
    public void addAircraft(Aircraft ac) {
        if (!aircraftList.contains(ac)) {
            aircraftList.add(ac);
            ac.getPassengers().add(this);
        }
    }

    // gettters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Aircraft> getAircraftList() { return aircraftList; }
    public void setAircraftList(List<Aircraft> aircraftList) { this.aircraftList = aircraftList; }
}














