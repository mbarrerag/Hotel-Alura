package org.example.logic.controller;
import org.example.views.SearchReservation;
import org.example.logic.dao.DaoHuesped;
import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;
import org.example.views.SearchReservation;

import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class HotelConsultService {




    private void cargarDatosTablaReserva() {

        DefaultTableModel modelo = (DefaultTableModel) SearchReservation.tbReservas.getModel();
        modelo.setRowCount(0);

        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation reservaDao = new DaoReservation(em);
        List<Reserve> reserves = reservaDao.getAllReservas();

        for (Reserve reserve : reserves) {
            Object[] fila = new Object[]{
                    reserve.getId(),
                    reserve.getCheckIn(),
                    reserve.getCheckOut(),
                    reserve.getBookingValue(),
                    reserve.getPaymentMethod()
            };
            modelo.addRow(fila);
        }
    }



}
