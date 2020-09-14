package com.innotech.repo;

import com.innotech.Entity.SideTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SideTableRepo extends JpaRepository<SideTable, Integer> {
   List <SideTable> findAll();
}