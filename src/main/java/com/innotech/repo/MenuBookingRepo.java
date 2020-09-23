package com.innotech.repo;

import com.innotech.Entity.Booking;
import com.innotech.Entity.MenuBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuBookingRepo extends JpaRepository<MenuBooking, Integer> {
    MenuBooking findAllByBooking(Booking booking);
}