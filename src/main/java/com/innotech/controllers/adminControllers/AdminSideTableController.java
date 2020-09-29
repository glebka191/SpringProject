package com.innotech.controllers.adminControllers;

import com.innotech.entity.SideTable;
import com.innotech.service.SideTableService;
import com.innotech.repo.SideTableRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminSideTableController {
    private final SideTableService sideTableService;
    private final SideTableRepo sideTableRepo;

    public AdminSideTableController(SideTableService sideTableService, SideTableRepo sideTableRepo) {
        this.sideTableService = sideTableService;
        this.sideTableRepo = sideTableRepo;
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin")
    public String addSideTable(Integer size, SideTable sideTable){
        if (!sideTableService.addSideTable(size, sideTable)) {
            return "admin";
        }
        sideTable.setSize(size);
        return "admin";
    }

    @DeleteMapping("/admin/delete")
    public String deleteSideTable(Integer sideTableId, Map<String, Object> model){
        sideTableService.deleteSideTable(sideTableId);
        model.put("Message", "SideTable delete!");
        return "/admin/delete";
    }

    @PutMapping("/admin/update")
    public String updateSideTable(SideTable sideTable, Integer sideTableId){
        SideTable updateSideTable = sideTableService.updateSideTable(sideTable, sideTableId);
        if (updateSideTable == null){
            return "/admin/update";
        } else {
            return "/admin/update";
        }
    }
}