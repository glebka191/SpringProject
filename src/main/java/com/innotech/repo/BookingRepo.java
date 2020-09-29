package com.innotech.repo;

import com.innotech.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    Booking findBookingByDateStart(Date start);
    Booking findBookingByDateEnd(Date end);


    //@Query("select a from booking where a.id = ")

}