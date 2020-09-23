package com.innotech.Controllers;

import com.innotech.Entity.Booking;
import com.innotech.Entity.MenuBooking;
import com.innotech.Service.MenuBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PutMapping("/{menu_booking_id}")
    public String addMenuBooking(MenuBooking menuBooking, Booking booking){
        if (!menuBookingService.addMenuBookingService(menuBooking)){
            return "/menubooking/{menu_booking_id}";
        }
        booking.setMenuBookings((Set<MenuBooking>) menuBooking);
        return "/menubooking";
    }

    @DeleteMapping("/menu_booking_id")
    public String deleteMenuBooking(MenuBooking menuBooking, Booking booking){
        menuBookingService.deleteMenuBooking(menuBooking.getId());
        return "/menubooking";
    }
}