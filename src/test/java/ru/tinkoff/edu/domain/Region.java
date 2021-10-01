package ru.tinkoff.edu.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "REGION")
//@NamedQuery(name = "Region.getAll", query = "SELECT * FROM region")
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

//    @Column(name = "regionName")
//    private String regionName;
//
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Client login for auth
     * (Required)
     */

    /**
     * Client login for auth
     * (Required)
     */
//    @JsonProperty("regionName")
//    public Region setRegionName(String regionName) {
//        this.regionName = regionName;
//        return this;
//    }
//
//    @JsonProperty("regionName")
//    public Region setId(Long id) {
//        this.id = id;
//        return this;
//    }

    /**
     * Client salt
     * (Required)
     */
    @JsonProperty("regionName")
    public String getRegionName() {
        return regionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//
//    @JsonProperty("regionName")
//    public String getRegionName() {
//        return id;
//    }

}
