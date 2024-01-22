package org.example.logic.entitites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The Huesped class represents a guest entity in the hotel management system.
 */
@Entity
@Table(name = "huesped")
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String surename;
    private Date birthdate;
    private String nationality;
    private String cellphone;

    @OneToMany(mappedBy = "huesped")
    private List<Reserve> reserves;

    /**
     * Gets the id of the Huesped entity.
     *
     * @return The id of the Huesped entity.
     */
    public Long getId() {
        return Id;
    }

    /**
     * Sets the id of the Huesped entity.
     *
     * @param id The id to set for the Huesped entity.
     */
    public void setId(Long id) {
        Id = id;
    }

    /**
     * Gets the name of the Huesped.
     *
     * @return The name of the Huesped.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Huesped.
     *
     * @param name The name to set for the Huesped.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname of the Huesped.
     *
     * @return The surname of the Huesped.
     */
    public String getSurename() {
        return surename;
    }

    /**
     * Sets the surname of the Huesped.
     *
     * @param surename The surname to set for the Huesped.
     */
    public void setSurename(String surename) {
        this.surename = surename;
    }

    /**
     * Gets the birthdate of the Huesped.
     *
     * @return The birthdate of the Huesped.
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the Huesped.
     *
     * @param birthdate The birthdate to set for the Huesped.
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Gets the nationality of the Huesped.
     *
     * @return The nationality of the Huesped.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the Huesped.
     *
     * @param nationality The nationality to set for the Huesped.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the cellphone number of the Huesped.
     *
     * @return The cellphone number of the Huesped.
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Sets the cellphone number of the Huesped.
     *
     * @param cellphone The cellphone number to set for the Huesped.
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * Gets the list of reserves associated with the Huesped.
     *
     * @return The list of reserves associated with the Huesped.
     */
    public List<Reserve> getReserves() {
        return reserves;
    }

    /**
     * Sets the list of reserves associated with the Huesped.
     *
     * @param reserves The list of reserves to set for the Huesped.
     */
    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }
}
