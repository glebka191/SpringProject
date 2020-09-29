package com.innotech.controllers;

import com.innotech.entity.Booking;
import com.innotech.entity.MenuBooking;
import com.innotech.service.MenuBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/menubooking")
public class MenuBookingController {

    private final MenuBookingService menuBookingService;

    public MenuBookingController(MenuBookingService menuBookingService) {
        this.menuBookingService = menuBookingService;
    }

    @PutMapping("/{menu_booking_id}/addbooking")
    public String addMenuBooking(@PathVariable("menu_booking_id") Integer id,
                                 MenuBooking menuBooking, Booking booking){
        if (!menuBookingService.addMenuBookingService(menuBooking)){
            return "/{menu_booking_id}";
        }
        booking.setMenuBookings((Set<MenuBooking>) menuBooking);
        return "/menubooking";
    }

    @DeleteMapping("/{menu_booking_id}/delete")
    public String deleteMenuBooking(@PathVariable("menu_booking_id") Integer id,
                                    MenuBooking menuBooking, Booking booking){
        menuBookingService.deleteMenuBooking(menuBooking.getId());
        return "/menubooking";
    }
}