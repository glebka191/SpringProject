package com.innotech.repo;

import com.innotech.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepo extends JpaRepository<Menu, Integer> {
    List<Menu> findAll();
    Menu findByTypeFoods(Menu menu);
    Menu findByName(String name);
}