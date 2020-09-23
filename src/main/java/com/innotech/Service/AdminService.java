package com.innotech.Service;

import com.innotech.Entity.SideTable;
import com.innotech.repo.SideTableRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final SideTableRepo sideTableRepo;

    public AdminService(SideTableRepo sideTableRepo) {
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