package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEntrada = null;
        Date fechaSalida = null;

        try {
            fechaEntrada = dateFormat.parse("03/10/2023"); // Cambia esta fecha según tus necesidades
            fechaSalida = dateFormat.parse("10/10/2023");  // Cambia esta fecha según tus necesidades
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}