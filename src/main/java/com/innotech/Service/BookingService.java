package com.innotech.Service;

import com.innotech.Entity.Booking;
import com.innotech.repo.BookingRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;

    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public boolean addBooking(Booking booking){
        Booking bookingDBStart = bookingRepo.findBookingByDateStart(booking.getDateStart());
        Booking bookingDBend = bookingRepo.findBookingByDateEnd(booking.getDateEnd());

        if (bookingDBStart != null && bookingDBend != null) {
            return false;
        }
        booking.setStatus("В работе");
    bookingRepo.save(booking);
    return true;
    }

    public boolean changeBooking(Booking booking){
        if (bookingRepo.getOne(booking.getId())!= null) {
            bookingRepo.save(booking);
        return true;
        } return false;
    }
}