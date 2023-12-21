package org.example.logic.entitites;
import  javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
public class Huesped {


    @Entity
    @Table(name = "huesped")
    public class  huesped {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String name;

        private String surename;
        private Date birthdate;
        private String nationality;
        private String Cellphone;
        @OneToMany(mappedBy = "huesped")
        private List<Reserve> reserves;

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurename() {
            return surename;
        }

        public void setSurename(String surename) {
            this.surename = surename;
        }

        public Date getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getCellphone() {
            return Cellphone;
        }

        public void setCellphone(String cellphone) {
            Cellphone = cellphone;
        }

        public List<Reserve> getReserves() {
            return reserves;
        }

        public void setReserves(List<Reserve> reserves) {
            this.reserves = reserves;
        }
    }
}
