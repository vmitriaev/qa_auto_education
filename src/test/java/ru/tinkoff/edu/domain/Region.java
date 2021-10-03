package ru.tinkoff.edu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "REGION")
public class Region implements Serializable {


    /**
     * Client login for auth
     * (Required)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator")
    private int id;

    @Column(name = "REGION_NAME")
    private String regionName;

    public Region() {

    }

    public Region(int id, String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public int getId() {
        return id;
    }

    public Region setId(int id) {
        this.id = id;
        return this;
    }

    public Region setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

}
