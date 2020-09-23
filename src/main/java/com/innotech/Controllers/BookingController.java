package com.innotech.Controllers;

import com.innotech.Entity.Booking;
import com.innotech.Entity.SideTable;
import com.innotech.Entity.User;
import com.innotech.Service.BookingService;
import com.innotech.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;
import java.util.Map;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;

    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @PostMapping("/booking")
    public String addBooking(Booking newBooking, User user, SideTable sideTable, Date dateStart, Date dateEnd,
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
}