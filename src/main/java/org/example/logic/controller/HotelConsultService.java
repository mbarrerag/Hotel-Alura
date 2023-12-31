package org.example.logic.controller;
import org.example.views.SearchReservations;
import org.example.logic.dao.DaoHuesped;
import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;
import org.example.views.SearchReservations;

import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HotelConsultService {




    public static void loadDataReserve() {

        DefaultTableModel modelo = (DefaultTableModel) SearchReservations.tbReservas.getModel();
        modelo.setRowCount(0);

        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation reservaDao = new DaoReservation(em);
        List<Reserve> reserves = reservaDao.getAllReservas();

        for (Reserve reserve : reserves) {
            Object[] fila = new Object[]{
                    reserve.getCheckIn(),
                    reserve.getCheckOut(),
                    reserve.getBookingValue(),
                    reserve.getPaymentMethod()
            };
            modelo.addRow(fila);
        }
    }

    public static void loadDataHuesped() {

        DefaultTableModel modelo = (DefaultTableModel) SearchReservations.tbHuespedes.getModel();
        modelo.setRowCount(0);

        EntityManager em = JPAUtils.getEntityManager();
        DaoHuesped huespedDao = new DaoHuesped(em);
        List<Huesped> huespeds = huespedDao.getAllHuespedes();

        for (Huesped huesped : huespeds) {
            List<Reserve> reserves = huesped.getReserves();
            long numreservas=reserves.size();
            Object[] fila = new Object[]{
                    huesped.getId(),
                    huesped.getName(),
                    huesped.getSurename(),
                    huesped.getBirthdate(),
                    huesped.getNationality(),
                    huesped.getCellphone(),

            };
            modelo.addRow(fila);

        }
    }


    public static void UpdateReserve() {
        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation reserveDao = new DaoReservation(em);
        int selectedRow = SearchReservations.tbReservas.getSelectedRow();

        if (selectedRow != -1) {  // If a row is selected
            Object idReserveObject = SearchReservations.tbReservas.getValueAt(selectedRow, 0);

            try {
                Long idReserve;

                if (idReserveObject instanceof Long) {
                    // If it's already a Long, no need to cast
                    idReserve = (Long) idReserveObject;
                } else if (idReserveObject instanceof String) {
                    // If it's a String, parse it to Long
                    idReserve = Long.parseLong((String) idReserveObject);
                } else {
                    throw new ClassCastException("ID is neither Long nor String");
                }

                // Proceed with updating the Reserve
                Reserve reserve = reserveDao.getById(idReserve);

                reserve.setCheckIn((Date) SearchReservations.tbReservas.getValueAt(selectedRow, 1));
                reserve.setCheckOut((Date) SearchReservations.tbReservas.getValueAt(selectedRow, 2));
                BigDecimal valor = (BigDecimal) SearchReservations.tbReservas.getValueAt(selectedRow, 3);
                reserve.setBookingValue(valor);
                reserve.setPaymentMethod((String) SearchReservations.tbReservas.getValueAt(selectedRow, 4));

                reserveDao.update(reserve);
                em.refresh(reserve);
                loadDataReserve();

            } catch (NumberFormatException | ClassCastException e) {
                // Handle the case where the String cannot be parsed to Long or ID is not Long/String
                System.err.println("Error processing ID: " + e.getMessage());
            }
        }
    }

}

