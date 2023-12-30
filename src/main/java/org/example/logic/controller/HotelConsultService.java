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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HotelConsultService {




    public static void loadDataReserve() {

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

    public static void loadDataHuesped() {

        DefaultTableModel modelo = (DefaultTableModel) SearchReservation.tbHuespedes.getModel();
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


    private void UpdateReserve() {

        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation reserveDao = new DaoReservation(em);
        int selectedRow = SearchReservation.tbReservas.getSelectedRow();
        if (selectedRow != -1) {  // Si hay una fila seleccionada
            Long idReserve = (Long) SearchReservation.tbReservas.getValueAt(selectedRow, 0);
            Reserve reserve = reserveDao.getById(idReserve);

            reserve.setCheckIn((Date) SearchReservation.tbReservas.getValueAt(selectedRow, 1));
            reserve.setCheckOut((Date) SearchReservation.tbReservas.getValueAt(selectedRow, 2));
            BigDecimal valor = (BigDecimal) SearchReservation.tbReservas.getValueAt(selectedRow, 3);
            reserve.setBookingValue(valor);
            reserve.setPaymentMethod((String)SearchReservation.tbReservas.getValueAt(selectedRow, 4));

            reserveDao.update(reserve);
            em.refresh(reserve);
            loadDataReserve();
        }
    }
}
