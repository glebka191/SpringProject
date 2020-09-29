package com.innotech.service;

import com.innotech.entity.SideTable;
import com.innotech.repo.SideTableRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SideTableService {
    private final SideTableRepo sideTableRepo;

    public SideTableService(SideTableRepo sideTableRepo) {
        this.sideTableRepo = sideTableRepo;
    }

    public boolean addSideTable(Integer size, SideTable sideTable){
        sideTableRepo.save(sideTable);
    return true;
    }

    public boolean deleteSideTable(Integer sideTableId){
        if (sideTableRepo.findById(sideTableId).isPresent()){
            sideTableRepo.deleteById(sideTableId);
            return true;
        }
        return false;
    }

    public SideTable updateSideTable(SideTable sideTable, Integer sideTableId){
        sideTable.setId(sideTableId);
        Optional<SideTable> sideTableDb = sideTableRepo.findById(sideTableId);
            if (sideTableDb.isPresent()){
                sideTable.setSize(sideTable.getSize());
                sideTableRepo.save(sideTable);
                return sideTable;
            }
            return null;
    }
}