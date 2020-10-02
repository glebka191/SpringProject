package com.innotech.controllers;

import com.innotech.entity.Booking;
import com.innotech.entity.SideTable;
import com.innotech.entity.User;
import com.innotech.service.BookingService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class BookingControllerTest {

    BookingService bookingServiceMock = Mockito.mock(BookingService.class);
    Booking testBooking = new Booking();
    //@MockBean
    //private BookingService bookingService;

    @Test
    public void addBooking() throws Exception{
        testBooking.setDateStart(new Date());
        testBooking.setDateEnd(new Date());
        testBooking.setUser(new User());
        testBooking.setSideTable(new SideTable());
        Mockito.when(bookingServiceMock.addBooking(testBooking)).thenReturn(true);
        //Mockito.when(bookingService.addBooking(testBooking)).thenReturn(testBooking);
    }

    /*@Test
    @Transactional
    public void bookingHistory() throws Exception{
        testBooking.setUser(new User());
        testBooking.getUser().getBookings().add(testBooking);
    }
     */
}