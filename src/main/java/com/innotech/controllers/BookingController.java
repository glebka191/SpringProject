package com.innotech.controllers;

import com.innotech.entity.Booking;
import com.innotech.entity.SideTable;
import com.innotech.entity.User;
import com.innotech.repo.UserRepo;
import com.innotech.service.BookingService;
import com.innotech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;
import java.util.Map;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;
    private final UserRepo userRepo;

    public BookingController(BookingService bookingService, UserService userService, UserRepo userRepo) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @PostMapping("/booking")
    public String addBooking(Booking newBooking, @AuthenticationPrincipal User user,
                             SideTable sideTable, Date dateStart, Date dateEnd,
                             Map<String, Object> model) {
        if (!bookingService.addBooking(newBooking)) {
            model.put("message", "Уже есть бронь");
            return "booking";
        }
        newBooking.setDateStart(dateStart);
        newBooking.setDateEnd(dateEnd);
        newBooking.setUser(user);
        newBooking.setSideTable(sideTable);

        return "booking";
    }

    @Transactional
    public Booking BookingHistory(Booking booking){
        User user = userRepo.findByUsername(booking.getUser().getUsername());

    }
}