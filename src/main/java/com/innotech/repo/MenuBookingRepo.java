package com.innotech.repo;

import com.innotech.entity.Booking;
import com.innotech.entity.MenuBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuBookingRepo extends JpaRepository<MenuBooking, Integer> {
    MenuBooking findAllByBooking(Booking booking);
}