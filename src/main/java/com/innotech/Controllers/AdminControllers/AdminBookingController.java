package com.innotech.Controllers.AdminControllers;

import com.innotech.Entity.Booking;
import com.innotech.Service.BookingService;
import com.innotech.repo.BookingRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")

public class AdminBookingController {
    private final BookingRepo bookingRepo;
    private final BookingService bookingService;

    public AdminBookingController(BookingRepo bookingRepo, BookingService bookingService) {
        this.bookingRepo = bookingRepo;
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    ModelAndView list() {
        return new ModelAndView("/bookings",
                Map.of("Booking", bookingRepo.findAll()),
                HttpStatus.OK);
    }
    @PutMapping("/bookings/{id_booking}/status")
    public String changeStatus(Booking booking, String newStatus){
        if (bookingService.changeBooking(booking)){
            booking.setStatus(newStatus);
        }return "admin/bookings/{id_booking}/status";
    }
}