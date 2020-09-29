package com.innotech.service;

import com.innotech.entity.Menu;
import com.innotech.repo.MenuRepo;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepo menuRepo;

    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public boolean addMenu(Menu menu){
        Menu menuFromDb = menuRepo.findByName(menu.getName());
        if (menuFromDb != null) {
            return false;
        }
        menuRepo.save(menu);
        return true;
    }

    public boolean deleteMenu(Menu menu){
        if (menuRepo.findById(menu.getId()).isPresent()){
            menuRepo.deleteById(menu.getId());
            return true;
        }
        return false;
    }

    public boolean changeMenu(Menu menu){
        Menu menuFromDB = menuRepo.findByName(menu.getName());
        if (menuFromDB == null){
            return false;
        }
        menuFromDB.setPrice(menu.getPrice());
        menuFromDB.setName(menu.getName());
        menuFromDB.setTypeFoods(menu.getTypeFoods());
        menuRepo.save(menuFromDB);
        return true;
    }
}