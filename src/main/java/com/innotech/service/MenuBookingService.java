package com.innotech.service;

import com.innotech.entity.MenuBooking;
import com.innotech.repo.MenuBookingRepo;
import org.springframework.stereotype.Service;

@Service
public class MenuBookingService {

    private final MenuBookingRepo menuBookingRepo;

    public MenuBookingService(MenuBookingRepo menuBookingRepo) {
        this.menuBookingRepo = menuBookingRepo;
    }

    public boolean addMenuBookingService(MenuBooking menuBooking){
        if (menuBooking != null) {
            menuBookingRepo.save(menuBooking);
            return true;
        }
        return false;
    }

    public boolean deleteMenuBooking(Integer menuBookingId){
        if (menuBookingRepo.findById(menuBookingId).isPresent()){
            menuBookingRepo.deleteById(menuBookingId);
            return true;
        }
        return false;
    }
}