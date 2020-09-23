package com.innotech.repo;

import com.innotech.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    Booking findBookingByDateStart(Date start);
    Booking findBookingByDateEnd(Date end);


    //@Query("select a from booking where a.id = ")

}