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

        public String getName() {
            return name;
        }

        public String getSurename() {
            return surename;
        }

        public Date getBirthdate() {
            return birthdate;
        }

        public String getNationality() {
            return nationality;
        }

        public String getCellphone() {
            return Cellphone;
        }

        public List<Reserve> getReserves() {
            return reserves;
        }


    }
}
